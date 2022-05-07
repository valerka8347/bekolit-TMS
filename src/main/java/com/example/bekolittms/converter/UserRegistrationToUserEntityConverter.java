package com.example.bekolittms.converter;

import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.model.UserRegistration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationToUserEntityConverter implements Converter<UserRegistration, UserEntity> {
    @Override
    public UserEntity convert(UserRegistration source) {
        return new UserEntity()
                .setName(source.getName())
                .setUsername(source.getUsername())
                .setPassword(source.getPassword());
    }
}
