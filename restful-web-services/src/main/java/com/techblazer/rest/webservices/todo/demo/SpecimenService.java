package com.techblazer.rest.webservices.todo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecimenService implements ISpecimenService {
	
	@Autowired
	private SpecimenDAO specimenDAO;
	
	@Override
	public List<SpecimenDTO> findAllSpecimen() {
		return specimenDAO.findAll();
	}

}
