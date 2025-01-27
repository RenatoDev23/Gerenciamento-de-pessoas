package one.digitalinovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.personapi.Entity.Person;
import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/peaple")
public class PersonController {
	
	private PersonRepository personRepository;
	

	@Autowired
	public PersonController(PersonRepository personRepository) {
			this.personRepository = personRepository;
	}


	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Create persaon with ID" + savedPerson.getId())
				.build(); 

	}

}
