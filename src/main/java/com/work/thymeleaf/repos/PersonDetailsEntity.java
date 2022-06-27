package com.work.thymeleaf.repos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Person_Details")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonDetailsEntity {
	public PersonDetailsEntity(PersonEntity personId, String profession, String hobby) {
		super();
		PersonId = personId;
		this.profession = profession;
		this.hobby = hobby;
	}

	@Id
	@SequenceGenerator(name="persond_sequence",sequenceName="persond_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="persond_sequence")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Person_ID",nullable=false,referencedColumnName = "id")
	private PersonEntity PersonId;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="hobby")
	private String hobby;


}
