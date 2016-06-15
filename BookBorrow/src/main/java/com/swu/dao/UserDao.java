package com.swu.dao;

import com.swu.model.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean deleteUserById(Integer in);
	public User queryUserById(Integer in);
	public User queryUserByNameAndPass(User user);
	public boolean updateUser(User user);
	public int getNumByName(String name); 
}
