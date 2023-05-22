package ru.kpfu.itis.mapper.db;

import ru.kpfu.itis.model.dto.CategoryDto;
import ru.kpfu.itis.model.dto.StepDto;
import ru.kpfu.itis.model.entity.db.CategoryEntity;
import ru.kpfu.itis.model.entity.db.StepEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static List<CategoryDto> map(List<CategoryEntity> listEntity) {
        List<CategoryDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (CategoryEntity entity: listEntity) {
                listDto.add(
                        CategoryDto.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .build()
                );
            }
        }
        return listDto;
    }
}
