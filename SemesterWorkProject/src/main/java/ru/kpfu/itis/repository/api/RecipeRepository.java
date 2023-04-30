package ru.kpfu.itis.repository.api;

import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.model.response.DetailRecipeResponse;
import ru.kpfu.itis.model.response.IngredientResponse;
import ru.kpfu.itis.model.response.RecipeResponse;
import ru.kpfu.itis.network.RecipeApiService;

import java.io.IOException;

public class RecipeRepository{

    private final RecipeApiService remoteSource;
    private final Object localSource;
    private final RecipeResponseMapper recipeResponseMapper;
    private final IngredientResponseMapper ingredientResponseMapper;
    private final DetailRecipeResponseMapper detailRecipeResponseMapper;

    public RecipeRepository(
            RecipeApiService remoteSource,
            Object localSource,
            RecipeResponseMapper recipeResponseMapper,
            IngredientResponseMapper ingredientResponseMapper,
            DetailRecipeResponseMapper detailRecipeResponseMapper) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
        this.recipeResponseMapper = recipeResponseMapper;
        this.ingredientResponseMapper = ingredientResponseMapper;
        this.detailRecipeResponseMapper = detailRecipeResponseMapper;
    }

    public RecipeEntity getRecipesByName(String recipe) throws IOException {
        try {
            RecipeResponse response = remoteSource.getRecipeByName(recipe).execute().body();
            return recipeResponseMapper.map(response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public IngredientEntity getIngredientsById(long id) throws IOException {
        try {
            IngredientResponse response = remoteSource.getIngredientsById(id).execute().body();
            return ingredientResponseMapper.map(response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public DetailRecipeEntity getDetailRecipeById(long id) throws IOException {
        try {
            DetailRecipeResponse response = remoteSource.getDetailRecipeById(id).execute().body();
            return detailRecipeResponseMapper.map(response);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
