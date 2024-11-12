package com.rinztube.servie;


import java.util.List;

import com.rinztube.dao.CommentDAO;
import com.rinztube.entity.Comment;

import jakarta.persistence.EntityManager;

public class CommentService {

    private CommentDAO commentDAO;

    public CommentService(EntityManager entityManager) {
        this.commentDAO = new CommentDAO(entityManager);
    }

    // Thêm bình luận mới
    public void addComment(Comment comment) {
        commentDAO.addComment(comment);
    }

    // Lấy tất cả bình luận của video
    public List<Comment> getCommentsByVideo(Long videoId) {
        return commentDAO.getCommentsByVideo(videoId);
    }

    // Xóa bình luận
    public void deleteComment(Long commentId) {
        commentDAO.deleteComment(commentId);
    }
}
