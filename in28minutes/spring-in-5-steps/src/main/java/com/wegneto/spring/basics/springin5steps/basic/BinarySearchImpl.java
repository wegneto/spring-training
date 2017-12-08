package com.wegneto.spring.basics.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("bubblesort")
	private SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {
		int[] result = sortAlgorithm.sort(new int[] {3,2,1});
		System.out.println(sortAlgorithm);
		
		return 3;
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.info("this is the postConstruct method");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("this is the preDestroy method");
	}

}
