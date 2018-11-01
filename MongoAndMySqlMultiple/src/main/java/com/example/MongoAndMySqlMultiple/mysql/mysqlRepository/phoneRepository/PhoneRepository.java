package com.example.MongoAndMySqlMultiple.mysql.mysqlRepository.phoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MongoAndMySqlMultiple.mysql.modelMySql.phone.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
	
	void deleteById(Integer id);
}
