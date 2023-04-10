package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "Fullname", nullable = false, length = 40)
    private String fullname;
    @Basic
    @Column(name = "Address", nullable = true, length = 50)
    private String address;
    @Basic
    @Column(name = "City", nullable = true, length = 20)
    private String city;
}
