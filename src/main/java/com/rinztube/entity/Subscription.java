package com.rinztube.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private User subscriber;  // Người đăng ký

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private User channel;  // Kênh mà người dùng đăng ký

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "subscribed_at", nullable = false, updatable = false)
    private Date subscribedAt;

    // Constructors, Getters, Setters
    public Subscription() {}

    public Subscription(User subscriber, User channel) {
        this.subscriber = subscriber;
        this.channel = channel;
        this.subscribedAt = new Date();
    }

    // Getters and Setters
    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public User getChannel() {
        return channel;
    }

    public void setChannel(User channel) {
        this.channel = channel;
    }

    public Date getSubscribedAt() {
        return subscribedAt;
    }

    public void setSubscribedAt(Date subscribedAt) {
        this.subscribedAt = subscribedAt;
    }
}
