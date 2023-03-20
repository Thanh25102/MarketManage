package org.nam16tuoimatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hibernate_sequence", schema = "market3", catalog = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HibernateSequence {
    @Basic
    @Id
    @Column(name = "next_val", nullable = true)
    private Long nextVal;
}