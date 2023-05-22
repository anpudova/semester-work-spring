package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.service.UserRecipeService;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class UserRecipeRestController {

    private final UserRecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRecipeDto> getRecipe(@PathVariable("id") Long id) {
        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @GetMapping
    public ResponseEntity<List<UserRecipeDto>> getAllRecipe() {
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.accepted().build();
    }

}
