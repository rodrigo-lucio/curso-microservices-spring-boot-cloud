package br.com.lucio.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/get") //
					.filters(f -> f.addRequestHeader("Hello", "World")
								   .addRequestParameter("Oi", "Tudo"))
					.uri("http://httpbin.org:80"))
				.route(p -> p.path("/cambio/**")
							 .uri("lb://cambio"))		//Load balancer do eureka
				.route(p -> p.path("/book/**")
						.uri("lb://book"))				//Load balancer do eureka
				.build();
		
	}
	
}
