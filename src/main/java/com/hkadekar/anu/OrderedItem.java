package com.hkadekar.anu;

import java.util.Date;
import java.util.UUID;

public class OrderedItem extends Item {
    private UUID orderId;
    private int quantity;
    private OrderStatus orderStatus;
    private Date orderTime;


    public OrderedItem(UUID orderId, int quantity, OrderStatus orderStatus, Date orderTime, UUID itemId, String name, Double price, String group, Boolean isAvailable){
        super(itemId, name, price, group, isAvailable);
        this.orderId = orderId;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;

    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
