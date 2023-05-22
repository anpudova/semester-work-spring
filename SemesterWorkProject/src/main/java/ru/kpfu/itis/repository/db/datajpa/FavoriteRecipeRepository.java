package ru.kpfu.itis.repository.db.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;

import java.util.List;

@Transactional
public interface FavoriteRecipeRepository extends JpaRepository<FavoriteRecipeEntity, Long> {

    List<FavoriteRecipeEntity> findByUserIdId(Long userId);

    @Query("select f from FavoriteRecipeEntity f " +
            "where f.id = :id and " +
            "f.userId = (select u from UserEntity u where u.id = :userId)")
    FavoriteRecipeEntity getRecipe(@Param("id") Long id, @Param("userId") Long userId);

    @Modifying
    @Query("delete from FavoriteRecipeEntity f " +
            "where f.id = :id and " +
            "f.userId = (select u from UserEntity u where u.id = :userId)")
    void deleteRecipe(@Param("id") Long id, @Param("userId") Long userId);

    @Query(nativeQuery = true, value = "WITH cte_user_recipes AS (SELECT f.id as cte_id, MAX(image) AS image, " +
            "MAX(title) AS title, COUNT(f.user_id) as count " +
            "FROM favorite_recipe_project f INNER JOIN users_project u ON f.user_id = u.id " +
            "WHERE u.state <> 'BANNED' GROUP BY cte_id ORDER BY count DESC LIMIT 15) " +
            "SELECT DISTINCT ON (cte.count, f.id, f.image, f.title) f.* " +
            "FROM favorite_recipe_project f " +
            "INNER JOIN cte_user_recipes cte ON f.id = cte.cte_id " +
            "ORDER BY cte.count DESC;")
    List<FavoriteRecipeEntity> findTopFavoriteRecipes();

}

