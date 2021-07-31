package com.aspire.springboottraining.repositories;

import com.aspire.springboottraining.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
