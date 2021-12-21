package com.niteshb.spring5webapp.bootstrap;

import com.niteshb.spring5webapp.models.Author;
import com.niteshb.spring5webapp.models.Book;
import com.niteshb.spring5webapp.models.Publisher;
import com.niteshb.spring5webapp.repositories.AuthorRepo;
import com.niteshb.spring5webapp.repositories.BookRepo;
import com.niteshb.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;


@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("IEEE Publishing");
        publisher.setAddressLine1("44 Marine Drive");
        publisher.setCity("Sydney");
        publisher.setState("NSW");

        publisherRepo.save(publisher);

        System.out.println("Publisher is set: " + publisher.toString());

        Author eric = new Author("Eric", "Baldwin");
        Book eric_book = new Book("Domain Driven Design", "12321");
        eric.getBooks().add(eric_book);
        eric_book.getAuthors().add(eric);

        eric_book.setPublisher(publisher);
        publisher.getBooks().add(eric_book);

        authorRepo.save(eric);
        bookRepo.save(eric_book);
        publisherRepo.save(publisher);

        Author rod = new Author("Rod", "JohnSon");
        Book rod_book = new Book("JAva Development Book", "45454323");
        rod.getBooks().add(rod_book);
        rod_book.getAuthors().add(rod);

        rod_book.setPublisher(publisher);
        publisher.getBooks().add(rod_book);
        authorRepo.save(rod);
        bookRepo.save(rod_book);


        System.out.println("Number of books: " +  bookRepo.count());
        System.out.println("Number of books by Publisher: " + publisher.getBooks().size());

    }
}
