package ru.kpfu.itis.mapper.db;

import ru.kpfu.itis.model.dto.FavoriteRecipeDto;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipeMapper {

    public static FavoriteRecipeDto map(FavoriteRecipeEntity entity) {
        return FavoriteRecipeDto.builder()
                .id(entity.getId().toString())
                .title(entity.getTitle())
                .image(entity.getImage())
                .build();
    }

    public static List<FavoriteRecipeDto> mapAll(List<FavoriteRecipeEntity> listEntity) {
        List<FavoriteRecipeDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (FavoriteRecipeEntity entity: listEntity) {
                listDto.add(
                        FavoriteRecipeDto.builder()
                                .id(entity.getId().toString())
                                .title(entity.getTitle())
                                .image(entity.getImage())
                                .build()
                );
            }
        }
        return listDto;
    }
}
