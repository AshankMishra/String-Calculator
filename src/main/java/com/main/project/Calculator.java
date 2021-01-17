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
				String delimiterSeparatedString = stringAndDelimiter.get("number").toString().replaceAll("\\n", ",");
				// This will replace new line with comma
				String commaSeparatedString = null;
				List<String> delimiterList = (List<String>) stringAndDelimiter.get("delimiter");
				for (int i = 0; i < delimiterList.size(); i++) {
					if (i == 0) {
						commaSeparatedString = delimiterSeparatedString.replace(delimiterList.get(i), ",");
					} else {
						commaSeparatedString = commaSeparatedString.replace(delimiterList.get(i), ",");
					}
				}
//				commaSeparatedString = delimiterSeparatedString
//						.replace(stringAndDelimiter.get("delimiter").toString(), ",");
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
					int lastIndexOfDelimiter = 0;
					List<String> delimiterList = new ArrayList<>();
					for (int i = 0; i < numbers.length(); i++) {
						if (numbers.charAt(i) == '[') {
							for (int j = i + 1; j < (numbers.length() - i + 1); j++) {
								if (numbers.charAt(j) == ']') {
									delimiterList.add(numbers.substring(i + 1, j));
									lastIndexOfDelimiter = j;
									j = numbers.length() - i + 1;
								}
							}
						}
					}
					String number = numbers.substring(lastIndexOfDelimiter + 1);
					mapStringAndDelimiter.put("delimiter", delimiterList);
					mapStringAndDelimiter.put("number", number);
				} else {
					String delimiter = numbers.substring(2, 3);
					List<String> delimterList = new ArrayList<>();
					delimterList.add(delimiter);
					String number = numbers.substring(3);
					mapStringAndDelimiter.put("delimiter", delimterList);
					mapStringAndDelimiter.put("number", number);
				}
			} else {
				List<String> delimterList = new ArrayList<>();
				delimterList.add(",");
				mapStringAndDelimiter.put("delimiter", delimterList);
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
