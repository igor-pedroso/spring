package br.com.igorpedroso.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.igorpedroso.model.Person;

@Service
public class PersonService {
	private List<Person> listOfPersons = new ArrayList<Person>();

	public List<Person> findAll() {
		return this.listOfPersons;
	}

	public Person findOne(String email) {
		for(Person person : this.listOfPersons) {
			if (person.getEmail().equals(email)) {
				return person;
			}
		}
		return null;
	}
	public Map<String, String> insert(Person person){
		boolean isSuccess = this.listOfPersons.add(person);
		Map<String,String> result = new HashMap<String,String>();
		if(isSuccess) {
			result.put("result", "Pessoa cadastrada com sucesso!!!");
		}else {
			result.put("result", "Não foi possível cadastrar a pessoa!!!");
		}
		return result;
	}
}
