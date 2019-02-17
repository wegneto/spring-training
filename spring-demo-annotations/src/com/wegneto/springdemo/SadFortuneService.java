package com.wegneto.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return this.toString();
	}

}
