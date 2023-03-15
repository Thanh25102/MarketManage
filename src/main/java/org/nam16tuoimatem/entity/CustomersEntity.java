package org.nam16tuoimatem.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Customers", schema = "Market", catalog = "")
public class CustomersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerID")
    private int customerId;
    @Basic
    @Column(name = "Password")
    private String password;
    @Basic
    @Column(name = "Fullname")
    private String fullname;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "City")
    private String city;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return customerId == that.customerId && Objects.equals(password, that.password) && Objects.equals(fullname, that.fullname) && Objects.equals(address, that.address) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, password, fullname, address, city);
    }
}
