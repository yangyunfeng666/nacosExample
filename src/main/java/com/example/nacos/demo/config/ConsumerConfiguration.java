package com.example.nacos.demo.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.PropertySource;

//@EnableNacosConfig
//@NacosPropertySource(dataId = "consumer.properties",groupId = "ff")
@PropertySource("classpath:/dubbo-consumer.properties")
public class ConsumerConfiguration {

}
