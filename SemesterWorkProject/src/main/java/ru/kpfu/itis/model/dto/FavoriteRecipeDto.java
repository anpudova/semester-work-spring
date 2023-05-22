package ru.kpfu.itis.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteRecipeDto {

    private String id;
    private String title;
    private String image;
}
