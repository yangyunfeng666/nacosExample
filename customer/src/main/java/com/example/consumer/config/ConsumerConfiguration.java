package com.example.consumer.config;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableDubbo
//@NacosPropertySource(dataId = "consumer.properties",groupId = "ff")
@PropertySource("classpath:/dubbo-consumer.properties")
@Configuration
public class ConsumerConfiguration {

}
