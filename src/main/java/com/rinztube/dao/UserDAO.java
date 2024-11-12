package com.rinztube.dao;

import java.util.List;

import com.rinztube.entity.User;

import jakarta.persistence.EntityManager;

public class UserDAO {

    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Thêm một người dùng mới
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    // Lấy người dùng theo id
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    // Cập nhật thông tin người dùng
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    // Xóa người dùng
    public void deleteUser(Long userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }
    }
}
