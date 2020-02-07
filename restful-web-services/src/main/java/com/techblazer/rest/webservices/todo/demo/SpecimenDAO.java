package com.techblazer.rest.webservices.todo.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SpecimenDAO implements ISpecimenDAO {
	
	private static List<SpecimenDTO> specimens= new ArrayList<SpecimenDTO>();
	private static long idCounter = 0;
	
	static {
		specimens.add(new SpecimenDTO(++idCounter, "in28minutes", "Reading and Dancing", false, new Date() ));
		specimens.add(new SpecimenDTO(++idCounter, "Fred Matty", "Surfing the Internet", true, new Date() ));
		specimens.add(new SpecimenDTO(++idCounter, "in28minutes", "Reading and Dancing", false, new Date() ));
		specimens.add(new SpecimenDTO(++idCounter, "Williams Adams", "Swimming", true, new Date()));
		
	}
	
	@Override
	public List<SpecimenDTO> findAll() {
		return specimens;
	}
	
}
