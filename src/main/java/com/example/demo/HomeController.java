package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "secure";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("departments", departmentRepository.findAll());
        return "register";
    }

    @PostMapping("/processregister")
    public String processRegisterPage(@Valid @ModelAttribute("user") User user,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.clearPassword();
            model.addAttribute("user", user);
            return "register";
        }
        else{
            model.addAttribute("user", user);
            model.addAttribute("message", "New user account created");
            //user.setEnabled(true);
            userRepository.save(user);

            Role role = new Role(user.getUsername(), "ROLE_USER");
            roleRepository.save(role);
            //return "redirect:/";
            return "index";
        }
    }

    @RequestMapping("/newDepart")
    public String newDepart(Model model) {

        model.addAttribute("department", new Department());
        return "newdepart";
    }

    @PostMapping("/processDepart")
    public String processDepart(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:/";
    }

    @RequestMapping("/updateDepart/{id}")
    public String updateDepart(@PathVariable("id") Long id, Model model){
        model.addAttribute("department", departmentRepository.findById(id).get());
        return "newdepart";
    }

    @RequestMapping("/showDepart/{id}")
    public String showDepart(@PathVariable("id") Long id, Model model){
        model.addAttribute("department", departmentRepository.findById(id).get());
        return "showdepart";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userRepository.findById(id).get());
        model.addAttribute("departments", departmentRepository.findAll());
        return "register";
    }

}
