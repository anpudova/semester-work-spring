package ru.kpfu.itis.model.entity.db;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users_project")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(
            name = "role",
            referencedColumnName = "role"
    )
    private RoleEntity role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

}
