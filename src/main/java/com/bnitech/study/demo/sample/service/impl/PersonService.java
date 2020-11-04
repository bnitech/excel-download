package com.bnitech.study.demo.sample.service.impl;

import com.bnitech.study.demo.sample.dao.Person;
import com.bnitech.study.demo.sample.dto.PersonDto;
import com.bnitech.study.demo.sample.repository.PersonRepository;
import com.bnitech.study.demo.sample.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;

    @Override
    public List<PersonDto> getPersonList() {
        List<Person> personList = personRepository.findAll();

        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personList) {
            personDtoList.add(new PersonDto(
                    person.getId(),
                    person.getName(),
                    person.getCompany(),
                    person.getSalary()
            ));
        }

        return personDtoList;
    }
}