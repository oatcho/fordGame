package com.detroitlabs.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class HelloController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        Person n = new Person();
        n.setName(name);
        n.setEmail(email);
        personRepo.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<Person> getAllUsers() {
        return personRepo.findAll();
    }
}
