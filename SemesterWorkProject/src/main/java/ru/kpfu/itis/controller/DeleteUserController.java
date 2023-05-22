package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.UserService;

@RequiredArgsConstructor
@Controller
public class DeleteUserController {

    private final UserService userService;

    @GetMapping("/delete")
    public String delete(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            userService.deleteUser(details.getUsername());
            return "redirect:logout";
        }
        return "redirect:signIn";
    }
}
