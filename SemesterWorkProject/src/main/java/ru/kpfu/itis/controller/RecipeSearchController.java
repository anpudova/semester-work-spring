package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.exception.EntityNotFoundException;
import ru.kpfu.itis.exception.NetworkErrorException;
import ru.kpfu.itis.model.dto.FavoriteRecipeDto;
import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.entity.api.InformationEntity;
import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.FavoriteRecipeService;
import ru.kpfu.itis.service.RecipeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RecipeSearchController {

    private final RecipeService recipeService;
    private final FavoriteRecipeService favoriteRecipeService;

    @GetMapping("/recipe")
    public String showRecipesByNameGet(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            model.addAttribute("user", details.getUser());
        }
        List<FavoriteRecipeDto> top = favoriteRecipeService.getAllFavoriteRecipeTop();
        model.addAttribute("top", top);
        return "recipes_search";
    }

    @PostMapping("/recipe")
    public String showRecipesByNamePost(RedirectAttributes redirectAttributes, @RequestParam("search") String name, Model model) {
        RecipeEntity recipe = recipeService.getRecipesByName(name);
        redirectAttributes.addFlashAttribute("recipes", recipe);
        if (recipe.getRecipes().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Nothing found for your request :(");
        }

        return "redirect:recipe";
    }


    @GetMapping("/recipe/{id}")
    public String redirectResult(@AuthenticationPrincipal UserDetailsImpl details,
                                 Model model,
                                 @PathVariable("id") String id) {
        if (details != null) {
            model.addAttribute("user", details.getUser());
            boolean isFavorite = favoriteRecipeService.existRecipe(Long.parseLong(id), details.getUser().getId());
            String isFav = (isFavorite)? "Delete from favorite": "Add to favorite";
            model.addAttribute("isFavorite", isFav);
            model.addAttribute("userId", details.getUser().getId().toString());
            model.addAttribute("recipeId", id);
        }
        InformationEntity info = recipeService.getInformationById(Long.parseLong(id));
        DetailRecipeEntity detail = recipeService.getDetailRecipeById(Long.parseLong(id));
        IngredientEntity ingredient = recipeService.getIngredientsById(Long.parseLong(id));
        model.addAttribute("info", info);
        model.addAttribute("detail", detail);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("lastPage", "recipe");
        return "detail_recipe";
    }

}
