package ru.kpfu.itis.repository.db.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.entity.db.CategoryEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {}
