package com.example.wallet.controller;


import com.example.wallet.model.Person;
import com.example.wallet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    // Constructor Injection
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // متد برای دریافت همه اشخاص
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // متد برای دریافت یک شخص بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // متد برای ایجاد شخص جدید
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // متد برای به‌روزرسانی اطلاعات شخص
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return ResponseEntity.ok(personService.updatePerson(id, updatedPerson));
    }

    // متد برای حذف شخص بر اساس ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<Person> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Person currentPerson = (Person) authentication.getPrincipal();

        return ResponseEntity.ok(currentPerson);
    }
}

