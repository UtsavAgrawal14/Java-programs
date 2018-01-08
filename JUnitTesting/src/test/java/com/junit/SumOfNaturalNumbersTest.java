package com.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumOfNaturalNumbersTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all executed.\n\n");
	}
	
	//BeforeEach executes before every test case to do some initial processing. 
	@BeforeEach
	public void testSetup() {
		System.out.println("Before executed.");
	}
	
	@Test
	public void testSumNaive_InputZero() {
		assertEquals(0, SumOfNaturalNumbers.sumNaive(0));
		System.out.println("Test1");
	}

	@Test
	public void testSumNaive_InputOne() {
		assertFalse(SumOfNaturalNumbers.sumNaive(1) != 1);
		System.out.println("Test2");
	}

	@Test
	public void testSumNaive_InputTwo() {
		assertTrue(SumOfNaturalNumbers.sumNaive(2) == 3);
		System.out.println("Test3");
	}
	
	@AfterEach
	public void testTearDown() {
		System.out.println("Teardown executed.\n");
	}
	
	//AfterAll executes ONLY ONCE after all test cases to do cleanup like closing files, DB connections, Streams etc.
	@AfterAll
	public static void afterAll() {
		System.out.println("\nAfter All executed.");
	}
}
