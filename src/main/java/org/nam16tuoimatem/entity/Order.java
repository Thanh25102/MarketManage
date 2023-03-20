package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID", nullable = false)
    private Integer orderId;
    @Basic
    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "Date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "Total", nullable = false, precision = 0)
    private Double total;
    @Basic
    @Column(name = "Note", nullable = false, length = -1)
    private String note;
}
