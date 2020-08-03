package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/index")
    public String index() {

        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
