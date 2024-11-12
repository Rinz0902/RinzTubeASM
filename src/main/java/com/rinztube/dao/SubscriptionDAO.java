package com.rinztube.dao;


import java.util.List;

import com.rinztube.entity.Subscription;

import jakarta.persistence.EntityManager;

public class SubscriptionDAO {

    private EntityManager entityManager;

    public SubscriptionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Thêm một đăng ký mới
    public void addSubscription(Subscription subscription) {
        entityManager.getTransaction().begin();
        entityManager.persist(subscription);
        entityManager.getTransaction().commit();
    }

    // Lấy tất cả đăng ký của người dùng
    public List<Subscription> getSubscriptionsByUser(Long userId) {
        return entityManager.createQuery("SELECT s FROM Subscription s WHERE s.subscriber.userId = :userId", Subscription.class)
                            .setParameter("userId", userId)
                            .getResultList();
    }

    // Kiểm tra người dùng đã đăng ký kênh chưa
    public boolean isSubscribed(Long subscriberId, Long channelId) {
        List<Subscription> subscriptions = entityManager.createQuery("SELECT s FROM Subscription s WHERE s.subscriber.userId = :subscriberId AND s.channel.userId = :channelId", Subscription.class)
                                                        .setParameter("subscriberId", subscriberId)
                                                        .setParameter("channelId", channelId)
                                                        .getResultList();
        return !subscriptions.isEmpty();
    }

    // Xóa đăng ký
    public void deleteSubscription(Long subscriptionId) {
        Subscription subscription = entityManager.find(Subscription.class, subscriptionId);
        if (subscription != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(subscription);
            entityManager.getTransaction().commit();
        }
    }
}

