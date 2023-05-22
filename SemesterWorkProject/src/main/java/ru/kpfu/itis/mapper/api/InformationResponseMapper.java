package ru.kpfu.itis.mapper.api;

import ru.kpfu.itis.model.entity.api.InformationEntity;
import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.model.response.InformationResponse;
import ru.kpfu.itis.model.response.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

public class InformationResponseMapper {

    public static InformationEntity map(InformationResponse resp) {
        if (resp != null) {
            return new InformationEntity(
                    resp.getId(),
                    resp.getTitle(),
                    resp.getImage(),
                    resp.getSummary()
            );
        } else {
            return new InformationEntity();
        }
    }
}
