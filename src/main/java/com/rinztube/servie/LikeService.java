package com.rinztube.servie;

import java.util.List;

import com.rinztube.dao.LikeDAO;
import com.rinztube.entity.Like;

import jakarta.persistence.EntityManager;

public class LikeService {

    private LikeDAO likeDAO;

    public LikeService(EntityManager entityManager) {
        this.likeDAO = new LikeDAO(entityManager);
    }

    // Thêm lượt thích mới
    public void addLike(Like like) {
        likeDAO.addLike(like);
    }

    // Lấy tất cả lượt thích của video
    public List<Like> getLikesByVideo(Long videoId) {
        return likeDAO.getLikesByVideo(videoId);
    }

    // Kiểm tra người dùng đã thích video chưa
    public boolean hasUserLiked(Long videoId, Long userId) {
        return likeDAO.hasUserLiked(videoId, userId);
    }

    // Xóa lượt thích
    public void deleteLike(Long likeId) {
        likeDAO.deleteLike(likeId);
    }
}
