package com.example.MongoAndMySqlMultiple.io.inputOutput.output;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.MongoAndMySqlMultiple.io.modelIO.Person;



@Component
public class OutputPerson {
	public void writeToFile(Person person) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true))) {
			bw.write(person.toString());
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}
	}
}
