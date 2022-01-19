package br.com.lucio.cambio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucio.cambio.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Optional<Cambio> findByFromAndTo(String from, String to);
	
}