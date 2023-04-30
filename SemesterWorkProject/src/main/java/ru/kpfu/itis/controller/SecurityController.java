package ru.kpfu.itis.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;

@Controller
public class SecurityController {

    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String loginGet(ModelMap map) {
        map.put("user", new UserEntity());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String loginPost(RedirectAttributes redirectAttributes,
                                   @ModelAttribute("user") UserEntity user) {

        String message = userService.loginUser(user);
        if (message.equals("Success")) {
            return "redirect:profile";
        }
        redirectAttributes.addFlashAttribute("error", message);
        return "redirect:login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String registrationGet(ModelMap map) {
        map.put("user", new UserEntity());
        return "sign-up";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String registrationPost(RedirectAttributes redirectAttributes,
                           @Valid @ModelAttribute("user") UserEntity user,
                           BindingResult result) {
        if (!result.hasErrors()) {
            String message = userService.registerUser(user);
            if (message.equals("Success")) {
                return "redirect:login";
            }
            redirectAttributes.addFlashAttribute("error", message);
        }
        String usernameErr = "";
        if (result.getFieldError("username") != null) {
            usernameErr = result.getFieldError("username").getDefaultMessage();
        }
        String passErr = "";
        if (result.getFieldError("password") != null) {
            passErr = result.getFieldError("password").getDefaultMessage();
        }
        redirectAttributes.addFlashAttribute("errorFields", " " + usernameErr + " " + passErr);
        return "redirect:signup";
    }

    @RequestMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile() {
        return "profile";
    }
}
