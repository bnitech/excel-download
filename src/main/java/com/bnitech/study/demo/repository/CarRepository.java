package com.bnitech.study.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnitech.study.demo.dao.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}