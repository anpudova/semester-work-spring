package ru.kpfu.itis.model.entity.db;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class FavoriteRecipePK implements Serializable {

    private Long id;
    private Long userId;
}
