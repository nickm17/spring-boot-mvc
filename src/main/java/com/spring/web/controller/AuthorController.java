package com.spring.web.controller;

import com.spring.web.domain.model.AuthorDTO;
import com.spring.web.service.AuthorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

//    @Autowired
//    private AuthorService authorService;
    @NonNull
    private AuthorService authorService;

//    @Autowired
//    private TestInjectSuper authorService;

    @PutMapping("/{id}")
    public String updateAuthor(@ModelAttribute(name = "author") AuthorDTO author, @PathVariable int id, Model model) {

        author.setId(id);
        authorService.updateAuthor(author);
        model.addAttribute("authors", authorService.getAuthors());
        return "authors";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute(name = "author") @Valid AuthorDTO author, Model model) {
        authorService.createAuthor(author);
        model.addAttribute("authors", authorService.getAuthors());

        return "authors";
    }

    @GetMapping
    public String getAuthors(Model model){

        if(model != null || 1==1){
            List<AuthorDTO> authorsssdasd = null;
        }

        List<AuthorDTO> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping(path = "/showInsertPage")
    public String showInsertPage(Model model){
        model.addAttribute("author", authorService.getAuthorById(6));
        return "insert";
    }

    @GetMapping(path = "/showUpdatePage/{id}")
    public String showUpdatePage(@PathVariable int id, Model model){
        model.addAttribute("author", authorService.getAuthorById(id));
        return "update";
    }
}
