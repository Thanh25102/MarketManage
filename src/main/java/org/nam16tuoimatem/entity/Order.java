package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID", nullable = false)
    private Integer orderId;
    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;
    @Column(name = "Date", nullable = false)
    private Date date;
    @Column(name = "Total", nullable = false, precision = 0)
    private Double total;
    @Column(name = "Note", nullable = false, length = -1)
    private String note;
    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    private Customers customersByCustomerId;
}
