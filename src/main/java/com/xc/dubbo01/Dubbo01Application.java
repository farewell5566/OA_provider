package com.xc.dubbo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xc.dubbo01.mapper")
public class Dubbo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Dubbo01Application.class, args);
	}

}
