package com.niteshb.spring5webapp.repositories;

import com.niteshb.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
