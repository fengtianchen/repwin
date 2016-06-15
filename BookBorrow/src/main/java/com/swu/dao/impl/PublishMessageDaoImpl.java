package com.swu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.dao.PublishMessageDao;
import com.swu.model.PublishMessage;

@Repository
public class PublishMessageDaoImpl implements PublishMessageDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addPublishMessage(PublishMessage publishMessage) {
		if(null != sessionFactory.getCurrentSession().save(publishMessage))
			return true;
		return false;
	}

	public boolean deletePublishMessageById(Integer in) {
		PublishMessage publishMessage = this.queryPublishMessageById(in);
		sessionFactory.getCurrentSession().delete(publishMessage);
		return true;
	}

	public PublishMessage queryPublishMessageById(Integer in) {
		String hql = "from PublishMessage p where p.publishmessageid=" + in;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (PublishMessage) query.uniqueResult();
	}

	public boolean updatePublishMessage(PublishMessage publishMessage) {
		String hql = "update PublishMessage p set p.begin=?" + 
				" p.end=? where p.publishmessageid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, publishMessage.getBegin());
		query.setString(1, publishMessage.getEnd());
		query.setInteger(2, publishMessage.getPublishmessageid());
		if(query.executeUpdate() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<PublishMessage> queryAllPublishMessage() {
		String hql = "from PublishMessage";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<PublishMessage> queryPublishByType(String bclass) {
		String hql = "from PublishMessage p where p.pbook.bclass = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, bclass);
		@SuppressWarnings("unchecked")
		List<PublishMessage> lists = query.list();
		return lists;
	}

	public List<PublishMessage> queryByBlurrystr(String blurrystr) {
		String hql = "from PublishMessage p where p.pbook.bclass like ?"
				+ " or p.pbook.bclass like ?"
				+ " or p.pbook.bookname like ?"
				+ " or p.pbook.bookauthor like ?"
				+ " or p.pbook.bookpress like ?"
				+ " or p.pbook.bookintoduction like ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%" + blurrystr + "%");
		query.setString(1, "%" + blurrystr + "%");
		query.setString(2, "%" + blurrystr + "%");
		query.setString(3, "%" + blurrystr + "%");
		query.setString(4, "%" + blurrystr + "%");
		query.setString(5, "%" + blurrystr + "%");
		@SuppressWarnings("unchecked")
		List<PublishMessage> lists = query.list();
		return lists;
	}

}
