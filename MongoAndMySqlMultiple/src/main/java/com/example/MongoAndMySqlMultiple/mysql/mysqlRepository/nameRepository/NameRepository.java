package com.example.MongoAndMySqlMultiple.mysql.mysqlRepository.nameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MongoAndMySqlMultiple.mysql.modelMySql.name.Name;

@Repository
public interface NameRepository extends JpaRepository<Name, Integer> {

	void deleteById(Integer id);
}
