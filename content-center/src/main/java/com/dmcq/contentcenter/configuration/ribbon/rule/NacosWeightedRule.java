package com.dmcq.contentcenter.configuration.ribbon.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: Nacos权重负载均衡规则
 * @author: qinhao25
 * @time: 2020/1/15 14:39
 */
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object o) {
        try {
            // 获取微服务名称
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            String serverName = loadBalancer.getName();
            // 获取服务发现相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            // 获取一个实例
            Instance instance = namingService.selectOneHealthyInstance(serverName);
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
    }
}
