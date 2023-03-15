package org.nam16tuoimatem.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "OrderDetail", schema = "Market", catalog = "")
public class OrderDetailEntity {
    @Basic
    @Column(name = "OrderID")
    private Object orderId;
    @Basic
    @Column(name = "VegetableID")
    private int vegetableId;
    @Basic
    @Column(name = "Quantity")
    private byte quantity;
    @Basic
    @Column(name = "Price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
    private OrderEntity orderByOrderId;

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public byte getQuantity() {
        return quantity;
    }

    public void setQuantity(byte quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return vegetableId == that.vegetableId && quantity == that.quantity && Double.compare(that.price, price) == 0 && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, vegetableId, quantity, price);
    }

    public OrderEntity getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(OrderEntity orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
