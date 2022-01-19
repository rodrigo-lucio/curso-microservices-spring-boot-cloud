package br.com.lucio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucio.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
