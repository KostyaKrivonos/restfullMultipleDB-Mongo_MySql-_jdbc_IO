package com.example.MongoAndMySqlMultiple.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.MongoAndMySqlMultiple.mysql.dto.RequestDto;
import com.example.MongoAndMySqlMultiple.mysql.modelMySql.name.Name;
import com.example.MongoAndMySqlMultiple.mysql.mysqlService.nameService.NameService;
import com.example.MongoAndMySqlMultiple.mysql.mysqlService.phoneService.PhoneService;

@RestController
@RequestMapping(value = "/mysql")
public class Controller {

	private NameService nameService;

	private PhoneService phoneService;

	@Autowired
	Controller(NameService nameService, PhoneService phoneService) {
		this.nameService = nameService;
		this.phoneService = phoneService;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@RequestBody RequestDto name) {
		nameService.create(name.getName());
		phoneService.create(name.getPhone());
	}

	/*
	 * @RequestMapping(value = "/createName", method = RequestMethod.POST, produces
	 * = APPLICATION_JSON_VALUE) public void create(@Valid @RequestBody Name name) {
	 * nameService.create(name); //phoneService.create(phone); }
	 * 
	 * @RequestMapping(value = "/createPhone", method = RequestMethod.POST, produces
	 * = APPLICATION_JSON_VALUE) public void create(@Valid @RequestBody Phone phone)
	 * { //nameService.create(name); phoneService.create(phone); }
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		nameService.deleteById(id);
		phoneService.deleteById(id);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Name> get(@PathVariable("id") Integer id) {
		Name name = nameService.getById(id);
		// Phone phone = phoneService.getById(id);
		return ResponseEntity.ok(name);
	}
}
