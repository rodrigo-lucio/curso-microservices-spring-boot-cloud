package br.com.lucio.greeting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("greeting-service")
@NoArgsConstructor
@Data
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;

}
