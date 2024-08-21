package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import com.example.apigateway.model.Demo;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("demo-microservice", p -> p
						.path("/demo").and().method(HttpMethod.POST).and().readBody(Demo.class, s -> true)
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://localhost:8081"))
				.build();
	}

}
