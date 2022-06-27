package com.work.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.work.thymeleaf.model.*;
import com.work.thymeleaf.repos.PersonDetailsEntity;
import com.work.thymeleaf.repos.PersonDetailsRepo;
import com.work.thymeleaf.repos.PersonEntity;
import com.work.thymeleaf.repos.PersonRepo;
import com.work.thymeleaf.service.PersonService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PersonController {
	
	@Autowired
	PersonService pservice;
	
	@GetMapping("/ViewPeople")
	String getPerson(Model model) {
		model.addAttribute("Major","Controlverse");
		model.addAttribute("batman","batman");
		List<People> pepList =	pservice.viewPeople();
		model.addAttribute("People",pepList);
		return "People";
	}

@PostMapping("/AddPeople")
public String AddPerson(@ModelAttribute People people) {
	try {
		System.out.println("in Post");
		pservice.addPeople(people);
		return "Success";
	}
	catch(Exception ex) {
		return "Failure";
	}	
}

@GetMapping("/AddMorePeople")
public String viewPerson(People people) {

	return "AddPeople";
}


}
