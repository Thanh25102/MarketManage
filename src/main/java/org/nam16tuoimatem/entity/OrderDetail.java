package org.nam16tuoimatem.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Column(name = "OrderID", nullable = false)
    @Id
    private Integer orderId;
    @Column(name = "VegetableID", nullable = false)
    @Id
    private Integer vegetableId;
    @Column(name = "Quantity", nullable = false)
    private Byte quantity;
    @Column(name = "Price", nullable = false, precision = 0)
    private Double price;
}
