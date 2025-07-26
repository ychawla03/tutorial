package com.example.Mappings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mappings.entity.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

	//when you want custom queries to be created, we need to extend our repository
	//class only with JpaRepository and not with CrudRepository - Yes
	
	//
	List<Tutorial> findByPublished(boolean published);
	
	List<Tutorial> findByTitleContaining(String title);
}
