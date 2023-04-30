package ru.kpfu.itis.repository.db;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.entity.db.RoleEntity;
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

    public List<UserEntity> findAll(int offset, int limit) {
        return em.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .setFirstResult(offset * limit)
                .setMaxResults(limit)
                .getResultList();
    }

    public boolean existUser(String username) {
        Query result = em.createQuery("select u from UserEntity u where u.username = :username", UserEntity.class);
        result.setParameter("username", username);
        return !result.getResultList().isEmpty();
    }

    public RoleEntity findByRole(String role) {
        Query result = em.createQuery("SELECT r FROM RoleEntity r where r.role = :role", RoleEntity.class).setMaxResults(1);
        result.setParameter("role", role);
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

    public UserEntity findUser(String username, String password) {
        Query result = em.createQuery("SELECT u FROM UserEntity u where u.username = :username and u.password = :password", UserEntity.class);
        result.setParameter("username", username);
        result.setParameter("password", password);
        if (result.getResultList().isEmpty()) {
            return null;
        }
        return (UserEntity) result.getSingleResult();
    }

    public void deleteUser(UserEntity user) {
        em.remove(user);
    }
}
