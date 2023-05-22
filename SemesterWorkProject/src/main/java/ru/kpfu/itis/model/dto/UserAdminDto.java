package ru.kpfu.itis.model.dto;

import lombok.*;
import ru.kpfu.itis.model.entity.db.FavoriteRecipeEntity;
import ru.kpfu.itis.model.entity.db.RoleEntity;
import ru.kpfu.itis.model.entity.db.State;
import ru.kpfu.itis.model.entity.db.UserEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAdminDto {

    private Long id;
    private String username;
    private State state;

}
