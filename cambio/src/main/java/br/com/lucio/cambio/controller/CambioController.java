package br.com.lucio.cambio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.cambio.model.Cambio;
import br.com.lucio.cambio.repository.CambioRepository;

@RestController
@RequestMapping("cambio")
public class CambioController {

	@Autowired
	private Environment enviroment;
	
	@Autowired
	private CambioRepository repository;
	
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
		var port = enviroment.getProperty("local.server.port");
		var cambio = repository.findByFromAndTo(from, to);
		
		if (Objects.isNull(cambio)) throw new RuntimeException("Currency unsuported");
		
		BigDecimal convertedValue = cambio.getConversionFactor().multiply(amount);
		
		return Cambio.builder()
				.id(cambio.getId())
				.to(cambio.getTo())
				.from(cambio.getFrom())
				.enviroment(port)
				.conversionFactor(cambio.getConversionFactor())
				.convertedValue(convertedValue.setScale(2, RoundingMode.CEILING))
			.build();

	}
	
}
