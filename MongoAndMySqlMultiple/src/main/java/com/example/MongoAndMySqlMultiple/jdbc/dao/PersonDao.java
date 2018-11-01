package com.example.MongoAndMySqlMultiple.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;
import com.example.MongoAndMySqlMultiple.jdbc.personMapper.PersonMapper;



@Transactional
@Repository
public class PersonDao implements PersonDaoInterface {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Person> getAll() {
		String sql = "SELECT id, name, phone FROM persons";
		// RowMapper<Article> rowMapper = new
		// BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Person> rowMapper = new PersonMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Person get(Integer id) {
		String sql = "SELECT id, name, phone FROM persons WHERE id = ?";
		RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
		Person person = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return person;
	}

	@Override
	public void create(Person person) {
		String sql = "INSERT INTO persons (id, name, phone) values (?, ?, ?)";
		jdbcTemplate.update(sql, person.getId(), person.getName(), person.getPhone());
	}

	@Override
	public void update(Person person) {
		String sql = "UPDATE persons SET name=?, phone=? WHERE id=?";
		jdbcTemplate.update(sql, person.getName(), person.getPhone(), person.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM persons WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

}
