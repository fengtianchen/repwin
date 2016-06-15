package com.swu.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.swu.dao.BookDao;
import com.swu.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addBook(Book book) {
		if (null != sessionFactory.getCurrentSession().save(book)) {
			return true;
		}
		return false;
	}

	public boolean deleteBookById(Integer in) {
		Book book = this.queryBookById(in);
		sessionFactory.getCurrentSession().delete(book);
		return true;
	}

	public Book queryBookById(Integer in) {
		String hql = "from Book b where b.bookid=" + in;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Book) query.uniqueResult();
	}

	public List<Book> listAllBook() {
		String hql = "from Book";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> lists = query.list();
		return lists;
	}

	public List<Book> queryBookByType(String bclass) {
		String hql = "from Book b where b.bclass = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, bclass);
		@SuppressWarnings("unchecked")
		List<Book> lists = query.list();
		return lists;
	}
}
