package com.example.demo_data_jpa_using_hibernate.controller;

import com.example.demo_data_jpa_using_hibernate.entity.Book;
import com.example.demo_data_jpa_using_hibernate.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping("/insertBook")
    public Book insertBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    @PutMapping("/updateBookBy/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

}
