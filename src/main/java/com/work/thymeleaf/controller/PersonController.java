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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepo repo;
	
	@Autowired
	PersonDetailsRepo derepo;
	
	@GetMapping("/People")
	String getPerson(Model model) {
		model.addAttribute("Major","Controlverse");
		model.addAttribute("batman","batman");
//		model.addAttribute("People",Arrays.asList(
//			new People("John", 28),
//			new People("Khan", 38)
//		));
		List<PersonEntity> list = (List<PersonEntity>) repo.findAll();
		List nameList = new ArrayList();
		List<People> pepList = new ArrayList<People>();
		list.stream().forEach(x->{
			System.out.println(x.getId()+" : "+x.getName()+"  :  "+x.getAge());
			String hob ="";
			String prof="";
			try {
				
			PersonDetailsEntity h=((PersonDetailsEntity)derepo.findByPersonId(x));
			 hob= h.getHobby();
			 prof = h.getProfession();
			}
			catch(Exception ex) {
				
			}
			pepList.add(new People(x.getName(), x.getAge(),hob,prof));
			nameList.add(x.getId()+" : "+x.getName()+"  :  "+x.getAge()+" : "+hob+" : "+prof);
		;
		});
		model.addAttribute("People",pepList);
		return "People";
	}

@PostMapping("/addPeople")
public String AddPerson(@ModelAttribute People people) {
	try {
		System.out.println("in Post");
		PersonEntity pe = new PersonEntity(people.getName(),people.getAge());
		PersonEntity pesaved = repo.save(pe);
		PersonDetailsEntity ped = new PersonDetailsEntity(pesaved,people.getHobby(),people.getProfession());
		derepo.save(ped);
		return "Success";
	}
	catch(Exception ex) {
		return "Failure";
	}	
}

@GetMapping("/AddMorePeople")
public String viewPerson(People people) {

	return "addPeople";
}


}
