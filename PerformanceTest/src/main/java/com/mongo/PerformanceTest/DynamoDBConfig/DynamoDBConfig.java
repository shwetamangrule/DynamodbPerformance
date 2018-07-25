/**
 * 
 */
package com.mongo.PerformanceTest.DynamoDBConfig;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.util.StringUtils;

/**
 * @author smangrul
 *
// */
//public class AmazonDynamoDB {
//	
//	com.amazonaws.services.dynamodbv2.AmazonDynamoDB dynamodb = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).withCredentials(
//			new AWSStaticCredentialsProvider(new AWSCredentials() 
//			{
//				
//				public String getAWSAccessKeyId() {
//					return "dummy";
//				}
//				
//				public String getAWSSecretKey() {
//					return "dummy";
//				}
//				
//			})).build();
//
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.javasampleapproach.dynamodb.repo")
public class DynamoDBConfig {
 
	@Value("${amazon.dynamodb.endpoint}")
	private String dBEndpoint;
 
	@Value("${amazon.aws.accesskey}")
	private String accessKey;
 
	@Value("${amazon.aws.secretkey}")
	private String secretKey;
 
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
 
		if (!StringUtils.isNullOrEmpty(dBEndpoint)) {
			dynamoDB.setEndpoint(dBEndpoint);
		}
 
		return dynamoDB;
	}
 
	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}
}