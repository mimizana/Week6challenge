package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean  implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String ... args){
        User user = new User("mc","bart@gmail.com","mc","Mc","mcmc",true);
        Role userRole = new Role("mc", "ROLE_USER");
        userRepository.save(user);
        roleRepository.save(userRole);

        User admin = new User("admin","super@domain.com", "admin" , "Admin","Adminadmin", true);
        Role adminRole1 =new Role("admin", "ROLE_ADMIN");
        Role adminRole2 =new Role("admin", "ROLE USER");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);


    }
}
