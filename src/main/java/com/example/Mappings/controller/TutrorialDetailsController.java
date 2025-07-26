package com.example.Mappings.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mappings.entity.Tutorial;
import com.example.Mappings.entity.TutorialDetails;
import com.example.Mappings.exceptions.ResourceNotFoundException;
import com.example.Mappings.repository.TutorialDetailsRepository;
import com.example.Mappings.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class TutrorialDetailsController {

	@Autowired
	private TutorialDetailsRepository detailsRepository;
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@PostMapping("/tutorials/{tutorialId}/details")
	public ResponseEntity<TutorialDetails> 
		createDetails(@PathVariable(value = "tutorialId") Long tutorialId,
				@RequestBody TutorialDetails tutorialDetails) throws ResourceNotFoundException{
		Tutorial _tutorial = tutorialRepository.findById(tutorialId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"No tutorial found with id "
							+ tutorialId));
		
		tutorialDetails.setCreatedOn(new Date());
		tutorialDetails.setTutorial(_tutorial);
		TutorialDetails tutorialDetails2 = detailsRepository.save(tutorialDetails);
		return new ResponseEntity<TutorialDetails>(tutorialDetails2, HttpStatus.CREATED);
		
	}
}
