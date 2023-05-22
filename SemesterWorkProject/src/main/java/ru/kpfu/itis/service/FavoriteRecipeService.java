package ru.kpfu.itis.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.mapper.db.FavoriteRecipeMapper;
import ru.kpfu.itis.model.dto.FavoriteRecipeDto;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.repository.db.datajpa.FavoriteRecipeRepository;
import ru.kpfu.itis.repository.db.jpa.UserRepository;

import java.util.List;

@Service
public class FavoriteRecipeService {

    @Autowired
    private FavoriteRecipeRepository recipeRepo;

    @Autowired
    private UserRepository userRepo;

    public List<FavoriteRecipeDto> getAllRecipeByUser(Long id) {
        return FavoriteRecipeMapper.mapAll(recipeRepo.findByUserIdId(id));
    }

    public void addRecipe(@NotNull FavoriteRecipeDto recipe, Long userId) {
        recipeRepo.save(
                FavoriteRecipeEntity.builder()
                        .id(Long.parseLong(recipe.getId()))
                        .title(recipe.getTitle())
                        .image(recipe.getImage())
                        .userId(userRepo.findById(userId))
                        .build()
        );
    }

    public List<FavoriteRecipeDto> getAllFavoriteRecipeTop() {
        return FavoriteRecipeMapper.mapAll(recipeRepo.findTopFavoriteRecipes());
    }

    public void deleteRecipe(Long recipeId, Long userId) {
        recipeRepo.deleteRecipe(recipeId, userId);
    }

    public boolean existRecipe(Long recipeId, Long userId) {
        return recipeRepo.getRecipe(recipeId, userId) != null;
    }
}
