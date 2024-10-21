/*
package com.example.wallet.validator;

import com.example.wallet.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.*;


@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        Long age = getAge(person);

        if ((person.getGender() != null) &&
            (person.getGender().equals("m")) &&
            (age >= 18) &&
            (person.getMilitaryStatus() == null)
        ) {
            errors.reject("militaryStatus", "militaryStatus is required for MALEs older than 18");
        }
    }

    private static Long getAge(Person person) {
        Long age = null;
        if (person.getBirthDate() != null) {
            Duration duration = Duration.between(LocalDateTime.of(
                    person.getBirthDate(), LocalTime.now()), ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Tehran")));
            age = Math.abs(duration.toDays() / 365);
        }
        return age;
    }
}*/