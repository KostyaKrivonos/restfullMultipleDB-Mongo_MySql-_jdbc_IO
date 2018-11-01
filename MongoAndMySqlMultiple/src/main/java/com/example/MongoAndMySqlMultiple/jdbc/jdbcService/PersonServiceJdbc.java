package com.example.MongoAndMySqlMultiple.jdbc.jdbcService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;
import com.example.MongoAndMySqlMultiple.jdbc.dao.PersonDao;


@Service
public class PersonServiceJdbc {
	@Autowired
	private PersonDao personDao;

	public void create(Person person) {
		String name = person.getName();
		if (person.getPhone().contains("+38")) {
			person.setName(name.toUpperCase());
			personDao.create(person);
		}
		if(person.getPhone().contains("+7")) {
			person.setName(upperCaseFirstLetter(name));
			personDao.create(person);
		}
	}

	public List<Person> getAll() {
		return personDao.getAll();
	}

	public Person get(Integer id) {
		return personDao.get(id);
	}

	public void delete(Integer id) {
		personDao.delete(id);
	}

	public void update(Person person) {
		personDao.update(person);
	}

	private static String upperCaseFirstLetter(String value) {

		// Convert String to char array.
		char[] array = value.toCharArray();
		// Modify first element in array.
		array[0] = Character.toUpperCase(array[0]);
		// Return string.
		return new String(array);
	}

}
