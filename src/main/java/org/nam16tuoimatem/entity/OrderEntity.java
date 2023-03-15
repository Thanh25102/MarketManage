package org.nam16tuoimatem.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Order", schema = "Market", catalog = "")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID")
    private Object orderId;
    @Basic
    @Column(name = "CustomerID")
    private int customerId;
    @Basic
    @Column(name = "Date")
    private Date date;
    @Basic
    @Column(name = "Total")
    private double total;
    @Basic
    @Column(name = "Note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    private CustomersEntity customersByCustomerId;

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return customerId == that.customerId && Double.compare(that.total, total) == 0 && Objects.equals(orderId, that.orderId) && Objects.equals(date, that.date) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, date, total, note);
    }

    public CustomersEntity getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(CustomersEntity customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }
}
