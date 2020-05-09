package configuration;

import com.dmcq.contentcenter.configuration.ribbon.rule.NacosSameClusterWeightedRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 全局配置负载均衡规则
 * 避免被SpringBootApplication扫描到，以防上下文重叠
 * @author: qinhao25
 * @time: 2020/1/15 10:52
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new NacosSameClusterWeightedRule();
    }
}
