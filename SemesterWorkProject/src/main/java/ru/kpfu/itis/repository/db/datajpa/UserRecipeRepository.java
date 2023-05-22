package ru.kpfu.itis.repository.db.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

import java.util.List;


public interface UserRecipeRepository extends JpaRepository<UserRecipeEntity, Long> {

    List<UserRecipeEntity> findAllByUserId(UserEntity userId);

}

