package com.firstRESt;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
//@Controller
//@ResponseBody
public class Mycontroller {
//	@RequestMapping(value="/kapil", method=RequestMethod.GET)
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<BooksDetails> test() {
		bookService.getAllBooks();
		return this.bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public BooksDetails getBook(@PathVariable("id") int id) {
		return bookService.getById(id);
	}

	@PostMapping("/books")
	public BooksDetails postMethodName(@RequestBody BooksDetails book) {
		BooksDetails b = this.bookService.addBook(book);

		return b;
	}

	@DeleteMapping("/books/{Bid}")
	public void delete(@PathVariable("Bid") int Bid) {
		this.bookService.deleteBook(Bid);
	}

	@PutMapping("/books/{bid}")
	public BooksDetails updateOfBook(@RequestBody BooksDetails book, @PathVariable("bid") int bid) {

		this.bookService.updateOfBook(book, bid);
		return book;
	}
}
