package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("restService")
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "From Rest";
	}

}
