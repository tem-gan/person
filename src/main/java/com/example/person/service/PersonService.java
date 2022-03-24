package com.example.person.service;

import com.example.person.entity.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PersonService {

    Person create(Person person, HttpServletRequest req);

    Person read(Long id, HttpServletRequest req);

    Person update(Person person, HttpServletRequest re);

    void delete(Long id, HttpServletRequest req);

    List<Person> getAll(HttpServletRequest req);

}
