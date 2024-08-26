package com.firstRESt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
	@Autowired
   private bookDao dao;
//	private static List<BooksDetails> list = new ArrayList<BooksDetails>();
//	static {
//		list.add(new BooksDetails(1, "kapil", "AAA"));
//		list.add(new BooksDetails(2, "udit", "bbb"));
//		list.add(new BooksDetails(3, "krishna", "ccc"));
//		list.add(new BooksDetails(4, "nakul", "ddd"));
//	}

	public List<BooksDetails> getAllBooks() {
		List<BooksDetails> list=(List<BooksDetails>)this.dao.findAll();
		return list ;
	}

	public BooksDetails getById(int id) {
       
		BooksDetails book = null;
		try {
//			 book = list.stream().filter(e -> e.getId() == id).findFirst().get();
         book=  this.dao.findById(id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}

	public BooksDetails addBook(BooksDetails book) {
		//list.add(book);
		//return book;
		BooksDetails b=dao.save(book);
		return b;
	}

	public void deleteBook(int Bid) {
		//list = list.stream().filter(e -> e.getId() != Bid).collect(Collectors.toList());
          dao.deleteById(Bid);
	}

	public void updateOfBook(BooksDetails book, int bid) {
//		list.stream().map(b -> {
//			if (b.getId() == bid) {
//				b.setAuther(book.getAuther());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
      book.setId(bid);
		dao.save(book);
	}
}
