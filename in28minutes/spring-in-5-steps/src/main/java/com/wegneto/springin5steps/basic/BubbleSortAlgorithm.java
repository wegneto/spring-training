package com.wegneto.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubblesort")
public class BubbleSortAlgorithm implements SortAlgorithm {

	public int[] sort(int[] unsortedArray) {
		//logic for bubble sort
		return unsortedArray;
	}
	
}
