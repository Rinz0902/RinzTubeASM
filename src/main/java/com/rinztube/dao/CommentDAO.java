package com.rinztube.dao;


import java.util.List;

import com.rinztube.entity.Comment;

import jakarta.persistence.EntityManager;

public class CommentDAO {

    private EntityManager entityManager;

    public CommentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Thêm một bình luận mới
    public void addComment(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.getTransaction().commit();
    }

    // Lấy tất cả bình luận của video
    public List<Comment> getCommentsByVideo(Long videoId) {
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.video.videoId = :videoId", Comment.class)
                            .setParameter("videoId", videoId)
                            .getResultList();
    }

    // Lấy bình luận theo ID
    public Comment getCommentById(Long commentId) {
        return entityManager.find(Comment.class, commentId);
    }

    // Xóa bình luận
    public void deleteComment(Long commentId) {
        Comment comment = entityManager.find(Comment.class, commentId);
        if (comment != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(comment);
            entityManager.getTransaction().commit();
        }
    }
}
