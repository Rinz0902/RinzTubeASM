package com.rinztube.servie;


import java.util.List;

import com.rinztube.dao.SubscriptionDAO;
import com.rinztube.entity.Subscription;

import jakarta.persistence.EntityManager;

public class SubscriptionService {

    private SubscriptionDAO subscriptionDAO;

    public SubscriptionService(EntityManager entityManager) {
        this.subscriptionDAO = new SubscriptionDAO(entityManager);
    }

    // Thêm đăng ký mới
    public void addSubscription(Subscription subscription) {
        subscriptionDAO.addSubscription(subscription);
    }

    // Lấy tất cả đăng ký của người dùng
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return subscriptionDAO.getSubscriptionsByUser(userId);
    }

    // Kiểm tra người dùng đã đăng ký kênh chưa
    public boolean isSubscribed(Long subscriberId, Long channelId) {
        return subscriptionDAO.isSubscribed(subscriberId, channelId);
    }

    // Xóa đăng ký
    public void deleteSubscription(Long subscriptionId) {
        subscriptionDAO.deleteSubscription(subscriptionId);
    }
}
