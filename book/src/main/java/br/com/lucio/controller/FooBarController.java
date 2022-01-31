package br.com.lucio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("foo-bar")
@Slf4j
public class FooBarController {

	@GetMapping
	@Retry(name = "foo-bar", fallbackMethod = "methodWithError") //pode configurar no aplication.yml
	public String fooBar() {
		log.info("Request to foo-bar is received.");
		var response = new RestTemplate().getForEntity("http://localhost:1234/foo-bar", String.class);
		return response.getBody();
		
	}
	
	public String methodWithError(Exception e) {
		return "methodWithError: " + e.getMessage();
	}
	
}
