package com.swu.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.dao.UserDao;
import com.swu.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		if(null != sessionFactory.getCurrentSession().save(user))
			return true;
		return false;
	}

	public boolean deleteUserById(Integer in) {
		User user = this.queryUserById(in);
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	public User queryUserById(Integer in) {
		String hql = "from User u where u.userid=" + in;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

	public boolean updateUser(User user) {
		String hql = "update User u set u.userphone=? where u.userid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserphone());
		query.setInteger(1, user.getUserid());
		if(query.executeUpdate() > 0)
			return true;
		return false;
	}

	public User queryUserByNameAndPass(User user) {
		String hql = "from User u where u.username=? and u.userpass=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getUserpass());
		return (User) query.uniqueResult();
	}

	public int getNumByName(String name) {
		String hql = "from User u where u.username=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		if(query.uniqueResult() != null){
			return 1;
		}
		return 0;
	}

}
