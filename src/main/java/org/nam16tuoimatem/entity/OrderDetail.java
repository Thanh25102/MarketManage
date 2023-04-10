package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail {
    @Basic
    @Column(name = "OrderID", nullable = false)
    @Id
    private Integer orderId;
    @Basic
    @Column(name = "VegetableID", nullable = false)
    @Id
    private Integer vegetableId;
    @Basic
    @Column(name = "Quantity", nullable = false)
    private Byte quantity;
    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "VegetableID", referencedColumnName = "VegetableID", nullable = false)
    private Vegetable vegetableByVegetableId;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
    private Order orderDetailsByOrderId;
}
