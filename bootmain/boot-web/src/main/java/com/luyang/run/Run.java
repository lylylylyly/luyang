package com.luyang.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableSwagger2
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
// @EnableEurekaClient
// @EnableZuulProxy
@MapperScan("com.luyang.pigmapper")
@ComponentScan("com.luyang")
public class Run extends SpringBootServletInitializer {

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String home() {
		return "Hello Home!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Run.class);
	}

}
