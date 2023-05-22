package ru.kpfu.itis.mapper.api;

import ru.kpfu.itis.model.entity.api.IngredientEntity;
import ru.kpfu.itis.model.response.IngredientResponse;

import java.util.ArrayList;
import java.util.List;

public class IngredientResponseMapper {

    public static IngredientEntity map(IngredientResponse resp) {
        List<IngredientEntity.Result> list = new ArrayList<>();
        if (resp != null) {
            List<IngredientResponse.Result> res = resp.getResults();
            if (res != null) {
                for (int i = 0; i < res.size(); i++) {
                    list.add(i, new IngredientEntity.Result(
                            res.get(i).getAmount().getMetric().getUnit(),
                            res.get(i).getAmount().getMetric().getValue(),
                            res.get(i).getName()
                    ));
                }
            }
            return new IngredientEntity(list);
        } else {
            return new IngredientEntity(null);
        }
    }
}
