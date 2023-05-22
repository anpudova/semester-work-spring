package ru.kpfu.itis.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.model.dto.CategoryDto;
import ru.kpfu.itis.model.dto.IngredientDto;
import ru.kpfu.itis.model.dto.StepDto;
import ru.kpfu.itis.model.entity.db.CategoryEntity;
import ru.kpfu.itis.model.entity.db.IngredientEntity;
import ru.kpfu.itis.model.entity.db.StepEntity;
import ru.kpfu.itis.model.entity.db.UserEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRecipeForm {

    @NotBlank
    private String title;
    private List<CategoryEntity> category;
    @NotEmpty
    private List<IngredientEntity> ingredients;
    @NotEmpty
    private List<StepEntity> steps;
}
