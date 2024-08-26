package com.firstRESt;

import org.springframework.data.repository.CrudRepository;

public interface bookDao extends CrudRepository<BooksDetails,Integer> {

	   public BooksDetails findById(int id); 
		 
	   }

