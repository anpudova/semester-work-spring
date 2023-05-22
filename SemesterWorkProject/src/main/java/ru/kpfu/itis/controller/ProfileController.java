package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.exception.DuplicateUsernameException;
import ru.kpfu.itis.model.form.EditProfileForm;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;


@RequiredArgsConstructor
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    @GetMapping()
    public String profile(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            model.addAttribute("isAdmin", user.getRole().getAuthority().equals("ROLE_ADMIN"));
            return "profile";
        }
        return "redirect:signIn";
    }

    @GetMapping("/edit")
    public String editGet(@AuthenticationPrincipal UserDetailsImpl details, Model model, ModelMap map, EditProfileForm form) {
        if (details != null) {
            model.addAttribute("user", details.getUser());
            map.put("form", form);
            return "edit_profile";
        }
        return "redirect:signIn";
    }

    @PostMapping("/edit")
    public String editPost(@AuthenticationPrincipal UserDetailsImpl details,
                           RedirectAttributes redirectAttributes,
                           @ModelAttribute("form") @Valid EditProfileForm form,
                           BindingResult result) {
        if (result.hasFieldErrors()) {
            String usernameErr = "";
            if (result.getFieldError("username") != null) {
                usernameErr = result.getFieldError("username").getDefaultMessage();
            }
            redirectAttributes.addFlashAttribute("errorFields", " " + usernameErr);
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#editGet").build();
        }
        try {
            userService.updateUsername(form.getUsername(), details.getUsername());
            details.getUser().setUsername(form.getUsername());
            return "redirect:";
        } catch (DuplicateUsernameException e) {
            redirectAttributes.addFlashAttribute("error", "Username already exist.");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#editGet").build();
        }

    }
}
