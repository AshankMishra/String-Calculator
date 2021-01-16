package com.main.project;

public class Calculator {
	public int Add(String numbers) {
		if (numbers != null && !numbers.equals("")) {
			String commaSeparatedString = numbers.replaceAll("\\n", ","); // This will replace new line with delimiter
			String[] numbersArray = commaSeparatedString.split(","); // Split the String and convert it into array
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
