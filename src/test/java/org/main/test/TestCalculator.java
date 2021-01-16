package org.main.test;

import org.junit.Assert;
import org.junit.Test;

import com.main.project.Calculator;

public class TestCalculator {
	@Test
	public void addString() {
		Calculator calculator = new Calculator();
		String numbersToBeAdded = ""; // Empty String
		int sum = calculator.Add(numbersToBeAdded);
		Assert.assertEquals(0, sum);
	}
}
