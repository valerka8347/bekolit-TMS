package com.example.bekolittms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserLogin {

    private long id;

    @NotNull
    @Size (min = 3, max = 100)
    private String username;

    @NotNull
    @Size(min = 6, max = 10, message = "Пароль введен некоректно,проверьте правильность ввода и " +
            " повторите попытку еще раз")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLogin setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }
}
