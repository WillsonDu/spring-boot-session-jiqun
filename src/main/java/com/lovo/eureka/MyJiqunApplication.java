package com.lovo.eureka;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60) //开启redis缓存session服务，并设置过期时间
public class MyJiqunApplication {

	@Value("${dx.name}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(MyJiqunApplication.class, args);
	}

	@RequestMapping("get")
	public String get(final HttpServletRequest request) {
		return name + " : " + request.getSession().getId();
	}

}
