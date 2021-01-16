package org.main.test;

import org.junit.Assert;
import org.junit.Test;

import com.main.project.Calculator;

public class TestCalculator {
	@Test
	public void addString() {
		Calculator calculator = new Calculator();
		String numbersToBeAdded = "4\n2,56"; // Multiple numebrs to be added
		int sum = calculator.Add(numbersToBeAdded);
		Assert.assertEquals(62, sum);
	}
}
