package ru.kpfu.itis.model.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @NotBlank(message = "Username can't be empty")
    @Pattern(regexp = "^[A-ZА-Я]([A-ZА-Яa-zа-я]{1,20})$",
            message = "Username entered incorrectly: eng. rus. letters, length=[2-20].")
    private String username;

    @NotBlank(message = "Password can't be empty")
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$",
            message = "Password entered incorrectly: min.length=8, use large, small letters and numbers.")
    private String password;

}
