package com.my.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({"com.my.scaffold"})
@MapperScan("com.my.scaffold.dal.mapper")
public class MyScaffoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyScaffoldApplication.class, args);
	}

}

