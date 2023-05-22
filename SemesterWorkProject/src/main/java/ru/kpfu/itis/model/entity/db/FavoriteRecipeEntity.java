package ru.kpfu.itis.model.entity.db;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "favorite_recipe_project")
@IdClass(FavoriteRecipePK.class)
public class FavoriteRecipeEntity {

    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userId;
}
