package br.com.lucio.cambio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucio.cambio.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
	
}