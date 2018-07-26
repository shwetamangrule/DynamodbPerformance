package com.mongo.PerformanceTest.service;

import java.util.List;

import com.mongo.PerformanceTest.model.User;

public interface IUserService 
{
	public int createUser(User user);
	public List<User> getUsers();
	public int deleteUser(String id);
	public int updateUser(User user);
	public String findById(String id);
}
