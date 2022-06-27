package com.work.thymeleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Long> {

	
}
