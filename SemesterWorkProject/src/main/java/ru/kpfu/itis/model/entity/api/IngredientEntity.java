package ru.kpfu.itis.model.entity.api;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientEntity {

    private List<Result> ingredients;

    @Data
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private String unit;
        private Float value;
        private String name;

    }
}

