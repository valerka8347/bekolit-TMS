package com.example.bekolittms.model;

import com.example.bekolittms.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserRegistration {

    private long id;

    @NotNull
    @NotBlank
    @Length(min = 2, message = "Длина должна иметь минимум 2 символа")
    @Pattern(regexp = "^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$", message = "Имя должно состоять из латинских букв и" +
            "кирилицы")
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 2, message = "Длина должна иметь минимум 2 символа")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{1,20}$", message = "Имя пользователя должно только состоять из латинских букв," +
            "кирилицы и цифр")
    private String username;

    @NotNull
    @NotBlank
    @Length(min = 6, max = 10, message = "Длина должна быть минимум 6 символов и масимум 8")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
    message = "пароль должен состоять только из букв, цифр, длиною не более 10 символов")
    private String password;

    private Set<RoleEntity> roles;

}
