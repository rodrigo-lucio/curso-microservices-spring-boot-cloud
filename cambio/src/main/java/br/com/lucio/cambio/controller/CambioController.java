package br.com.lucio.cambio.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.cambio.model.Cambio;

@RestController
@RequestMapping("cambio")
public class CambioController {

	@Autowired
	private Environment enviroment;

	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {

		return null;
	}

}
