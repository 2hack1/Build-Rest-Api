package com.firstRESt;

import org.eclipse.jdt.internal.compiler.lookup.TypeConstants.DangerousMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class BooksDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Book_id")
	private int id;
	private String auther;
	private String title;

	public BooksDetails(int id, String auther, String title) {
		super();
		this.id = id;
		this.auther = auther;
		this.title = title;
	}

	public BooksDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BooksDetails [id=" + id + ", auther=" + auther + ", title=" + title + "]";
	}

}
