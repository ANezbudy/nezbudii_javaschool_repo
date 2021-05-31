package com.project.sbb_nau.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
