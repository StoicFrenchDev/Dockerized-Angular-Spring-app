package com.java21;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {

  private PersonRepository personRepository;

  public Controller(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping("/")
  public String hello() {
    return "Hello qqss!";
  }

  @PostMapping("/create")
  public Person createPerson(@RequestBody Person newPerson) {
    Person person = new Person(newPerson.getName(), newPerson.getAge());
    this.personRepository.save(person);
    return person;
  }

  @GetMapping("/getall")
  public ResponseEntity<List<Person>> getAllPersons() {
    List<Person> personData = new ArrayList<>();
    this.personRepository.findAll().forEach(personData::add);
    if (personData.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(personData, HttpStatus.OK);
    }
  }
}