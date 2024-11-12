package com.rinztube.dao;

import java.util.List;

import com.rinztube.entity.Video;

import jakarta.persistence.EntityManager;

public class VideoDAO {

    private EntityManager entityManager;

    public VideoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Thêm một video mới
    public void addVideo(Video video) {
        entityManager.getTransaction().begin();
        entityManager.persist(video);
        entityManager.getTransaction().commit();
    }

    // Lấy tất cả video
    public List<Video> getAllVideos() {
        return entityManager.createQuery("SELECT v FROM Video v", Video.class).getResultList();
    }

    // Lấy video theo ID
    public Video getVideoById(Long videoId) {
        return entityManager.find(Video.class, videoId);
    }

    // Cập nhật video
    public void updateVideo(Video video) {
        entityManager.getTransaction().begin();
        entityManager.merge(video);
        entityManager.getTransaction().commit();
    }

    // Xóa video
    public void deleteVideo(Long videoId) {
        Video video = entityManager.find(Video.class, videoId);
        if (video != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(video);
            entityManager.getTransaction().commit();
        }
    }
}
