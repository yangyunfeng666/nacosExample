package com.example.nacos.demo.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableNacosConfig
//@NacosPropertySource(dataId = "provider.properties",groupId = "ff")
@EnableDubbo(scanBasePackages = "com.example.nacos.demo.service")
@PropertySource("classpath:/dubbo-provider.properties")
@Configuration
public class ProviderConfiguration {

}
