package com.spring.web.domain.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    @Min(2)
    @Max(888)
    private int id;
    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotEmpty(message = "email is blank")
    private String email;
}
