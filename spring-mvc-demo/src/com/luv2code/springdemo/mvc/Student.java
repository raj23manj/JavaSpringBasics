package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

//import org.springframework.beans.factory.annotation.Value;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	
//	@Value("#{countryOptions}") // this does not work
//	private LinkedHashMap<String,String> countryOptions; 
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public Student() {
//		countryOptions = new LinkedHashMap<>();
//		countryOptions.put("BR", "Brazil");
//		countryOptions.put("FR", "France");
//		countryOptions.put("GE", "Germany");
//		countryOptions.put("IN", "India");
//		countryOptions.put("US", "United States");
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}
	
	
}
