package com.example.MongoAndMySqlMultiple.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoAndMySqlMultiple.io.inputOutput.input.InputPerson;
import com.example.MongoAndMySqlMultiple.io.inputOutput.output.OutputPerson;
import com.example.MongoAndMySqlMultiple.io.modelIO.Person;


@RestController
public class ControllerIO {
	@Autowired
	private OutputPerson outputPerson;
	@Autowired
	private InputPerson inputPerson;
	
	@RequestMapping(value = "/write", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@RequestBody Person person) {
		outputPerson.writeToFile(person);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public String get(){
		return inputPerson.read();
	}
}
