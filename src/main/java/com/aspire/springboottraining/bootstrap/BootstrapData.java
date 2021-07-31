package com.aspire.springboottraining.bootstrap;

import com.aspire.springboottraining.model.Author;
import com.aspire.springboottraining.model.Book;
import com.aspire.springboottraining.model.Publisher;
import com.aspire.springboottraining.repositories.AuthorRepository;
import com.aspire.springboottraining.repositories.BookRepository;
import com.aspire.springboottraining.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a publisher
        Publisher aliPublisher = new Publisher("Ali", "Nader");
        // Save the publisher
        publisherRepository.save(aliPublisher);


        //Create Book and Author
        Author eric = new Author("Eric", "Evans");
        Book jungle = new Book("Journey in the Jungle", "12345");

        // Add the book to Author books set and vise versa.
        eric.getBooks().add(jungle);
        jungle.getAuthors().add(eric);

        // Save the book and the author in H2DB.
        authorRepository.save(eric);
        bookRepository.save(jungle);

        // Create another book and author.
        Author andrew = new Author("Andrew", "Manson");
        Book foo = new Book("Foo", "23332");

        /// Add the book to Author books set and vise versa.
        andrew.getBooks().add(foo);
        foo.getAuthors().add(andrew);

        // Save the book and the author in H2DB.
        authorRepository.save(andrew);
        bookRepository.save(foo);

        aliPublisher.getBooks().add(jungle);
        aliPublisher.getBooks().add(foo);

        jungle.setPublisher(aliPublisher);
        foo.setPublisher(aliPublisher);

        bookRepository.save(jungle);
        bookRepository.save(foo);

        publisherRepository.save(aliPublisher);



        System.out.println("number of books "+ bookRepository.count());
        System.out.println("number of publishers "+ publisherRepository.count());
        System.out.println("publisher number of books "+ aliPublisher.getBooks().size());

    }
}
