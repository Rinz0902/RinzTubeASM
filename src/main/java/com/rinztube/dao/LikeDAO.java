package com.rinztube.dao;


import java.util.List;

import com.rinztube.entity.Like;

import jakarta.persistence.EntityManager;

public class LikeDAO {

    private EntityManager entityManager;

    public LikeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Thêm một lượt thích mới
    public void addLike(Like like) {
        entityManager.getTransaction().begin();
        entityManager.persist(like);
        entityManager.getTransaction().commit();
    }

    // Lấy tất cả lượt thích của video
    public List<Like> getLikesByVideo(Long videoId) {
        return entityManager.createQuery("SELECT l FROM Like l WHERE l.video.videoId = :videoId", Like.class)
                            .setParameter("videoId", videoId)
                            .getResultList();
    }

    // Kiểm tra lượt thích của người dùng đối với video
    public boolean hasUserLiked(Long videoId, Long userId) {
        List<Like> likes = entityManager.createQuery("SELECT l FROM Like l WHERE l.video.videoId = :videoId AND l.user.userId = :userId", Like.class)
                                        .setParameter("videoId", videoId)
                                        .setParameter("userId", userId)
                                        .getResultList();
        return !likes.isEmpty();
    }

    // Xóa lượt thích
    public void deleteLike(Long likeId) {
        Like like = entityManager.find(Like.class, likeId);
        if (like != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(like);
            entityManager.getTransaction().commit();
        }
    }
}

