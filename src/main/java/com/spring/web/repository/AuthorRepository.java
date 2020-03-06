package com.spring.web.repository;

import com.spring.web.domain.entity.AuthorEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    List<AuthorEntity> findAllByName(String name);
}
