package com.work.thymeleaf.service;

import java.util.List;

import com.work.thymeleaf.model.People;


public interface PersonService {
	
	
	public List<People> viewPeople();
	
	public void addPeople(People people);

}
