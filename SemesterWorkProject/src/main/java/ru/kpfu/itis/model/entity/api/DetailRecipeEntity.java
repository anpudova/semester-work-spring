package ru.kpfu.itis.model.entity.api;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailRecipeEntity {

    private String name;
    private List<Step> steps;

    @Data
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Step {

        private Integer number;
        private String step;

    }
}
