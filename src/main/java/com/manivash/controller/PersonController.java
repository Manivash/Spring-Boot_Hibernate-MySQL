package com.manivash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manivash.dao.PersonDao;
import com.manivash.model.Person;
import com.manivash.model.PersonResponse;

@RestController
@RequestMapping("/spring-boot-orm")
public class PersonController {

	@Autowired
	private PersonDao dao;

	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		dao.savePerson(person);
		
		return "success";
	}

	@GetMapping("/getAll")
	public PersonResponse getALlPersons() {
		
		PersonResponse personResponse=new PersonResponse();
		personResponse.setStatus(1);
		personResponse.setMessage("Success");
		personResponse.setPerson(dao.getPersons());
		
		return personResponse;
	}

}
