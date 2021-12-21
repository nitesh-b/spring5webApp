package com.niteshb.spring5webapp.repositories;

import com.niteshb.spring5webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
