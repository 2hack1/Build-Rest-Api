package com.firstRESt;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author_Details")
public class Auther {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id

	private int auther_id;

	@Column(name = "author_first_name")
	private String first_name;

	@Column(name = "author_last_name")
	private String last_name;

	@Column(name = "author_language")
	private String language;
//	@OneToOne(mappedBy = "auther")
//	private BooksDetails booksDetails;
//
//	public BooksDetails getBooksDetails() {
//		return booksDetails;
//	}
//
//	public void setBooksDetails(BooksDetails booksDetails) {
//		this.booksDetails = booksDetails;
//	}
	public int getAuthor_id() {
		return auther_id;
	}

	public void setAuthor_id(int auther_id) {
		this.auther_id = auther_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
