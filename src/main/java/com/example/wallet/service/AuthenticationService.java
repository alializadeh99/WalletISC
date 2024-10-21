package com.example.wallet.service;

import com.example.wallet.dtos.LoginUserDto;
import com.example.wallet.dtos.RegisterUserDto;
import com.example.wallet.model.Person;
import com.example.wallet.repository.PersonRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            PersonRepository personRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person signup(RegisterUserDto input) {
        Person person = new Person();
        person.setEmail(input.getEmail());
        person.setFirstName(input.getFirstName());
        person.setLastName(input.getLastName());
        person.setPassword(input.getPassword());
        person.setNationalId(input.getNationalId());
        person.setMobileNumber(input.getMobileNumber());
        person.setMilitaryStatus(input.getMilitaryStatus());
        person.setGender(input.getGender());
        person.setBirthDate(input.getBirthDate());
        try {
            person = personRepository.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public Person authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getNationalId(),
                        input.getPassword()
                )
        );

        return personRepository.findByNationalId(input.getNationalId())
                .orElseThrow();
    }
}
