package br.com.lucio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  br.com.lucio.client.CambioClient;
import br.com.lucio.model.Book;
import br.com.lucio.repository.BookRepository;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioClient client;
	
	@GetMapping(value = "/{id}/{currency}")
	private Book findBook(@PathVariable Long id, @PathVariable String currency) {
		var port = environment.getProperty("local.server.port");
		var book = repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Book not found", 1));
		
		var cambio = client.getCambio(book.getPrice(), "USD", currency);
		
		book.setEnvironment(String.format("Book port: %s - Cambio port: %s", port , cambio.getEnviroment()));
		book.setPrice(cambio.getConvertedValue());
		return book;
	}
	
}
