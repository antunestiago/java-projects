package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}
