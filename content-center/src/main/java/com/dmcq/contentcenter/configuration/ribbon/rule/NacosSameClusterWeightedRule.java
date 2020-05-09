package com.dmcq.contentcenter.configuration.ribbon.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description: 同集群优先+Nacos权重负载均衡规则
 * @author: qinhao25
 * @time: 2020/1/15 14:39
 */
@Slf4j
public class NacosSameClusterWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object o) {
        try {
            // 拿到配置文件中的集群名称
            String clusterName = nacosDiscoveryProperties.getClusterName();
            // 获取微服务名称
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            String serverName = loadBalancer.getName();
            // 获取服务发现相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

            // 1.找到指定服务的所有实例 A
            List<Instance> instances = namingService.selectInstances(serverName, true);
            // 2.过滤出相同集群下的所有实例 B
            List<Instance> sameClusterInstances = instances.stream()
                    .filter(instance -> Objects.equals(instance.getClusterName(), clusterName))
                    .collect(Collectors.toList());
            // 3.若B为空，则用A
            List<Instance> instancesToBeChoose = new ArrayList<Instance>();
            if(CollectionUtils.isEmpty(sameClusterInstances)){
                instancesToBeChoose = instances;
                //log.warn("发生了跨集群调用，serverName={},clusterName={},instances={}", serverName, clusterName, instancesToBeChoose);
            } else {
                instancesToBeChoose = sameClusterInstances;
            }
            // 4.基于权重的负载均衡算法，返回一个实例
            Instance instance = CustomBalancer.customGetHostByRandomWeight(instancesToBeChoose);
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
    }
}

class CustomBalancer extends Balancer {
    public static Instance customGetHostByRandomWeight(List<Instance> hosts){
        return getHostByRandomWeight(hosts);
    }
}