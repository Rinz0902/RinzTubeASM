package com.rinztube.servie;


import java.util.List;

import com.rinztube.dao.UserDAO;
import com.rinztube.entity.User;

import jakarta.persistence.EntityManager;

public class UserService {

    private UserDAO userDAO;

    public UserService(EntityManager entityManager) {
        this.userDAO = new UserDAO(entityManager);
    }

    // Thêm người dùng mới
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Lấy thông tin người dùng theo ID
    public User getUserById(Long userId) {
        return userDAO.getUserById(userId);
    }

    // Cập nhật người dùng
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    // Xóa người dùng
    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }
}
