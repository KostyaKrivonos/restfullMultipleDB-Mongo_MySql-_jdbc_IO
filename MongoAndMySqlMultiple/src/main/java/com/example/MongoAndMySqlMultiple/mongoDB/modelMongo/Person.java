package com.example.MongoAndMySqlMultiple.mongoDB.modelMongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author kostyadev class is a person implementation. in class I use Lombok
 */

@Document(collection = "persons")
@Data
@NoArgsConstructor
@ToString(includeFieldNames = false)
public class Person {
	@Id
	private ObjectId id;

	@NotNull
	@Size(min = 2, max = 15, message = "name length 2-15")
	private String name;

	@NotNull
	@Size(min = 10, max = 13, message = "phone numbers length 10-13")
	private String phone;

}
