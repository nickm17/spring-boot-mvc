package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
//    @RequestMapping(method = RequestMethod.GET) // echivalent cu @GetMapping
    public String home() {
        helloService.hashCode();
        return "index";
    }

    @PostMapping
    public String helloForm(@RequestParam("name") String name, Model model){
        model.addAttribute("user", name);
        return "response";
    }
}
