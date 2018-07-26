/**
 * 
 */
package com.dynamo.PerformanceTest.dao;


import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
//import org.socialsignin.spring.data.dynamodb.repository.EnableScan; 
import org.springframework.data.repository.CrudRepository;

import com.dynamo.PerformanceTest.model.User;

/**
 * @author smangrul
 *
 */
//@org.springframework.stereotype.Repository
@EnableScan
public interface Repository extends CrudRepository<User, String> {
	 
		Optional<User> findById(String Id);

		void deleteById(String id);
	}
	
