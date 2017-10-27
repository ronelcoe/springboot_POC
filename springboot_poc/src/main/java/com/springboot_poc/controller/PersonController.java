package com.springboot_poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_poc.bean.Person;
import com.springboot_poc.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping("/persons")
	public List<Person> getPersons() {
		return personService.getPersonList();
	}
	
	@RequestMapping("/persons/{id}")
	public Person getPersonById(@PathVariable String id) {
		return personService.getPersonById(Long.valueOf(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/persons")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/persons/{id}")
	public void updatePerson(@RequestBody Person person, @PathVariable String id) {
		personService.updatePerson(Long.valueOf(id), person);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/persons/{id}")
	public void deletePersonById(@PathVariable String id) {
		personService.deletePersonById(Long.valueOf(id));
	}
}
