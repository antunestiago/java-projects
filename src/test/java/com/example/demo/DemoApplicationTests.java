package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class DemoApplicationTests {

	@InjectMocks
	PersonServiceImpl personService;

	@Mock
	PersonRepository repository;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void shouldCreatePerson() {
		Person person = new Person();
		person.setId(1);
		person.setName("Tiago");
		person.setSurname("Antunes");
		person.setEmail("tiago@mail.com");

		when(repository.save(person)).thenReturn(person);

		Person p = personService.createPerson(person);

		assertEquals(person.getName(), p.getName());
		assertEquals(person.getId(), p.getId());
		assertEquals(person.getSurname(), p.getSurname());
		assertEquals(person.getEmail(), p.getEmail());
	}

	@Test
	void shouldGetAllPersons() {
		List<Person> list = new ArrayList<Person>();
		Person pOne = new Person(1, "John", "John", "howtodoinjava@gmail.com");
		Person pTwo = new Person(2, "Alex", "kolenchiski", "alexk@yahoo.com");
		Person pThree = new Person(3, "Steve", "Waugh", "swaugh@gmail.com");

		list.add(pOne);
		list.add(pTwo);
		list.add(pThree);

		when(repository.getAllPersons()).thenReturn(list);

		List<Person> persons = personService.getAllPersons();

		assertEquals(list.size(), persons.size());
		verify(repository, times(1)).getAllPersons();
	}
}
