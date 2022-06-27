package com.work.thymeleaf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.thymeleaf.model.People;
import com.work.thymeleaf.repos.PersonDetailsEntity;
import com.work.thymeleaf.repos.PersonDetailsRepo;
import com.work.thymeleaf.repos.PersonEntity;
import com.work.thymeleaf.repos.PersonRepo;
import com.work.thymeleaf.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo repo;
	
	@Autowired
	PersonDetailsRepo derepo;
	
	@Override
	public List<People> viewPeople() {
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
		return pepList;
	}

	@Override
	public void addPeople(People people) {
		PersonEntity pe = new PersonEntity(people.getName(),people.getAge());
		PersonEntity pesaved = repo.save(pe);
		PersonDetailsEntity ped = new PersonDetailsEntity(pesaved,people.getHobby(),people.getProfession());
		derepo.save(ped);
	}

}
