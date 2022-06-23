package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person p);

    Person updatePerson(Person p);

    Person getPersonById(int id);

    List<Person> getAllPersons();

    String deletePerson(int id);
}
