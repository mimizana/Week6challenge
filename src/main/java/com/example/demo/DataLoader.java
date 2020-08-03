package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception {
        Departement hr = new Departement();
        hr.setName("HR");
        departementRepository.save(hr);

        Departement it = new Departement();
        it.setName("IT");
        departementRepository.save(it);

        Employee employee1 = new Employee();

        employee1.setFirstName("Bonya");
        employee1.setLastName("Klein");
        employee1.setEmployed(true);
        employeeRepository.save(employee1);
        employee1.addDepartement(hr);

        Employee employee2 = new Employee();

        employee2.setFirstName("Meenu");
        employee2.setLastName("Grach");
        employee2.setEmployed(true);
        employeeRepository.save(employee2);
        employee2.addDepartement(it);
    }
}
