package com.mongo.PerformanceTest.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.PerformanceTest.dao.Repository;
import com.mongo.PerformanceTest.model.User;

@Service
public class UserServiceImpl implements IUserService
{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	Repository repository;

	@Override
	
	public int createUser(User user) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) 
		{
			user.setId(String.valueOf(new Random()));
			User users = repository.save(user);
		}
		
		long result = System.currentTimeMillis()-start;
		String performance = String.valueOf(result);
		logger.info(performance);
		return 1;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		repository.findAll();
		long result = System.currentTimeMillis()-start;
		String performance = String.valueOf(result);
		logger.info(performance);
		return null;
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return 1;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> users =repository.findById(user.getId());
		User user1 = users.get();
		user1.setAge(user.getAge());
    	user1.setEmail(user.getEmail());
    	user1.setName(user.getName());
    	user1.setId(user.getId());
		repository.save(user);
		return 1;
	}

	@Override
	public String findById(String id) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		Optional<User> users =repository.findById(id);
		long result = System.currentTimeMillis()-start;
		String performance = String.valueOf(result);
		logger.info(performance);
		return null;
	}
	

}