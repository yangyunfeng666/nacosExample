package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.example.common.demo.service.AnnotationService;
import com.example.common.demo.service.MinorityService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("config")
@EnableDubbo
public class ConfigController {

    @NacosValue(value = "${uwdd:0}",autoRefreshed = true)
    private int value;

    @NacosInjected(properties = @NacosProperties(encode = "UTF-8"))
    private NamingService namingService2;

    @NacosInjected
    private ConfigService configService;

    @RequestMapping(value = "/dd",method = RequestMethod.GET)
    @ResponseBody
    public int getConfit(){
        return value;
    }


    @RequestMapping(value = "/service",method = RequestMethod.GET)
    @ResponseBody
    public List<Instance> getService(@RequestParam String serviceName) throws NacosException {
        return namingService2.getAllInstances(serviceName);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
        public String  getConfig(@RequestParam String dataId,@RequestParam String group) throws NacosException {
        return configService.getConfig(dataId,group,4000);
    }

    @RequestMapping(value = "/set",method = RequestMethod.POST)
    @ResponseBody
    public boolean  setConfig(@RequestParam String dataId,@RequestParam String group,@RequestParam String content) throws NacosException {
        return configService.publishConfig(dataId,group,content);
    }

    @RequestMapping(value = "/registerService",method = RequestMethod.GET)
    @ResponseBody
    public void registerService(@RequestParam String serviceName) throws NacosException {
//        Instance instance = new Instance();
//
//        instance.setIp("192.168.1.127");
//
//        instance.setPort(23105);
//
//        instance.setHealthy(true);
//
//        instance.setWeight(2.0);
//
//        Map<String, String> instanceMeta = new HashMap<>();
//
//        instanceMeta.put("site", "et2");
//
//        instance.setMetadata(instanceMeta);
//
//        namingService2.registerInstance(serviceName, instance);
      namingService2.registerInstance(serviceName,"127.0.0.1",8081);
    }

    @Reference(version = "${demo.service.version}")
    AnnotationService annotationService;

    @Reference(version = "${demo.service.version}")
    MinorityService minorityService;

    @RequestMapping(value = "/dubbo",method = RequestMethod.GET)
    @ResponseBody
    public String getDubbo(@RequestParam("param") String pa){
        return  annotationService.sayHello(pa);
    }

    @RequestMapping(value = "/mini",method = RequestMethod.GET)
    @ResponseBody
    public String getMiniority(@RequestParam("param") String pa){
        return  minorityService.sayHello(pa);
    }
}
