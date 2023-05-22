package ru.kpfu.itis.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.kpfu.itis.model.response.DetailRecipeResponse;
import ru.kpfu.itis.model.response.InformationResponse;
import ru.kpfu.itis.model.response.IngredientResponse;
import ru.kpfu.itis.model.response.RecipeResponse;

public interface RecipeApiService {

    @GET("/recipes/complexSearch")
    Call<RecipeResponse> getRecipeByName(
        @Query("query") String recipe
    );

    @GET("/recipes/{id}/ingredientWidget.json")
    Call<IngredientResponse> getIngredientsById(
        @Path("id") long id
    );

    @GET("/recipes/{id}/analyzedInstructions?stepBreakdown=true")
    Call<DetailRecipeResponse> getDetailRecipeById(
        @Path("id") long id
    );

    @GET("recipes/{id}/information")
    Call<InformationResponse> getInformationById(
        @Path("id") long id
    );
}
