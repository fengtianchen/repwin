package com.swu.service;

import com.swu.model.User;

public interface UserService {
	public User login(User user);
	public boolean register(User user);
	public User queryUserById(Integer uid);
	
	public boolean isexist(String name);
}
