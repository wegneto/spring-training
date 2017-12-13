package com.wegneto.mockito.mockitodemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
		
	}

}

class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAlldata() {
		return new int[] {24, 6, 15};
	}
}