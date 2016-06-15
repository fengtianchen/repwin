package com.swu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swu.dao.UserDao;
import com.swu.model.User;
import com.swu.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public User login(User user) {
		return userDao.queryUserByNameAndPass(user);
	}

	public boolean register(User user) {
		return userDao.addUser(user);
	}

	public User queryUserById(Integer uid) {
		return userDao.queryUserById(uid);
	}

	public boolean isexist(String name) {
		int num = userDao.getNumByName(name);
		return num!=0;
	}

}
