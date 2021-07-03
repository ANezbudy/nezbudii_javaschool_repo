package com.project.sbb_nau.service.implementation;

import com.project.sbb_nau.entity.RoleEntity;
import com.project.sbb_nau.entity.UserEntity;
import com.project.sbb_nau.repository.RoleEntityRepository;
import com.project.sbb_nau.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.project.sbb_nau.service.UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity userRole = roleEntityRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if(userEntity != null) {
            if(passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
