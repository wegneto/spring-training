package com.wegneto.springin5steps;

public class BinarySearchImpl {
	
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		//Sorting an array
		int[] result = sortAlgorithm.sort(new int[] {3,2,1});
		System.out.println(sortAlgorithm);
		
		//Search the array
		
		return 3;
	}
	
	
}
