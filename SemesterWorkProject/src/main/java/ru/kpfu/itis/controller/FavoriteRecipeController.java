package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kpfu.itis.exception.EntityNotFoundException;
import ru.kpfu.itis.model.dto.FavoriteRecipeDto;
import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.entity.api.InformationEntity;
import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.FavoriteRecipeService;
import ru.kpfu.itis.service.RecipeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FavoriteRecipeController {

    private final RecipeService recipeService;
    private final FavoriteRecipeService favoriteRecipeService;

    @GetMapping("/favorite")
    public String showFavorite(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            model.addAttribute("user", details.getUser());
            List<FavoriteRecipeDto> recipeDtoList = favoriteRecipeService.getAllRecipeByUser(details.getUser().getId());
            model.addAttribute("recipes", recipeDtoList);
            return "favorite_recipe";
        }
        return "redirect:signIn";

    }

    @GetMapping("/favorite/{id}")
    public String showFavoriteDetail(@AuthenticationPrincipal UserDetailsImpl details,
                                     Model model,
                                     @PathVariable("id") String id) {
        if (details != null) {
            model.addAttribute("user", details.getUser());
            InformationEntity info = recipeService.getInformationById(Long.parseLong(id));
            DetailRecipeEntity detail = recipeService.getDetailRecipeById(Long.parseLong(id));
            IngredientEntity ingredient = recipeService.getIngredientsById(Long.parseLong(id));
            boolean isFavorite = favoriteRecipeService.existRecipe(Long.parseLong(id), details.getUser().getId());
            String isFav = (isFavorite)? "Delete from favorite": "Add to favorite";
            model.addAttribute("isFavorite", isFav);
            model.addAttribute("userId", details.getUser().getId().toString());
            model.addAttribute("recipeId", id);
            model.addAttribute("info", info);
            model.addAttribute("detail", detail);
            model.addAttribute("ingredient", ingredient);
            model.addAttribute("lastPage", "favorite");
            return "detail_recipe";
        }
        return "redirect:signIn";
    }
}
