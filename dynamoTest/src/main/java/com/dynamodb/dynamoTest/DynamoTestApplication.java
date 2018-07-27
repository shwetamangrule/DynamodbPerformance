package com.dynamodb.dynamoTest;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

@SpringBootApplication
public class DynamoTestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DynamoTestApplication.class, args);
		
		AmazonDynamoDB dynamoDB = null;
		dynamoDB = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(new AWSCredentials() {
					@Override
					public String getAWSAccessKeyId() {
						return "dummy";
					}

					@Override
					public String getAWSSecretKey() {
						return "dummy";
					}
				})).build();
		createTableRequest(dynamoDB);
	}

	private static void createTableRequest(AmazonDynamoDB dynamoDB) {
		ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<>();
		attributeDefinitions.add(new AttributeDefinition().withAttributeName("ID").withAttributeType("S"));
		attributeDefinitions.add(new AttributeDefinition().withAttributeName("Name").withAttributeType("S"));
		attributeDefinitions.add(new AttributeDefinition().withAttributeName("Age").withAttributeType("I"));
		attributeDefinitions.add(new AttributeDefinition().withAttributeName("Email").withAttributeType("S"));
		ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
		keySchema.add(new KeySchemaElement().withAttributeName("ID").withKeyType(KeyType.HASH));
		keySchema.add(new KeySchemaElement().withAttributeName("Name").withKeyType(KeyType.HASH));
		keySchema.add(new KeySchemaElement().withAttributeName("Age").withKeyType(KeyType.HASH));
		keySchema.add(new KeySchemaElement().withAttributeName("Email").withKeyType(KeyType.HASH));
		CreateTableRequest createTableReq = new CreateTableRequest()
                .withTableName("User")
                .withAttributeDefinitions(attributeDefinitions)
                .withKeySchema(keySchema)
                .withProvisionedThroughput(new ProvisionedThroughput()
                        .withReadCapacityUnits(10L)
                        .withWriteCapacityUnits(5L));
        CreateTableResult result = dynamoDB.createTable(createTableReq);
        System.out.println(result.toString());
		
		
	}

	}

