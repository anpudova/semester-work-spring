package ru.kpfu.itis.model.entity.db;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name = "users_project")
public class UserEntity implements CredentialsContainer, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username")
    @NotNull(message = "Fill in the field.")
    @Pattern(regexp = "^[A-ZА-Я]([A-ZА-Яa-zа-я]{1,20})$",
            message = "Username entered incorrectly: eng. rus. letters, length=[2-20].")
    private String username;

    @Column(name = "password")
    @NotNull(message = "Fill in the field.")
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$",
            message = "Password entered incorrectly: min.length=8, use large, small letters and numbers.")
    private String password;

    @ManyToOne
    @JoinColumn(
            name = "role",
            referencedColumnName = "role"
    )
    private RoleEntity role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    @Override
    public void eraseCredentials() {
    }
}
