package com.wegneto.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {
	MyMath myMath = new MyMath();
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}
	
	@Before
	public void before() {
		System.out.println("@before");
	}
	
	@After
	public void after() {
		System.out.println("@after");
	}

	@Test
	public void sumWith3Numbers() {
		System.out.println("sumWith3Numbers");
		assertEquals(6, myMath.sum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sumWith1Number() {
		System.out.println("sumWith1Number");
		assertEquals(3, myMath.sum(new int[] { 3 }));
	}

}
