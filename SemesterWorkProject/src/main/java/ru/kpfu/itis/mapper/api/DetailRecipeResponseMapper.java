package ru.kpfu.itis.mapper.api;

import ru.kpfu.itis.model.entity.api.DetailRecipeEntity;
import ru.kpfu.itis.model.response.DetailRecipeResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetailRecipeResponseMapper {

    public static DetailRecipeEntity map(DetailRecipeResponse resp) {
        List<DetailRecipeEntity.Step> listStep = new ArrayList<>();
        if (resp != null) {
            List<DetailRecipeResponse.Step> steps = resp.get(0).getSteps();
            if (steps != null) {
                for (int i = 0; i < steps.size(); i++) {
                    listStep.add(new DetailRecipeEntity.Step(
                            steps.get(i).getNumber(),
                            steps.get(i).getStep()
                    ));
                }
            }
            return new DetailRecipeEntity(resp.get(0).getName(), listStep);
        }
        return new DetailRecipeEntity("", Collections.emptyList());
    }
}
