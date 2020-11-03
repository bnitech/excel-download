package com.bnitech.study.demo.sample.repository;

import com.bnitech.study.demo.sample.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}