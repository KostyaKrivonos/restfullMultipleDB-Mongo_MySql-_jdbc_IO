package com.example.MongoAndMySqlMultiple.mongoDB.mongoRepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.example.MongoAndMySqlMultiple.mongoDB.modelMongo.Person;

/**
 * 
 * interface extends MongoRepository, to work with MongoDB. documentation for
 * MongoRepository:
 * 
 * @linkplain https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/repository/MongoRepository.html
 * @author kostyadev
 */

@Component
public interface PersonRepository extends MongoRepository<Person, String> {

	/**
	 * Method return a person object from the database
	 * 
	 * @param id - person number generated by the database.
	 */
	Person findById(ObjectId id);

	/**
	 * the method return the person by value from database.
	 * 
	 * @param name - the name has a min and max length limit of 2-15 characters.
	 * @param phone - the phone has a minimum and maximum length limit of 10-13 numbers.
	 */
	@Query("{ 'name' : ?0, 'phone' : ?1 }")
	Person findOne(String name, String phone);

}