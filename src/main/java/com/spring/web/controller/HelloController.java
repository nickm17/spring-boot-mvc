package com.spring.web.controller;

import com.spring.web.domain.model.AuthorDTO;
import com.spring.web.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

//    @Autowired
    private HelloService helloService = new HelloService();
    @Autowired
    private AuthorRepository authorRepository;
    List<AuthorDTO> authorDTOS = new ArrayList<>();
    @GetMapping
//    @RequestMapping(method = RequestMethod.GET) // echivalent cu @GetMapping
    public String home() {
        String x = helloService.getX();
        x.length();
        return "index";
    }

    @PostMapping
    public void helloForm(@RequestParam("name") String name, Model model){
        model.addAttribute("user", name);
//        return "response";
    }

//    @PostMapping(path = "/authors")
//    public String helloForm(@ModelAttribute AuthorDTO authorDTO, Model model) {
//        authorDTOS.add(authorDTO);
//        authorRepository.save(authorDTO);
//        model.addAttribute("authors", authorDTOS);
//        return "authors";
//    }

//    @GetMapping(path = "/authors")
//    public void getAuthors(Model model, ModelMap modelMap, ModelAndView modelAndView){
//
//        authorDTOS.add(new AuthorDTO(1, "Mihai Eminescu", "mihai_eminescu@gmail.com"));
////        model.addAttribute("authorDTOS", authorDTOS);
//        modelAndView.setViewName("authors");
////        modelAndView.addObject("authorDTOS", authorDTOS);
//        modelAndView.getModelMap().addAttribute("authors", authorDTOS);
////        return "authorDTOS";
//    }

//    @GetMapping(path = "/authors/showInsertPage")
//    public String showInsertPage(Model model){
//        model.addAttribute("author",new AuthorDTO());
//        return "insert";
//    }
}
