package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository repository;

    @Override
    public Person createPerson(Person p) {
        return repository.save(p);
    }

    @Override
    public Person updatePerson(Person p) {
        return repository.update(p);
    }

    @Override
    public Person getPersonById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return repository.getAllPersons();
    }

    @Override
    public String deletePerson(int id) {
        if (this.getPersonById(id) != null) {
            repository.delete(id);
            return "Person removed !!" + id;
        }

        return "Person not found!!";
    }
}
