package ru.kpfu.itis.mapper.db;

import org.springframework.core.convert.TypeDescriptor;
import ru.kpfu.itis.converter.LocalDateConverter;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRecipeMapper {

    public static UserRecipeDto map(UserRecipeEntity entity, LocalDateConverter converter) {
        return UserRecipeDto.builder()
                .id(entity.getId().toString())
                .title(entity.getTitle())
                .category(CategoryMapper.map(entity.getCategory()))
                .ingredients(IngredientMapper.map(entity.getIngredients()))
                .steps(StepMapper.map(entity.getSteps()))
                .userId(UserMapper.mapUser(entity.getUserId()))
                .date((String) converter.convert(entity.getDate(), TypeDescriptor.valueOf(LocalDate.class), TypeDescriptor.valueOf(String.class)))
                .build();
    }

    public static List<UserRecipeDto> mapAll(List<UserRecipeEntity> listEntity, LocalDateConverter converter) {
        List<UserRecipeDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (UserRecipeEntity entity: listEntity) {
                listDto.add(
                        UserRecipeDto.builder()
                                .id(entity.getId().toString())
                                .title(entity.getTitle())
                                .category(CategoryMapper.map(entity.getCategory()))
                                .ingredients(IngredientMapper.map(entity.getIngredients()))
                                .steps(StepMapper.map(entity.getSteps()))
                                .userId(UserMapper.mapUser(entity.getUserId()))
                                .date((String) converter.convert(entity.getDate(), TypeDescriptor.valueOf(LocalDate.class), TypeDescriptor.valueOf(String.class)))
                                .build()
                );
            }
        }
        return listDto;
    }
}
