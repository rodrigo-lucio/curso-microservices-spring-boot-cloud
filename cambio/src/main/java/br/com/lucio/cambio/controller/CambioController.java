package br.com.lucio.cambio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.cambio.model.Cambio;
import br.com.lucio.cambio.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
@Tag(name = "Cambio Endpoint")
@RestController
@RequestMapping("cambio")
@Slf4j
public class CambioController {

	@Autowired
	private Environment enviroment;
	
	@Autowired
	private CambioRepository repository;
	
	@Operation(description = "Get cambio from currency")
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
		var port = enviroment.getProperty("local.server.port");
		var cambio = repository.findByFromAndTo(from, to)
				.orElseThrow(() -> new EmptyResultDataAccessException("Currency not found", 1));
		log.info("getCambio is called with -> {}, {}, {}", amount, from, to);		
		BigDecimal convertedValue = cambio.getConversionFactor().multiply(amount);
		cambio.setEnviroment(port);
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		return cambio;

	}
	
}
