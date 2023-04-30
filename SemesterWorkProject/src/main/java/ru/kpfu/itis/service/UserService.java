package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.entity.db.UserEntity;
import ru.kpfu.itis.repository.db.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserEntity user) {
        if (userRepo.existUser(user.getUsername())) {
            return "User with this username already exist.";
        }
        user.setRole(userRepo.findByRole("ROLE_USER"));
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.saveUser(user);
        return "Success";
    }

    public String loginUser(UserEntity user) {
        if (userRepo.findUser(user.getUsername(), user.getPassword()) != null) {
            return "Success";
        }
        return "Data entered incorrectly.";
    }

    public void deleteUser(UserEntity user) {
        userRepo.deleteUser(user);
    }

    public void logoutUser(UserEntity user) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRole());
        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(authority)
        );
    }
}
