package com.example.MongoAndMySqlMultiple.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;
import com.example.MongoAndMySqlMultiple.jdbc.jdbcService.PersonServiceJdbc;



@RestController
@RequestMapping(value = "/jdbc")
public class ControllerJdbc {
	@Autowired
	private PersonServiceJdbc personServiceJdbc;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> get(@PathVariable("id") Integer id){
		Person person = personServiceJdbc.get(id);
		return ResponseEntity.ok(person);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@RequestBody Person person) {
		personServiceJdbc.create(person);
	}
}
