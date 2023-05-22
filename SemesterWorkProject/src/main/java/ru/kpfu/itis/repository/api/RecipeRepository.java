package ru.kpfu.itis.repository.api;

import ru.kpfu.itis.exception.EntityNotFoundException;
import ru.kpfu.itis.exception.NetworkErrorException;
import ru.kpfu.itis.mapper.api.DetailRecipeResponseMapper;
import ru.kpfu.itis.mapper.api.InformationResponseMapper;
import ru.kpfu.itis.mapper.api.IngredientResponseMapper;
import ru.kpfu.itis.mapper.api.RecipeResponseMapper;
import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.entity.api.InformationEntity;
import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.model.response.DetailRecipeResponse;
import ru.kpfu.itis.model.response.InformationResponse;
import ru.kpfu.itis.model.response.IngredientResponse;
import ru.kpfu.itis.model.response.RecipeResponse;
import ru.kpfu.itis.network.RecipeApiService;
import ru.kpfu.itis.network.RecipeApiServiceManager;

import java.io.IOException;

public class RecipeRepository{

    private final RecipeApiService source;

    public RecipeRepository() {
        this.source = RecipeApiServiceManager.getInstance();
    }

    public RecipeEntity getRecipesByName(String recipe) {
        RecipeResponse response;
        try {
            response = source.getRecipeByName(recipe).execute().body();
        } catch (IOException e) {
            throw new NetworkErrorException();
        }
        if (response == null) {
            throw new EntityNotFoundException("Couldn't find the recipe.");
        }
        return RecipeResponseMapper.map(response);
    }

    public IngredientEntity getIngredientsById(long id){
        IngredientResponse response;
        try {
            response = source.getIngredientsById(id).execute().body();
        } catch (IOException e) {
            throw new NetworkErrorException();
        }
        if (response == null) {
            throw new EntityNotFoundException("Couldn't find the recipe.");
        }
        return IngredientResponseMapper.map(response);
    }

    public DetailRecipeEntity getDetailRecipeById(long id){
        DetailRecipeResponse response;
        try {
            response = source.getDetailRecipeById(id).execute().body();
        } catch (IOException e) {
            throw new NetworkErrorException();
        }
        if (response == null) {
            throw new EntityNotFoundException("Couldn't find the recipe.");
        }
        return DetailRecipeResponseMapper.map(response);
    }

    public InformationEntity getInformationById(long id){
        InformationResponse response;
        try {
            response = source.getInformationById(id).execute().body();
        } catch (IOException e) {
            throw new NetworkErrorException();
        }
        if (response == null) {
            throw new EntityNotFoundException("Couldn't find the recipe.");
        }
        return InformationResponseMapper.map(response);
    }
}