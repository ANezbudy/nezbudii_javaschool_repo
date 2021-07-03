package com.project.sbb_nau.service;

import com.project.sbb_nau.entity.UserEntity;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);

    UserEntity findByLogin(String login);

    UserEntity findByLoginAndPassword(String login, String password);
}
