package ru.kpfu.itis.mapper.api;

import ru.kpfu.itis.model.entity.api.RecipeEntity;
import ru.kpfu.itis.model.response.RecipeResponse;

import java.util.ArrayList;
import java.util.List;

public class RecipeResponseMapper {

    public static RecipeEntity map(RecipeResponse resp) {
        List<RecipeEntity.Result> list = new ArrayList<>();
        if (resp != null) {
            List<RecipeResponse.Result> res = resp.getResult();
            if (res != null) {
                for (int i = 0; i < res.size(); i++) {
                    list.add(i, new RecipeEntity.Result(
                            res.get(i).getId().toString(),
                            res.get(i).getTitle(),
                            res.get(i).getImage(),
                            res.get(i).getImageType()
                    ));
                }
            }
            return new RecipeEntity(list);
        } else {
            return new RecipeEntity(null);
        }
    }
}
