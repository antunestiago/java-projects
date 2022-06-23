package com.example.demo.repository;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getAllPersons();
    Person save(Person person);
    void delete(Integer id);
    Person update(Person p);
    Person findById(int id);
}
