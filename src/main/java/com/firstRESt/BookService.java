package com.firstRESt;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.stereotype.Component;

@Component
public class BookService {

	private static List<BooksDetails> list = new ArrayList<BooksDetails>();
	static {
		list.add(new BooksDetails(1, "kapil", "AAA"));
		list.add(new BooksDetails(2, "udit", "bbb"));
		list.add(new BooksDetails(3, "krishna", "ccc"));
		list.add(new BooksDetails(4, "nakul", "ddd"));
	}

	public List<BooksDetails> getAllBooks() {
		return list;
	}

	public BooksDetails getById(int id) {

		BooksDetails book = null;
		return book = list.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public BooksDetails addBook(BooksDetails book) {
		list.add(book);
		return book;
	}

	public void deleteBook(int Bid) {
		list = list.stream().filter(e -> e.getId() != Bid).collect(Collectors.toList());

	}

	public void updateOfBook(BooksDetails book, int bid) {
		list.stream().map(b -> {
			if (b.getId() == bid) {
				b.setAuther(book.getAuther());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());

	}
}
