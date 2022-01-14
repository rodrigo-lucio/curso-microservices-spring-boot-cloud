package br.com.lucio.greeting.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
@Data
@NoArgsConstructor
public class GreetingConfiguration {

	private String greeting;
	private String defaultValue;

}