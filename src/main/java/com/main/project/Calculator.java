package com.main.project;

public class Calculator {
	public int Add(String numbers) {
		if (numbers != null && !numbers.equals("")) {
			String[] numbersArray = numbers.split(",");
			int sum = addNumbers(numbersArray);
			return sum;
		} else {
			return 0; // Returns zero for an empty String
		}
	}

	private int addNumbers(String[] numbersArray) {
		int sum = 0;
		for (String number : numbersArray) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
