package com.example.demo_data_jpa_using_hibernate.service;

import com.example.demo_data_jpa_using_hibernate.entity.Book;
import com.example.demo_data_jpa_using_hibernate.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    @Transactional
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
    @Transactional
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @Transactional
    public Book updateBook(@RequestBody Book book, @PathVariable String id){
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book updateBook(String id, Book updatedBook) {
        // Retrieve the existing book from the database
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // Update the book's details
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        // Save the updated book back to the database
        return bookRepository.save(existingBook);
    }
}
