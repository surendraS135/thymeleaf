package com.work.thymeleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepo extends JpaRepository<PersonDetailsEntity, Long> {
	
	@Query("FROM PersonDetailsEntity WHERE PersonId = :id")
	PersonDetailsEntity findByPersonId(PersonEntity id);
	
	
	
}
