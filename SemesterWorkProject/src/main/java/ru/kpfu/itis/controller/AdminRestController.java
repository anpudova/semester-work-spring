package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.dto.UserAdminDto;
import ru.kpfu.itis.model.form.SignUpForm;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
@RestController
public class AdminRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserAdminDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/add")
    public ResponseEntity<UserAdminDto> addUser(@Valid @RequestBody SignUpForm form) {
        return new ResponseEntity<>(userService.registerUser(form), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}/ban")
    public ResponseEntity<?> unbanUser(@PathVariable("id") Long id) {
        userService.banUser(id);
        return ResponseEntity.accepted().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}/unban")
    public ResponseEntity<?> banUser(@PathVariable("id") Long id) {
        userService.unbanUser(id);
        return ResponseEntity.accepted().build();
    }
}
