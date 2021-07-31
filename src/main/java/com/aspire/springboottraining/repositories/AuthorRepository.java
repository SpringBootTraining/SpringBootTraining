package com.aspire.springboottraining.repositories;

import com.aspire.springboottraining.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
