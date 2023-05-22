package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.request.ToggleFavoriteRequest;
import ru.kpfu.itis.service.FavoriteRecipeService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteRecipeRestController {

    private final FavoriteRecipeService favoriteService;

    @PostMapping("/toggle")
    public ResponseEntity<String> toggleFavorite(@RequestBody ToggleFavoriteRequest request) {
        if (request.getIsFavorite()) {
            favoriteService.deleteRecipe(Long.parseLong(request.getRecipe().getId()), Long.parseLong(request.getId()));
            return ResponseEntity.ok("Recipe successfully removed from favorites.");
        } else {
            favoriteService.addRecipe(request.getRecipe(), Long.parseLong(request.getId()));
            return ResponseEntity.ok("Recipe added to favorites successfully.");
        }
    }

    @GetMapping("/isFavorite")
    public ResponseEntity<Boolean> isRecipeInFavorites(@RequestParam String recipeId,
                                                       @RequestParam String userId) {

        boolean isFavorite = favoriteService.existRecipe(Long.parseLong(recipeId), Long.parseLong(userId));
        return ResponseEntity.ok(isFavorite);
    }
}
