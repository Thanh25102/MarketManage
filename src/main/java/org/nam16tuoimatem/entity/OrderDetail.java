package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Basic
    @Column(name = "OrderID", nullable = false)
    private Object orderId;
    @Basic
    @Column(name = "VegetableID", nullable = false)
    private Integer vegetableId;
    @Basic
    @Column(name = "Quantity", nullable = false)
    private Byte quantity;
    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
    private Order orderByOrderId;
}
