package org.main.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.project.Calculator;

public class TestCalculator {
	private Calculator calculator;

	@Before
	public void setup() {
		calculator = new Calculator();
	}

	@Test
	public void addString() {
		String numbersToBeAdded = "4\n2,56"; // Multiple numbers to be added
		int sum = calculator.Add(numbersToBeAdded);
		Assert.assertEquals(62, sum);
	}

	@Test
	public void addMultipleNumbersInStringWithDifferentDelimiters() {
		String numbersWithDelimiters = "//;\n1;2;5\n4"; // String of numbers with varying delimiters
		int sum = calculator.Add(numbersWithDelimiters);
		Assert.assertEquals(12, sum);
	}
}
