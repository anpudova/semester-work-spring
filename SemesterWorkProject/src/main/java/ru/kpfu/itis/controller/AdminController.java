package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.UserService;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin")
    public String profile(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            model.addAttribute("users", userService.getUsers());
            return "admin";
        }
        return "redirect:signIn";
    }
}
