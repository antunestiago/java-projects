package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
    private final List<Person> list = new ArrayList<Person>();

    @Override
    public List<Person> getAllPersons() {
        return list;
    }

    @Override
    public Person save(Person p) {
        Person person = new Person();
        person.setId(p.getId());
        person.setName(p.getName());
        person.setSurname(p.getSurname());
        person.setEmail(p.getEmail());
        list.add(person);
        return person;
    }

    @Override
    public Person update(Person p) {
        int idx = 0;
        int id = 0;

        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), p.getId())) {
                id = p.getId();
                idx = i;
                break;
            }
        }

        Person person = new Person();
        person.setId(id);
        person.setName(p.getName());
        person.setName(p.getName());
        person.setSurname(p.getSurname());
        person.setEmail(p.getEmail());

        list.set(idx, person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : list) {
            if (person.getId() == (id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        list.removeIf(x -> Objects.equals(x.getId(), id));
    }
}
