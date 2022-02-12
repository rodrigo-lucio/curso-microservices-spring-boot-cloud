package br.com.lucio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("foo-bar")
@Slf4j
public class FooBarController {

	// @CircuitBreaker =funciona igual o Retry, porem é inteligente, nao fica entrando no metodo sempre. A cada pouco ele entrará no metodo para ver se ainda esta com erro ou nao, 
	// e dependendo disso, joga para o fallback ou nao
	// Se mandar várias requisiçoes de uma só vez, e estiver com erro, ele nao vai entrar no metodo, logo a mensagem do log.info nao sera exibida.
	// Estilo um disjuntor de casa.
	
	@GetMapping
	//@Retry(name = "foo-bar", fallbackMethod = "methodWithError") //pode configurar no aplication.yml
	//@CircuitBreaker(name = "foo-bar", fallbackMethod = "methodWithError") 
	//@RateLimiter(name = "default", fallbackMethod = "methodWithError")
	@Bulkhead(name = "default", fallbackMethod = "methodWithError")
	public String fooBar() {

		log.info("Request to foo-bar is received.");
		var response = new RestTemplate().getForEntity("http://localhost:1234/foo-bar", String.class);
		return response.getBody();
		
	}
	
	public String methodWithError(Exception e) {
		return "methodWithError: " + e.getMessage();
	}
	
}
