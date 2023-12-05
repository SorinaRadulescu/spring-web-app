package com.example.learningspring.repositories;

import com.example.learningspring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
