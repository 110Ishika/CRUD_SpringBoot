package com.example.TestDatabseConnectivity.Service.Implementation;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TestDatabseConnectivity.Service.*;
import com.example.TestDatabseConnectivity.entity.Book;
import com.example.TestDatabseConnectivity.repository.BookRepository;
@Service
public class BookServiceImplementation implements BookService{
@Autowired
private BookRepository bookRepository;	
@Override
public Book createBook(Book book)
{
	return bookRepository.save(book);
}


public Book getBookById(Long bookId)
{
	Optional<Book> optionalBook=bookRepository.findById(bookId);
	return optionalBook.get();
}
public List<Book> getAllBooks(){
return bookRepository.findAll();	
}


public Book updateBook(Book book) {
	Book existingBook=bookRepository.findById(book.getId()).get();
	existingBook.setTitle(book.getTitle());
	existingBook.setAuthor(book.getAuthor());
	existingBook.setDescription(book.getDescription());
	existingBook.setGenre(book.getGenre());
	Book updateBook=bookRepository.save(existingBook);
	return updateBook;
}
public void deleteBook(Long bookId) {
	bookRepository.deleteById(bookId);
	
}
	
}

