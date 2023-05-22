package ru.kpfu.itis.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping()
    public String root(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            return "redirect:profile";
        }
        return "redirect:signIn";
    }
}
