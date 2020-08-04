package com.example.demo;

import com.example.demo.Role;
import com.example.demo.RoleRepository;
import com.example.demo.User;
import com.example.demo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean  implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public void run(String... args){
        Department department= new Department();
        department.setName("HR");
        departmentRepository.save(department);

        Department department2 = new Department();
        department2.setName("IT");
        departmentRepository.save(department2);




        User user = new User("bart","bart@gmail.com","bart","bart","Simpson",true);
        Role userRole = new Role("bart", "ROLE_USER");

        user.setDepartment(department);
        user.setJobTitle("Tester");
        userRepository.save(user);
        roleRepository.save(userRole);


        User admin = new User("super","super@domain.com", "super" , "Super","Hero", true);
        Role adminRole1 =new Role("super", "ROLE_ADMIN");
        Role adminRole2 =new Role("super", "ROLE USER");
        admin.setDepartment(department);
        admin.setJobTitle("Manager");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);


    }
}
