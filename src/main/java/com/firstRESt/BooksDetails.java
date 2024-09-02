package com.firstRESt;

import org.eclipse.jdt.internal.compiler.lookup.TypeConstants.DangerousMethod;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class BooksDetails {
    
    @GeneratedValue(strategy = GenerationType.AUTO)  
    @Id   
	private int id;
    
    @OneToOne(cascade = CascadeType.ALL) 
   // @JsonBackReference
	private Auther auther;
	private String title;

	public BooksDetails(int id, Auther auther, String title) {
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

	public Auther getAuther() {
		return auther;
	}

	public void setAuther(Auther auther) {
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
