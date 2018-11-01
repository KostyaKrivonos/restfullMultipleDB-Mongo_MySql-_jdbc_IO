package com.example.MongoAndMySqlMultiple.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoAndMySqlMultiple.mongoDB.modelMongo.Person;
import com.example.MongoAndMySqlMultiple.mongoDB.mongoService.PersonService;
import com.example.MongoAndMySqlMultiple.mongoDB.validator.ValidationErrorBuilder;

@RestController
@RequestMapping(value = "/mongo")
public class ControllerMongo {
	private PersonService personService;

	@Autowired
	ControllerMongo(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> get(@RequestBody Person p) {
		// System.out.println(name + phone);
		return ResponseEntity.badRequest().body(personService.findOne(p.getName(), p.getPhone()));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity create(@Valid @RequestBody Person person, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
		}
		return ResponseEntity.ok(personService.create(person));
	}

	@RequestMapping(value = "/getAll/{page}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public Page<Person> get(@PathVariable("page") int page) {
		return personService.findAll(page);
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> get(@PathVariable("id") ObjectId id) {
		return ResponseEntity.badRequest().body(personService.findById(id));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		personService.delete(id);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") ObjectId id, @Valid @RequestBody Person person) {
		personService.update(person);
	}
}
