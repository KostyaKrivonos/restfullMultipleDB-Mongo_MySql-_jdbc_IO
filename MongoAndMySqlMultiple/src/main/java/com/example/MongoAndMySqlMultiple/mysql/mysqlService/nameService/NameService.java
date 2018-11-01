package com.example.MongoAndMySqlMultiple.mysql.mysqlService.nameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MongoAndMySqlMultiple.mysql.modelMySql.name.Name;
import com.example.MongoAndMySqlMultiple.mysql.mysqlRepository.nameRepository.NameRepository;;

@Service
public class NameService {
	@Autowired
	private NameRepository nameRepository;

	public void create(String name) {

		Name name1 = new Name();
		name1.setName(name);

		nameRepository.save(name1);
	}

	public void deleteById(Integer id) {
		nameRepository.deleteById(id);
	}

	public Name getById(Integer id) {
		return nameRepository.findById(id).get();
	}
}
