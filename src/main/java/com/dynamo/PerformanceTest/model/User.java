package com.dynamo.PerformanceTest.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "UserPerformance")
public class User 
{
	 private String id;
	 private String name;
	 private int age;
	 private String email;
	 
	 public User() {
		// TODO Auto-generated constructor stub
	}
	 
	 
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}


	public User(String id, String name, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}


	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@DynamoDBAttribute(attributeName = "Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute(attributeName = "Age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@DynamoDBAttribute(attributeName = "Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
}
