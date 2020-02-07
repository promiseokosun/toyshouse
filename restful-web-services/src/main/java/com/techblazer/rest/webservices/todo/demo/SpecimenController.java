package com.techblazer.rest.webservices.todo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SpecimenController {
	
	@Autowired
	private SpecimenService specimenService;
	
	@GetMapping("/users/specimen")
	public List<SpecimenDTO> showSpecimens() {
		List<SpecimenDTO> allSpecimen = specimenService.findAllSpecimen();
		return allSpecimen;
	}

}
