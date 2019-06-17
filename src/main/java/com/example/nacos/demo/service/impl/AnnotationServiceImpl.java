package com.example.nacos.demo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.example.nacos.demo.service.AnnotationService;

@Service(version = "${demo.service.version:0.0.0}")
public class AnnotationServiceImpl implements AnnotationService {


    @Override
    public String sayHello(String name){
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                "",
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name);
    }
}