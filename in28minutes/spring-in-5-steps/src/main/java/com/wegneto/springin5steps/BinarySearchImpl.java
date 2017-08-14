package com.wegneto.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {
		int[] result = sortAlgorithm.sort(new int[] {3,2,1});
		System.out.println(sortAlgorithm);
		
		return 3;
	}
	
	
}
