package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vegetable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VegetableID", nullable = false)
    private Integer vegetableId;
    @Column(name = "CatagoryID", nullable = false)
    private Integer catagoryId;
    @Column(name = "Vegetable_Name", nullable = true, length = 50)
    private String vegetableName;
    @Column(name = "Unit", nullable = false, length = 20)
    private String unit;
    @Column(name = "Amount", nullable = false)
    private Integer amount;
    @Column(name = "Image", nullable = false, length = 50)
    private String image;
    @Column(name = "Price", nullable = false, precision = 0)
    private Double price;
}
