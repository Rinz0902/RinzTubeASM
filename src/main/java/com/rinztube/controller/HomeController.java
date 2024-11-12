package com.rinztube.controller;

import com.rinztube.entity.Video;
import com.rinztube.servie.VideoService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet {
    private VideoService videoService;

    @Override
    public void init() throws ServletException {
        videoService = new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách video từ service
        List<Video> videos = videoService.getAllVideos();
        request.setAttribute("videos", videos);
        
        // Forward đến trang Home.jsp
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }
}
