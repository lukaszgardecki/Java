package com.example.Testy_Cwiczenie3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class AcronymGenerator {

	public static void main(String[] args) {
		SpringApplication.run(AcronymGenerator.class, args);
	}
	
	public String generate(String fullName) {
		if(fullName.isBlank()) return "";

		String[] names = splitBySpacesAndHyphens(fullName);

		return Arrays.stream(names)
				.map(this::toUpperCaseExceptForVon)
				.map(this::getInitial)
				.collect(Collectors.joining());
	}

	private String[] splitBySpacesAndHyphens(String fullName) {
		return fullName.split("[-\\s]");
	}

	private String getInitial(String name) {
		return name.substring(0,1);
	}

	private String toUpperCaseExceptForVon(String name) {
		return name.equals("von") ? name : name.toUpperCase();
	}
}
