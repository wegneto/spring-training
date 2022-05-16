package com.wegneto.springdemo.service;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return this.toString();
	}

}
