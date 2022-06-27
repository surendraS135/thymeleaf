package com.work.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.thymeleaf.repos.PersonRepo;
import com.work.thymeleaf.repos.PersonDetailsEntity;
import com.work.thymeleaf.repos.PersonDetailsRepo;
import com.work.thymeleaf.repos.PersonEntity;

@RestController
public class IndexController {
	
	@Autowired
	PersonRepo repo;
	
	@Autowired
	PersonDetailsRepo derepo;
	
	@GetMapping("/getPeopleData")
	public String index() {
		System.out.println("Gobar");
		
		List<PersonEntity> list = (List<PersonEntity>) repo.findAll();
		List nameList = new ArrayList();
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
			nameList.add(x.getId()+" : "+x.getName()+"  :  "+x.getAge()+" : "+hob+" : "+prof);
		;
		});
		
		return nameList.toString();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/PostPeopleData")
	public String postPeople() {
		PersonEntity pt = new PersonEntity();
		//pt.setId(12L);
		pt.setName(generateRandomPassword(10));
		pt.setAge((new Random()).nextInt(100));
		PersonEntity prSaved =  repo.save(pt);
		
		PersonDetailsEntity pde = new PersonDetailsEntity();
		pde.setPersonId(prSaved);
		pde.setHobby("Dancing");
		pde.setProfession("Coding");
		PersonDetailsEntity pdesaved = derepo.save(pde);
		return prSaved.getName()+" : "+pdesaved.getHobby();
	}
	
	public static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
}
