package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository  roleRepository;
}
