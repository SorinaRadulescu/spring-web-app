package com.example.learningspring.bootstrap;

import com.example.learningspring.domain.Author;
import com.example.learningspring.domain.Book;
import com.example.learningspring.domain.Publisher;
import com.example.learningspring.repositories.AuthorRepository;
import com.example.learningspring.repositories.BookRepository;
import com.example.learningspring.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //using this to tell spring that this is a spring manage component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        //Publisher mainPublisher = new Publisher("Publisher Name", "Address Line 1", "Bucharest", "Romania", "1234567");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23456789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setCity("Publisher City");
        publisher.setState("Publisher State");
        publisher.setAddressLine1("Address Line 1");
        publisher.setZip("1234567");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
