package com.wegneto.spring.basics.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quicksort")
public class QuickSortAlgorithm implements SortAlgorithm {

	public int[] sort(int[] unsortedArray) {
		//logic for quick sort
		return unsortedArray;
	}
	
}
