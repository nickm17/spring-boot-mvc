package com.spring.web.controller;

import com.spring.web.domain.model.AuthorDTO;

import java.util.List;

public interface TestInjectSuper {
    public AuthorDTO getAuthorById(int id);
    List<AuthorDTO> getAuthors();
}
