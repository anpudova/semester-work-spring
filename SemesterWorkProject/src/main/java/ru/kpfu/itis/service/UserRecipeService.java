package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.converter.LocalDateConverter;
import ru.kpfu.itis.exception.EntityNotFoundException;
import ru.kpfu.itis.mapper.db.UserRecipeMapper;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.form.UserRecipeForm;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;
import ru.kpfu.itis.repository.db.datajpa.UserRecipeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserRecipeService {

    @Autowired
    private UserRecipeRepository recipeRepo;
    @Autowired
    private final LocalDateConverter converter;

    public UserRecipeService(LocalDateConverter converter) {
        this.converter = converter;
    }

    public List<UserRecipeDto> getAllRecipe() {
        return UserRecipeMapper.mapAll(recipeRepo.findAll(), converter);
    }

    public List<UserRecipeDto> getAllRecipeByUser(UserEntity user) {
        return UserRecipeMapper.mapAll(recipeRepo.findAllByUserId(user), converter);
    }

    public UserRecipeDto getRecipe(Long id) {
        return UserRecipeMapper.map(recipeRepo.findById(id).orElseThrow(EntityNotFoundException::new), converter);
    }

    public void createRecipe(UserRecipeForm form, UserEntity user) {
        recipeRepo.save(
                UserRecipeEntity.builder()
                        .title(form.getTitle())
                        .category(form.getCategory())
                        .ingredients(form.getIngredients())
                        .steps(form.getSteps())
                        .userId(user)
                        .date(LocalDate.now())
                        .build()
        );
    }

    public void deleteRecipe(Long id) {
        recipeRepo.deleteById(id);
    }

}
