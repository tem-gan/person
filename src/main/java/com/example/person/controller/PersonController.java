package com.example.person.controller;

import com.example.person.entity.Person;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Person person, HttpServletRequest req) {
        System.out.println(person.getFirstname());
        System.out.println(person.getLastname());
        return ResponseEntity.ok(service.create(person, req));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> read(@PathVariable("id") Long id, HttpServletRequest req) {
        return ResponseEntity.ok(service.read(id, req));
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@RequestBody Person person, HttpServletRequest req) {
        return ResponseEntity.ok(service.update(person, req));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id, HttpServletRequest req) {
        service.delete(id, req);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<Object> delete(HttpServletRequest req) {
        return ResponseEntity.ok(service.getAll(req));
    }

}
