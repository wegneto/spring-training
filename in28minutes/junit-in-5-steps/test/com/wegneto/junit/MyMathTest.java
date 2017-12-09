package com.wegneto.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyMathTest {
	
	MyMath myMath = new MyMath();

	@Test
	public void sumWith3Numbers() {
		assertEquals(6, myMath.sum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sumWith1Number() {
		assertEquals(3, myMath.sum(new int[] { 3 }));
	}

}
