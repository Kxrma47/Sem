package org.example.demo;

import org.example.demo.model.Book;
import org.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        Book book1 = new Book();
        book1.setTitle("Spring in Action");
        book1.setAuthor("Craig Walls");
        book1.setIsbn("9781617294945");

        Book book2 = new Book();
        book2.setTitle("Java Persistence with Hibernate");
        book2.setAuthor("Christian Bauer");
        book2.setIsbn("9781617290459");

        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    @Test
    void testFindAll() {
        List<Book> books = bookRepository.findAll();
        assertThat(books).hasSize(2);
    }

    @Test
    void testFindById() {
        Book book = bookRepository.findAll().get(0);
        Book foundBook = bookRepository.findById(book.getId()).orElse(null);
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo(book.getTitle());
    }
}