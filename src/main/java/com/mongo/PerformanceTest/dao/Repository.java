/**
 * 
 */
package com.mongo.PerformanceTest.dao;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mongo.PerformanceTest.model.User;

/**
 * @author smangrul
 *
 */

@EnableScan
public interface Repository extends CrudRepository<User, String> {
	 
//		Optional<User> findById(String Id);
	}
	
