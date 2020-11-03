package com.bnitech.study.demo.sample.service.impl;

import com.bnitech.study.demo.sample.dto.PersonDto;
import com.bnitech.study.demo.sample.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Override
    public List<PersonDto> getPersonList() {
        return null;
    }

    @Override
    public PersonDto getPerson(long personId) {
        return null;
    }
}