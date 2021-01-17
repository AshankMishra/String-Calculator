package org.main.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.project.Calculator;
import com.main.project.NegativesNotAllowedException;

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

	@Test
	public void testForNegativeNumbers() {
		String stringWithNegativeNumber = "//;\n1;-2;5\n4";
		assertThrows(NegativesNotAllowedException.class, () -> {
			calculator.Add(stringWithNegativeNumber);
		});
	}

	@Test
	public void testForIntegersGreaterThan1000() {
		String stringWithNumbersGreaterThan100 = "//;\n1;1010;5\n4";
		int sum = calculator.Add(stringWithNumbersGreaterThan100);
		assertEquals(10, sum);
	}

	@Test
	public void testForDelimitersOfLengthGreaterThan1() {
		String stringWithDelimitersOfLengthGreaterThan1 = "//[***]\n1***2***3";
		int sum = calculator.Add(stringWithDelimitersOfLengthGreaterThan1);
		assertEquals(6, sum);
	}
}
