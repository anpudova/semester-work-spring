package ru.kpfu.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.exception.NetworkErrorException;
import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.entity.api.InformationEntity;
import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.repository.api.RecipeRepository;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepo;

    public RecipeService() {
        this.recipeRepo = new RecipeRepository();
    }

    public RecipeEntity getRecipesByName(String recipe) throws NetworkErrorException{
        return recipeRepo.getRecipesByName(recipe);
    }

    public IngredientEntity getIngredientsById(long id) throws NetworkErrorException{
        return recipeRepo.getIngredientsById(id);
    }

    public DetailRecipeEntity getDetailRecipeById(long id) throws NetworkErrorException{
        return recipeRepo.getDetailRecipeById(id);
    }

    public InformationEntity getInformationById(long id) throws NetworkErrorException{
        return recipeRepo.getInformationById(id);
    }
}
