package com.example.gscaching;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
