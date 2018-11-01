package com.example.MongoAndMySqlMultiple.mysql.modelMySql.phone;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class Phone{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*@NotNull
	@Size(min = 10, max = 13, message = "phone numbers length 10-13")*/
	@Column(name = "phone")
	private String phone;
}
