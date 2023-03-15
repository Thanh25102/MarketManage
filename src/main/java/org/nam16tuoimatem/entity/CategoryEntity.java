package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "Category", schema = "Market")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CatagoryID")
    private int catagoryId;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Description")
    private String description;

    public CategoryEntity(int catagoryId, String name, String description) {
        this.catagoryId = catagoryId;
        this.name = name;
        this.description = description;
    }

    public CategoryEntity() {

    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "catagoryId=" + catagoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(catagoryId, name, description);
    }
}
