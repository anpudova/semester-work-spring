package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.exception.DuplicateUsernameException;
import ru.kpfu.itis.model.form.SignUpForm;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final UserService userService;

    @GetMapping( "/signUp")
    public String registrationGet(@AuthenticationPrincipal UserDetailsImpl details, ModelMap map) {
        if (details != null) {
            return "redirect:profile";
        }
        map.put("form", new SignUpForm());
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String registrationPost(RedirectAttributes redirectAttributes,
                                   @ModelAttribute("form") @Valid SignUpForm signUpForm,
                                   BindingResult result) {
        if (result.hasFieldErrors()) {
            String usernameErr = "";
            if (result.getFieldError("username") != null) {
                usernameErr = result.getFieldError("username").getDefaultMessage();
            }
            String passErr = "";
            if (result.getFieldError("password") != null) {
                passErr = result.getFieldError("password").getDefaultMessage();
            }
            redirectAttributes.addFlashAttribute("errorFields", " " + usernameErr + " " + passErr);
            return "redirect:signUp";
        }
        try {
            userService.registerUser(signUpForm);
            return "redirect:signIn";
        } catch (DuplicateUsernameException e) {
            redirectAttributes.addFlashAttribute("error", "Username already exist.");
            return "redirect:signUp";
        }
    }
}
