package com.example.springbootapp.service;

import com.example.springbootapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    private EntityManager em;

    @PersistenceContext(name = "EntityPersistenceUnit")
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void deleteUser(long id) {
        em.remove(em.find(User.class, id));
    }

    @Transactional
    public void editUser(User user, long id) {
        User user1 = this.getUser(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createQuery("select user from User user").getResultList();
    }
}