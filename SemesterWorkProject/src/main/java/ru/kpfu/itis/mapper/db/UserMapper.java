package ru.kpfu.itis.mapper.db;

import ru.kpfu.itis.model.dto.UserAdminDto;
import ru.kpfu.itis.model.dto.UserDto;
import ru.kpfu.itis.model.dto.UserRecipeDto;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.model.entity.db.UserRecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto mapUser(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }

    public static UserAdminDto mapUserForAdmin(UserEntity entity) {
        return UserAdminDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .state(entity.getState())
                .build();
    }

    public static List<UserAdminDto> mapAllUserForAdmin(List<UserEntity> listEntity) {
        List<UserAdminDto> listDto = new ArrayList<>();
        if (!listEntity.isEmpty()) {
            for (UserEntity entity: listEntity) {
                listDto.add(
                        UserAdminDto.builder()
                                .id(entity.getId())
                                .username(entity.getUsername())
                                .state(entity.getState())
                                .build()
                );
            }
        }
        return listDto;
    }
}
