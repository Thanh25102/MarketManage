package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CatagoryID", nullable = false)
    private Integer categoryId;
    @Column(name = "Name", nullable = false, length = 30)
    private String name;
    @Column(name = "Description", nullable = true, length = 50)
    private String description;
}
