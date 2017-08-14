package com.wegneto.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm {

	public int[] sort(int[] unsortedArray) {
		return unsortedArray;
	}
	
}
