package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vegetable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VegetableID", nullable = false)
    private Integer vegetableId;
    @Basic
    @Column(name = "CatagoryID", nullable = false)
    private Integer catagoryId;
    @Basic
    @Column(name = "VegetableName", nullable = false, length = 30)
    private String vegetableName;
    @Basic
    @Column(name = "Unit", nullable = false, length = 20)
    private String unit;
    @Basic
    @Column(name = "Amount", nullable = false)
    private Integer amount;
    @Basic
    @Column(name = "Image", nullable = false, length = 50)
    private String image;
    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "CatagoryID", referencedColumnName = "CatagoryID", nullable = false)
    private Category categoryByCatagoryId;
    @OneToMany(mappedBy = "vegetableByVegetableId")
    private Collection<OrderDetail> orderDetailsByVegetableId;
}
