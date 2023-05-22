package ru.kpfu.itis.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.kpfu.itis.model.dto.FavoriteRecipeDto;

@RequiredArgsConstructor
@Getter
@Setter
public class ToggleFavoriteRequest {

    private FavoriteRecipeDto recipe;
    private String id;
    private Boolean isFavorite;

}
