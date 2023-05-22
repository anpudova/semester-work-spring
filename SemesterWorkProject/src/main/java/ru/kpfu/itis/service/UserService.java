package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.mapper.db.UserMapper;
import ru.kpfu.itis.model.dto.UserAdminDto;
import ru.kpfu.itis.model.form.SignUpForm;
import ru.kpfu.itis.exception.DuplicateUsernameException;
import ru.kpfu.itis.model.entity.db.State;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.repository.db.jpa.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserAdminDto registerUser(SignUpForm form) {
        if (userRepo.existUser(form.getUsername())) {
            throw new DuplicateUsernameException();
        }
        UserEntity user = UserEntity.builder()
                .username(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(userRepo.findByRole("ROLE_USER"))
                .state(State.ACTIVE)
                .build();
        userRepo.saveUser(user);
        return UserMapper.mapUserForAdmin(user);
    }

    public void updateUsername(String newUsername, String oldUsername) {
        if (!userRepo.existUser(newUsername) && !newUsername.equals(oldUsername)) {
            userRepo.updateUser(newUsername, oldUsername);
        } else if (userRepo.existUser(newUsername) && !newUsername.equals(oldUsername)) {
            throw new DuplicateUsernameException();
        }

    }

    public List<UserAdminDto> getUsers() {
        return UserMapper.mapAllUserForAdmin(userRepo.findAll());
    }

    public void banUser(Long id) {
        userRepo.bannerUser(id, State.BANNED);
    }

    public void unbanUser(Long id) {
        userRepo.bannerUser(id, State.ACTIVE);
    }

    public void deleteUser(String username) {
        userRepo.deleteUser(userRepo.findByUsername(username));
    }
}
