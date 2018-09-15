package com.issimo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.issimo.mybatis.mapper")
@SpringBootApplication
public class SpringBootDemoMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoMybatisApplication.class, args);
	}
}
