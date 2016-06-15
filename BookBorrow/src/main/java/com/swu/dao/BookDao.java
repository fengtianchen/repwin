package com.swu.dao;

import java.util.List;
import com.swu.model.Book;

public interface BookDao {
	public boolean addBook(Book book);
	public boolean deleteBookById(Integer in);
	public Book queryBookById(Integer in);
	public List<Book> listAllBook();
	public List<Book> queryBookByType(String bclass);
}
