package com.example.MongoAndMySqlMultiple.jdbc.dao;

import java.util.List;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;



public interface PersonDaoInterface {
	List<Person> getAll();

	Person get(Integer id);

	void create(Person person);

	void update(Person person);

	void delete(Integer id);
}
