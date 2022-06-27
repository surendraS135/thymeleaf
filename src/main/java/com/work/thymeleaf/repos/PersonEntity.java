package com.work.thymeleaf.repos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {
public PersonEntity(String name, int age) {
		super();
		Name = name;
		Age = age;
	}

@Id
@SequenceGenerator(name="person_sequence",sequenceName="person_sequence", initialValue = 1,allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="person_sequence")
@Column (name = "ID",nullable=false)
private Long id;

@Column (name = "NAME")
private String Name;

@Column (name = "AGE")
private int Age;

}
