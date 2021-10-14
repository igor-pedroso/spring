package br.com.igorpedroso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igorpedroso.model.Person;
import br.com.igorpedroso.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@GetMapping("/{email}")
	public Person findOne(@PathVariable String email) {
		return personService.findOne(email);
	}

	@PostMapping
	public Map<String, String> insert(@RequestBody Person person) {
		return personService.insert(person);
	}
}
