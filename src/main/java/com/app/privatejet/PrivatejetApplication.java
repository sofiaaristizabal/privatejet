package com.app.privatejet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration.class,
		org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class
})
@EnableCaching
public class PrivatejetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivatejetApplication.class, args);
	}

}
