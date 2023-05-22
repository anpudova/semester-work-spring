package ru.kpfu.itis.mapper.db;

import ru.kpfu.itis.model.dto.IngredientDto;
import ru.kpfu.itis.model.dto.StepDto;
import ru.kpfu.itis.model.entity.db.IngredientEntity;
import ru.kpfu.itis.model.entity.db.StepEntity;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {

    public static List<IngredientDto> map(List<IngredientEntity> listEntity) {
        List<IngredientDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (IngredientEntity entity : listEntity) {
                listDto.add(
                        IngredientDto.builder()
                                .id(entity.getId())
                                .name(entity.getIngredient())
                                .build()
                );
            }
        }
        return listDto;
    }
}
