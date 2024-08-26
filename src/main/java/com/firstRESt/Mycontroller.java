package com.firstRESt;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity< List<BooksDetails>> test() {
		
		List<BooksDetails> list=bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BooksDetails> getBook(@PathVariable("id") int id) {
		
		BooksDetails book=bookService.getById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
				
	}

	@PostMapping("/books")
	public ResponseEntity<BooksDetails> postMethodName(@RequestBody BooksDetails book) {
		BooksDetails b=null;
		try {
			b = this.bookService.addBook(book);
             System.out.println(book);
             return ResponseEntity.of(Optional.of(b));
   
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/books/{Bid}")
	public ResponseEntity<Void> delete(@PathVariable("Bid") int Bid) {
		try {
			this.bookService.deleteBook(Bid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}

	@PutMapping("/books/{bid}")
	public ResponseEntity< BooksDetails> updateOfBook(@RequestBody BooksDetails book, @PathVariable("bid") int bid) {
     
		try {
			this.bookService.updateOfBook(book, bid);
           return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
