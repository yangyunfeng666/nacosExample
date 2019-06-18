package com.example.provider.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@NacosPropertySource(dataId = "provider.properties",groupId = "ff")
@PropertySource("classpath:/dubbo-provider.properties")
@Configuration
public class ProviderConfiguration {

}
