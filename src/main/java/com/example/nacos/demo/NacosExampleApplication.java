package com.example.nacos.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@EnableNacos( globalProperties = @NacosProperties(serverAddr = "${nacos.server-addr:localhost:8848}"))
@NacosPropertySources( {@NacosPropertySource( dataId = "dddd",groupId = "ds",autoRefreshed = true)
})
public class NacosExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosExampleApplication.class, args);
    }
}
