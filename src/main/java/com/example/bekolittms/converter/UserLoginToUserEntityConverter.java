package com.example.bekolittms.converter;

import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.model.UserLogin;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserLoginToUserEntityConverter implements Converter<UserLogin, UserEntity> {

    @Override
    public UserEntity convert(UserLogin source) {
        return new UserEntity()
                .setUsername(source.getUsername())
                .setPassword(source.getPassword());

    }
}
