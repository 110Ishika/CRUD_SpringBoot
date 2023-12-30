package com.example.TestDatabseConnectivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TestDatabseConnectivity.Service.BookService;
import com.example.TestDatabseConnectivity.entity.Book;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class Controller {
	@Autowired
	private BookService bookService;

	@PostMapping

	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book savedBook = bookService.createBook(book);

		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId) {
		Book bookDetails = bookService.getBookById(bookId);
		return new ResponseEntity<>(bookDetails, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> bookList = bookService.getAllBooks();
		return new ResponseEntity<>(bookList, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long bookId, @RequestBody Book book) {
		book.setId(bookId);
		Book updatedBook = bookService.updateBook(book);
		return new ResponseEntity<>(updatedBook, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
		bookService.deleteBook(bookId);
		return new ResponseEntity<>("Book is deleted Successfully", HttpStatus.OK);
	}
}