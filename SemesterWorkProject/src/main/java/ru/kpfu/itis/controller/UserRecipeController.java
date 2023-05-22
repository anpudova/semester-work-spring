package ru.kpfu.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.converter.LocalDateConverter;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.form.UserRecipeForm;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.security.details.UserDetailsImpl;
import ru.kpfu.itis.service.CategoryService;
import ru.kpfu.itis.service.UserRecipeService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/myRecipe")
public class UserRecipeController {

    private final UserRecipeService recipeService;
    private final CategoryService categoryService;

    @GetMapping()
    public String myRecipeAllGet(@AuthenticationPrincipal UserDetailsImpl details, Model model) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            List<UserRecipeDto> recipes = recipeService.getAllRecipeByUser(user);
            model.addAttribute("recipes", recipes);
            return "all_user_recipe";
        }
        return "redirect:signIn";
    }

    @GetMapping("/{id}")
    public String myRecipeGet(@AuthenticationPrincipal UserDetailsImpl details,
                              Model model,
                              @PathVariable("id") String id) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            UserRecipeDto recipe = recipeService.getRecipe(Long.parseLong(id));
            model.addAttribute("recipe", recipe);
            return "detail_user_recipe";
        }
        return "redirect:signIn";
    }

    @GetMapping("/add")
    public String myRecipeAddGet(@AuthenticationPrincipal UserDetailsImpl details,
                              Model model,
                              ModelMap map) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            map.put("form", new UserRecipeForm());
            model.addAttribute("categories", categoryService.getAllCategory());
            return "user_recipe_create";
        }
        return "redirect:signIn";
    }

    @PostMapping("/add")
    public String myRecipeAddPost(@AuthenticationPrincipal UserDetailsImpl details,
                                  RedirectAttributes redirectAttributes,
                                  @RequestParam("selectedCategory") List<Long> selected,
                                  @ModelAttribute("form") @Valid UserRecipeForm form,
                                  BindingResult result) {
        if (result.hasFieldErrors() || selected.size() == 0) {
            redirectAttributes.addFlashAttribute("errorFields", "Fill in all fields or check the correct of the data.");
            return "redirect:add";
        }
        form.setCategory(categoryService.getAllCategoryById(selected));
        recipeService.createRecipe(form, details.getUser());
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String myRecipeDelete(@AuthenticationPrincipal UserDetailsImpl details,
                                 Model model,
                                 @PathVariable("id") String id) {
        if (details != null) {
            UserEntity user = details.getUser();
            model.addAttribute("user", user);
            recipeService.deleteRecipe(Long.parseLong(id));
            return "redirect:/myRecipe";
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SIC#loginGet").build();
    }
}
