package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

//@Transactional
@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        System.out.println("adding user: " + user);
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
//        TypedQuery<User> query = entityManager.createQuery(
//                "SELECT user FROM User user WHERE user.id = :id", User.class);
//        query.setParameter("id", id);
//        System.out.println("getById; " + query.getResultList().get(0));
//        return query.getResultList().get(0);
    }


    @Override
    public List<User> selectAllUsersFromDatabase() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void updateUser(User userUpdated, Long id) {
        User user = getById(id);
        user.setUserName(userUpdated.getUserName());
        user.setUserAge(userUpdated.getUserAge());
        user.setUserStatus(userUpdated.getUserStatus());
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}