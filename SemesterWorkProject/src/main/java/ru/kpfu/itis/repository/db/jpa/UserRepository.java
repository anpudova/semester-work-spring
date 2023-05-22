package ru.kpfu.itis.repository.db.jpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.entity.db.RoleEntity;
import ru.kpfu.itis.model.entity.db.State;
import ru.kpfu.itis.model.entity.db.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void saveUser(UserEntity user) {
        em.persist(user);
    }

    public List<UserEntity> findAll() {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }

    public boolean existUser(String username) {
        Query result = em.createQuery("select u from UserEntity u where u.username = :username", UserEntity.class);
        result.setParameter("username", username);
        return !result.getResultList().isEmpty();
    }

    public RoleEntity findByRole(String authority) {
        Query result = em.createQuery("SELECT r FROM RoleEntity r where r.authority = :authority", RoleEntity.class).setMaxResults(1);
        result.setParameter("authority", authority);
        return (RoleEntity) result.getSingleResult();
    }

    public UserEntity findByUsername(String username) {
        Query result = em.createQuery("SELECT u FROM UserEntity u where u.username = :username", UserEntity.class);
        result.setParameter("username", username);
        if (result.getResultList().isEmpty()) {
            return null;
        }
        return (UserEntity) result.getSingleResult();
    }

    public UserEntity findById(Long id) {
        Query result = em.createQuery("SELECT u FROM UserEntity u where u.id = :id", UserEntity.class);
        result.setParameter("id", id);
        if (result.getResultList().isEmpty()) {
            return null;
        }
        return (UserEntity) result.getSingleResult();
    }

    public UserEntity findUser(String username, String password) {
        Query result = em.createQuery("SELECT u FROM UserEntity u where u.username = :username and u.password = :password", UserEntity.class);
        result.setParameter("username", username);
        result.setParameter("password", password);
        if (result.getResultList().isEmpty()) {
            return null;
        }
        return (UserEntity) result.getSingleResult();
    }

    public void updateUser(String newUsername, String oldUsername) {
        em.createQuery("update UserEntity u set u.username = :new_username where u.username = :old_username")
                .setParameter("new_username", newUsername)
                .setParameter("old_username", oldUsername)
                .executeUpdate();
    }

    public void deleteUser(UserEntity user) {
        em.remove(user);
    }

    public void bannerUser(Long id, State state) {
        em.createQuery("update UserEntity u set u.state = :state where u.id = :id")
                .setParameter("state", state)
                .setParameter("id", id)
                .executeUpdate();
    }

}
