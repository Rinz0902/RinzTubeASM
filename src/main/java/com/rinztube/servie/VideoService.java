package com.rinztube.servie;


import java.util.List;

import com.rinztube.dao.VideoDAO;
import com.rinztube.entity.Video;

import jakarta.persistence.EntityManager;

public class VideoService {

    private VideoDAO videoDAO;

    public VideoService(EntityManager entityManager) {
        this.videoDAO = new VideoDAO(entityManager);
    }

    // Thêm video mới
    public void addVideo(Video video) {
        videoDAO.addVideo(video);
    }

    // Lấy tất cả video
    public List<Video> getAllVideos() {
        return videoDAO.getAllVideos();
    }

    // Lấy video theo ID
    public Video getVideoById(Long videoId) {
        return videoDAO.getVideoById(videoId);
    }

    // Cập nhật video
    public void updateVideo(Video video) {
        videoDAO.updateVideo(video);
    }

    // Xóa video
    public void deleteVideo(Long videoId) {
        videoDAO.deleteVideo(videoId);
    }
}
