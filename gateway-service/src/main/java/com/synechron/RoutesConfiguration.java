package com.synechron;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

	//http://localhost:9091/math/square/12   --> Original mapping
	
	//End users access math service like this
	//http://localhost:7000/sq/12
	//http://localhost:7000/cu/12
	
	@Bean
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("routes-for-math-square-service", 
						route -> 
							route.path("/sq/**")
							.filters(filter -> filter.stripPrefix(1).prefixPath("/math/square"))
							.uri("lb://math-service")
							//.uri("http://localhost:9091/math/square")
				)
				.route("routes-for-math-cube-service", 
						route -> 
							route.path("/cu/**")
							.filters(filter -> filter.stripPrefix(1).prefixPath("/math/cube"))
							.uri("lb://math-service")
				)
				.route("routes-for-calc-sub-service", 
						route -> 
							route.path("/diff/**")
							.filters(filter -> filter.stripPrefix(1).prefixPath("/calc/subtract"))
							.uri("lb://calc-service")
				)
				.route("routes-for-calc-add-service", 
						route -> 
							route.path("/sum/**")
							.filters(filter -> filter.stripPrefix(1).prefixPath("/calc/add"))
							.uri("lb://calc-service")
				)
				.build();
	}
	
}
