package ru.kpfu.itis.mapper.db;

import ru.kpfu.itis.model.dto.StepDto;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.entity.db.StepEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class StepMapper {

    public static List<StepDto> map(List<StepEntity> listEntity) {
        List<StepDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (StepEntity entity: listEntity) {
                listDto.add(
                        StepDto.builder()
                                .id(entity.getId())
                                .name(entity.getStep())
                                .build()
                );
            }
        }
        return listDto;
    }
}
