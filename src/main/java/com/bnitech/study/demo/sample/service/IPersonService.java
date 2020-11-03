package com.bnitech.study.demo.sample.service;

import com.bnitech.study.demo.sample.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getPersonList();

    PersonDto getPerson(long personId);
}