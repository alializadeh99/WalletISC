package com.example.wallet.repository;

import com.example.wallet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByNationalId(String nationalId);

}
