package com.springboot_poc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot_poc.bean.Person;

@Service
public class PersonService {

	private List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "Ronel", "Chavez", 32),
			new Person(2, "Nathan", "Drake", 34), new Person(3, "Silva", "Cruise", 25)));

	public List<Person> getPersonList() {
		return this.personList;
	}

	public Person getPersonById(long id) {
		return personList.stream().filter(person -> person.getId() == id).findFirst().get();
	}

	public void addPerson(Person person) {
		personList.add(person);
	}

	public void updatePerson(Long id, Person updatedPerson) {
		Person personData = personList.stream().filter(person -> person.getId() == id).findFirst().get();
		personList.set(personList.indexOf(personData), updatedPerson);
	}

	public void deletePersonById(Long id) {
		personList.remove(personList.stream().filter(person -> person.getId() == id).findFirst().get());
	}
}
