package org.nam16tuoimatem.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Vegetable", schema = "Market", catalog = "")
public class VegetableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VegetableID")
    private int vegetableId;
    @Basic
    @Column(name = "CatagoryID")
    private int catagoryId;
    @Basic
    @Column(name = "VegetableName")
    private String vegetableName;
    @Basic
    @Column(name = "Unit")
    private String unit;
    @Basic
    @Column(name = "Amount")
    private int amount;
    @Basic
    @Column(name = "Image")
    private String image;
    @Basic
    @Column(name = "Price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "CatagoryID", referencedColumnName = "CatagoryID", nullable = false)
    private CategoryEntity categoryByCatagoryId;
    @OneToMany(mappedBy = "vegetableByVegetableId")
    private Collection<OrderDetailEntity> orderDetailsByVegetableId;

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VegetableEntity that = (VegetableEntity) o;
        return vegetableId == that.vegetableId && catagoryId == that.catagoryId && amount == that.amount && Double.compare(that.price, price) == 0 && Objects.equals(vegetableName, that.vegetableName) && Objects.equals(unit, that.unit) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vegetableId, catagoryId, vegetableName, unit, amount, image, price);
    }

    public CategoryEntity getCategoryByCatagoryId() {
        return categoryByCatagoryId;
    }

    public void setCategoryByCatagoryId(CategoryEntity categoryByCatagoryId) {
        this.categoryByCatagoryId = categoryByCatagoryId;
    }

    public Collection<OrderDetailEntity> getOrderDetailsByVegetableId() {
        return orderDetailsByVegetableId;
    }

    public void setOrderDetailsByVegetableId(Collection<OrderDetailEntity> orderDetailsByVegetableId) {
        this.orderDetailsByVegetableId = orderDetailsByVegetableId;
    }
}
