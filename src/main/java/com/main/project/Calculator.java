package com.main.project;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
	public int Add(String numbers) {
		if (numbers != null && !numbers.equals("")) {
			Map<String, Object> stringAndDelimiter = getStringAndDelimiter(numbers);
			if (stringAndDelimiter != null && stringAndDelimiter.get("number") != null) {
				String commaSeparatedString = stringAndDelimiter.get("number").toString().replaceAll("\\n",
						stringAndDelimiter.get("delimiter").toString());
				// This will replace new line with delimiter
				String[] numbersArray = commaSeparatedString.split(stringAndDelimiter.get("delimiter").toString());
				// Split the String and convert it into array
				int sum = addNumbers(numbersArray);
				return sum;
			} else {
				return 0;
			}

		} else {
			return 0; // Returns zero for an empty String
		}
	}

	private Map<String, Object> getStringAndDelimiter(String numbers) {
		try {
			Map<String, Object> mapStringAndDelimiter = new HashMap<String, Object>();
			String possibleDelimiterIndicator = numbers.substring(0, 2);
			if (possibleDelimiterIndicator.equals("//")) {
				String delimiter = numbers.substring(2, 3);
				String number = numbers.substring(3);
				mapStringAndDelimiter.put("delimiter", delimiter);
				mapStringAndDelimiter.put("number", number);
			} else {
				mapStringAndDelimiter.put("delimiter", ",");
				mapStringAndDelimiter.put("number", numbers);
			}
			return mapStringAndDelimiter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private int addNumbers(String[] numbersArray) {
		int sum = 0;
		for (String number : numbersArray) {
			if (number != null && !number.equals("")) {
				sum += Integer.parseInt(number);
			}
		}
		return sum;
	}
}
