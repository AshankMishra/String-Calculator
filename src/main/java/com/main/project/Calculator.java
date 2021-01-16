package com.main.project;

public class Calculator {
	public int Add(String numbers) {
		if (numbers != null && !numbers.equals("")) {
			int numberToBeAdded = Integer.parseInt(numbers);
			return numberToBeAdded;
		} else {
			return 0; // Returns zero for an empty String
		}
	}
}
