package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;
    @Column(name = "Password", nullable = false, length = 20)
    private String password;
    @Column(name = "Fullname", nullable = false, length = 40)
    private String fullName;
    @Column(name = "Address", nullable = true, length = 50)
    private String address;
    @Column(name = "City", nullable = true, length = 20)
    private String city;
}
