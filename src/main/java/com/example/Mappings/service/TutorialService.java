package com.example.Mappings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mappings.entity.Tutorial;
import com.example.Mappings.repository.TutorialRepository;

@Service
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;
	
	public Tutorial createTutorial(Tutorial tutorial){
		Tutorial _tutorial = 
				tutorialRepository.save(new Tutorial(tutorial.getTitle(),
				tutorial.getDescription(), false));
		return _tutorial;
	}
	
	
}
