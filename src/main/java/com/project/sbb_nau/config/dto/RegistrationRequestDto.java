package com.project.sbb_nau.config.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequestDto {

    @NotEmpty
    @Email
    private String login;

    @NotEmpty
    @Length(min = 8, max = 20)
    private String password;
}
