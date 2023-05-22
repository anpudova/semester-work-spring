package ru.kpfu.itis.model.entity.api;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {

    private List<Result> recipes;

    @Data
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private String id;
        private String title;
        private String image;
        private String imageType;


    }
}
