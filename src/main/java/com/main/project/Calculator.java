package com.main.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
	public int Add(String numbers) {
		if (numbers != null && !numbers.equals("")) {
			Map<String, Object> stringAndDelimiter = getStringAndDelimiter(numbers);
			if (stringAndDelimiter != null && stringAndDelimiter.get("number") != null) {
				String delimiterSeparatedString = stringAndDelimiter.get("number").toString().replaceAll("\\n",
						stringAndDelimiter.get("delimiter").toString());
				// This will replace new line with delimiter
				String commaSeparatedString = delimiterSeparatedString
						.replace(stringAndDelimiter.get("delimiter").toString(), ",");
				// This will replace delimiter to comma thus eliminating the problem of dangling
				// pointers
				String[] numbersArray = commaSeparatedString.split(",");
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
				if (numbers.substring(0, 3).equals("//[")) {
					int firstIndexOfDelimiter = numbers.indexOf("[");
					int lastIndexOfDelimiter = numbers.indexOf("]");
					String delimiter = numbers.substring(firstIndexOfDelimiter + 1, lastIndexOfDelimiter);
					String number = numbers.substring(lastIndexOfDelimiter + 1);
					mapStringAndDelimiter.put("delimiter", delimiter);
					mapStringAndDelimiter.put("number", number);
				} else {
					String delimiter = numbers.substring(2, 3);
					String number = numbers.substring(3);
					mapStringAndDelimiter.put("delimiter", delimiter);
					mapStringAndDelimiter.put("number", number);
				}
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
		List<String> negativeNumbers = new ArrayList<String>();
		for (String number : numbersArray) {
			if (number != null && !number.equals("")) {
				if (Integer.parseInt(number) < 0) {
					negativeNumbers.add(number);
				} else {
					if (Integer.parseInt(number) <= 1000) { // Only integers greater than 1000 to be added
						sum += Integer.parseInt(number);
					}
				}
			}
		}
		if (negativeNumbers != null && negativeNumbers.size() > 0) {
			String message = String.join(",", negativeNumbers);
			throw new NegativesNotAllowedException("Negatives not allowed" + message);
		}
		return sum;
	}
}
