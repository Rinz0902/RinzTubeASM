package com.rinztube.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rinztube.entity.User;
import com.rinztube.servie.UserService;

public class UserController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Khởi tạo UserService với EntityManager (bạn có thể cấu hình EntityManager trong filter hoặc Listener)
        this.userService = new UserService(EntityManagerFactorySingleton.getEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // Mặc định hiển thị danh sách người dùng
        }

        switch (action) {
            case "list":
                showUserList(request, response);
                break;
            case "profile":
                showUserProfile(request, response);
                break;
            default:
                break;
        }
    }

    // Hiển thị danh sách người dùng
    private void showUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/list.jsp");
        dispatcher.forward(request, response);
    }

    // Hiển thị thông tin người dùng
    private void showUserProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userService.getUserById(userId);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/profile.jsp");
        dispatcher.forward(request, response);
    }
}
