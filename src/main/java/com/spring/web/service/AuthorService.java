package com.spring.web.service;

import com.spring.web.controller.TestInjectSuper;
import com.spring.web.domain.entity.AuthorEntity;
import com.spring.web.domain.model.AuthorDTO;
import com.spring.web.repository.AuthorRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorService implements TestInjectSuper {

    private final AuthorRepository authorRepository;

    public void createAuthor(AuthorDTO authorDTO) {
        AuthorEntity ae = new AuthorEntity(authorDTO.getId(), authorDTO.getName(), authorDTO.getEmail());
        authorRepository.save(ae);
    }

    public AuthorDTO getAuthorById(int id) {
        AuthorEntity ae = authorRepository.findById(id).get();
        return new AuthorDTO(ae.getId(), ae.getName(), ae.getEmail());
    }

    public List<AuthorDTO> getAuthors() {
        List<AuthorEntity> allAuthorsEntities = authorRepository.findAll();
//        List<AuthorEntity> allAuthorsEntities = authorRepository.findAllByName("Ion");
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for (AuthorEntity ae : allAuthorsEntities) {
            authorDTOS.add(new AuthorDTO(ae.getId(), ae.getName(), ae.getEmail()));
        }
        return authorDTOS;
    }

    public void updateAuthor(AuthorDTO authorDTO) {
        AuthorEntity ae = new AuthorEntity(authorDTO.getId(), authorDTO.getName(), authorDTO.getEmail());
        authorRepository.save(ae);
    }
}
