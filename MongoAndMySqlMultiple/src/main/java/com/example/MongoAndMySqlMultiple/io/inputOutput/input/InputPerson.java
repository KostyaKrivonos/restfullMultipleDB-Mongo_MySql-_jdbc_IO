package com.example.MongoAndMySqlMultiple.io.inputOutput.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class InputPerson {
	public String read() {
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			String nextLine = null;
			while ((nextLine = br.readLine()) != null) {
				line = nextLine;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		return line;
	}
}
