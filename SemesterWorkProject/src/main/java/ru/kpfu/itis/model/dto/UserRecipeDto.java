package ru.kpfu.itis.model.dto;

import lombok.*;
import ru.kpfu.itis.model.entity.db.CategoryEntity;
import ru.kpfu.itis.model.entity.db.IngredientEntity;
import ru.kpfu.itis.model.entity.db.StepEntity;
import ru.kpfu.itis.model.entity.db.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRecipeDto {

    private String id;
    private String title;
    private List<CategoryDto> category;
    private List<IngredientDto> ingredients;
    private List<StepDto> steps;
    private UserDto userId;
    private String date;
}
