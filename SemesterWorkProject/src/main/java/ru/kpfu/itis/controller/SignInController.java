package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.form.SignInForm;

@RequiredArgsConstructor
@Controller
public class SignInController {

    @RequestMapping(value = "/signIn")
    public String loginGet(ModelMap map, @ModelAttribute("loginForm") SignInForm form, BindingResult result) {
        map.put("form", new SignInForm());
        return "sign_in";
    }

}
