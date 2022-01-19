package br.com.lucio.client;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio", url = "localhost:8000")
public interface CambioClient {

	@GetMapping(value = "/cambio/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to);
	
}