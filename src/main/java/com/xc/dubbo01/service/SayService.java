package com.xc.dubbo01.service;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",timeout = 100000,interfaceClass = ISayService.class)
public class SayService implements ISayService {
    @Override
    public String say(String name) {
        return name +" 地瓜来了";
    }
}
