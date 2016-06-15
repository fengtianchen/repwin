package com.swu.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.dao.BorrowMessageDao;
import com.swu.model.BorrowMessage;

@Repository
public class BorrowMessageDaoImpl implements BorrowMessageDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addBorrowMessage(BorrowMessage borrowMessage) {
		
		if(null != sessionFactory.getCurrentSession().save(borrowMessage))
			return true;
		return false;
	}

	public boolean deleteBorrowMessageById(Integer in) {
		BorrowMessage borrowMessage = this.queryBorrowMessageById(in);
		sessionFactory.getCurrentSession().delete(borrowMessage);
		return true;
	}

	public BorrowMessage queryBorrowMessageById(Integer in) {
		String hql = "from BorrowMessage b where b.borrowmessageid=" + in;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (BorrowMessage) query.uniqueResult();
	}
}
