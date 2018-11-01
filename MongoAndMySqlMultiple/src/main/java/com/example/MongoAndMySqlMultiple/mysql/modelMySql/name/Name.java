package com.example.MongoAndMySqlMultiple.mysql.modelMySql.name;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "name")
public class Name {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*@NotNull
	@Size(min = 2, max = 15, message = "name length 2-15")*/
	@Column(name = "name")
	private String name;
}
