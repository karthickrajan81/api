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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class ApiApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		logger.info("ApiApplication successfully started!");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			var per1 = new Person("Steve", "Jobs");
			personService.addPerson(per1);
			var per2 = new Person("Bill", "Gates");
			personService.addPerson(per2);
			var per3 = new Person("Elon", "Musk");
			personService.addPerson(per3);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex.fillInStackTrace());
			throw ex;
		}

	}

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}
}
