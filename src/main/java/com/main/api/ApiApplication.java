package com.main.api;

import com.main.api.entities.Person;
import com.main.api.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiApplication implements ApplicationRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var per1 = new Person("Steve", "Jobs");
		personService.addPerson(per1);
		var per2 = new Person("Bill", "Gates");
		personService.addPerson(per2);
		var per3 = new Person("Elon", "Musk");
		personService.addPerson(per3);

	}

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}
}
