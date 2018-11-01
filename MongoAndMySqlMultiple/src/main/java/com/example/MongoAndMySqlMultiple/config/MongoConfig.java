package com.example.MongoAndMySqlMultiple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.example.MongoAndMySqlMultiple.mongoDB.mongoRepository" })
@PropertySource("classpath:mongo.properties")
public class MongoConfig extends AbstractMongoConfiguration {
	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getProperty("mongodb.database");
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.example.MongoAndMySqlMultiple.mongoDB.modelMongo";
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(env.getProperty("mongodb.host"), Integer.parseInt(env.getProperty("mongodb.port")));
	}
}
