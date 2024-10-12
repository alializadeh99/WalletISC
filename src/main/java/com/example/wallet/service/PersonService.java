package com.example.wallet.service;

import com.example.wallet.model.Person;
import com.example.wallet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id,Person updatedPerson){
        Optional<Person> existingPersonOptional=personRepository.findById(id);
        if (existingPersonOptional.isPresent()){
            Person existingPerson=existingPersonOptional.get();

            existingPerson.setMobileNumber(updatedPerson.getMobileNumber());
            existingPerson.setMilitaryStatus(updatedPerson.getMilitaryStatus());
            existingPerson.setEmail(updatedPerson.getEmail());

            return personRepository.save(existingPerson);
        }
        else {
            throw new RuntimeException("کاربری با این شناسه یافت نشد:" + id);
        }

    }
}
