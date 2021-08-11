package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @GetMapping("/addPerson")
    public String addPerson(Model model){
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/processPerson")
    public String processPerson(@ModelAttribute Person person){
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/addPet")
    public String addPet(Model model){
        model.addAttribute("pet", new Pet());
        model.addAttribute("people", personRepository.findAll());
        return "petForm";
    }

    @PostMapping("/processPet")
    public String processPet(@ModelAttribute Pet pet){
        petRepository.save(pet);
        return "redirect:/";
    }


}
