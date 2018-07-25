/**
 * 
 */
package com.mongo.PerformanceTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.PerformanceTest.model.User;
import com.mongo.PerformanceTest.service.UserServiceImpl;

/**
 * @author rukamble
 *
 */
@RestController
public class UserController {

	 @Autowired
	    UserServiceImpl userServiceImpl;
	    
	    @PostMapping("/create")
	    public ResponseEntity<Integer> create(@RequestBody User user) {
	        userServiceImpl.createUser(user);
	        return new ResponseEntity<Integer>(1, HttpStatus.OK);
	    }
	    
	    @GetMapping("/get")
	    public ResponseEntity<List<User>> search()
	    {
	    	
	    	List<User> users = userServiceImpl.getUsers();
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    	
	    }
	    
	    @PostMapping("/find/{id}")
	    public ResponseEntity<String> findById(@PathVariable String id)
	    {
	    	userServiceImpl.findById(id);
			return new ResponseEntity<String>("null", HttpStatus.OK);
	    	
	    }

}
