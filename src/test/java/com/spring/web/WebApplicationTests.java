package com.spring.web;

import com.spring.web.controller.AuthorController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Autowired
    private AuthorController authorController;

    @Test
    public void contextLoads() {

        authorController.getAuthors(Mockito.mock(Model.class));
    }

}
