package com.spring.web.controller;

import com.spring.web.domain.model.AuthorDTO;
import com.spring.web.service.AuthorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;
    @Mock
    private AuthorService authorService;

    @Test
    public void testGetAuthors(){

        AuthorDTO mockAuthor = Mockito.mock(AuthorDTO.class);

        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authorDTOS.add(new AuthorDTO(1, "sdas","dasd"));
        authorDTOS.add(mockAuthor);

        doReturn(authorDTOS).when(authorService).getAuthors();

        Model modelSpy = Mockito.spy(Model.class);
        String result = authorController.getAuthors(modelSpy);

        assertThat(result).isEqualTo("authors");
    }

    @Test
    public void testGetAuthorsWithException(){

        Throwable throwable = catchThrowable(() -> authorController.getAuthors(null));
//        catchThrowableOfType(() -> authorController.getAuthors(null), NullPointerException.class);

        assertThat(throwable).isInstanceOf(NullPointerException.class);
    }
}
