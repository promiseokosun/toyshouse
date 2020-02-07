package com.techblazer.rest.webservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@GetMapping(value="/hello-world")
	public String helloWorld() {
		
		return "Hello World";
	} 
	
	@GetMapping(value="/hello-world-bean") 
	public HelloWorldBean helloWorldBean() {
		
		//throw new RuntimeException("Some Errors Occured: Check User Manual ***-***");
		return new HelloWorldBean("I Love you Irene");
	}
	
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean HelloWorldBeanWithPathVariable(@PathVariable("name") String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
