package ru.kpfu.itis.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientDto {

    private Long id;
    private String name;
}
