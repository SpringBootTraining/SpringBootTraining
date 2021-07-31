package com.aspire.springboottraining.repositories;


import com.aspire.springboottraining.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
