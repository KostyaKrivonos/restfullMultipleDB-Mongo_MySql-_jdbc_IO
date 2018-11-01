package com.example.MongoAndMySqlMultiple.jdbc.personMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;



public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setPhone(rs.getString("phone"));
		return person;
	}

}
