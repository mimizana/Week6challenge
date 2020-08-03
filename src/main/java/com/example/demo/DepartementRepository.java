package com.example.demo;

import com.example.demo.Departement;
import com.example.demo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement, Long> {
}