package com.example.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.common.demo.service.MinorityService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${demo.service.version:0.0.0}")
public class MinorityServiceImpl implements MinorityService {

    @NacosValue(value = "${demo.service.name}",autoRefreshed = true)
    private String serviceName;

    @Override
    public String sayHello(String name){
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name);
    }
}