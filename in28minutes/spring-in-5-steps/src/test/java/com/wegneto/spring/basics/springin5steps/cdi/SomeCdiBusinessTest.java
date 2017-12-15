package com.wegneto.spring.basics.springin5steps.cdi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	@InjectMocks
	private SomeCdiBusiness business;

	@Mock
	private SomeCdiDAO daoMock;

	@Test
	public void testBasicScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 });

		int actual = business.findGreatest();
		int expected = 4;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testEmptyDataScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });

		int actual = business.findGreatest();
		int expected = Integer.MIN_VALUE;
		
		Assert.assertEquals(expected, actual);
	}

}
