package com.project.sbb_nau.controller;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {

    @NotEmpty
    @Email
    private String login;

    @NotEmpty
    private String password;
}
