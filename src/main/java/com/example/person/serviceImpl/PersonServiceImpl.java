package com.example.person.serviceImpl;

import com.example.person.dto.Response;
import com.example.person.entity.Person;
import com.example.person.repository.PersonRepository;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    /**
     * Create person
     *
     * @param person request body
     * @param req    servlet request
     * @return {@link Person}
     * @author Tushig Battumur
     **/

    public Person create(Person person, HttpServletRequest req) {
        return repository.save(person);
    }

    public Person read(Long id, HttpServletRequest req) {
        return repository.findById(id).orElse(null);
    }

    public Person update(Person person, HttpServletRequest re) {
        return repository.save(person);
    }

    public void delete(Long id, HttpServletRequest req) {
        repository.deleteById(id);
    }

    public List<Person> getAll(HttpServletRequest req) {
        List<Person> people = repository.findAll();
//        people.forEach(person -> {
//            person.setLastname(null);
//        });
        return people;
    }
}