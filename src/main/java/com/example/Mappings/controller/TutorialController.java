package com.example.Mappings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mappings.entity.Tutorial;
import com.example.Mappings.service.TutorialService;

@RestController
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;
	
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
		
		Tutorial _tutorial = tutorialService.createTutorial(tutorial);
		return new ResponseEntity<Tutorial>(_tutorial, HttpStatus.CREATED);
	}
	
	
	
}
