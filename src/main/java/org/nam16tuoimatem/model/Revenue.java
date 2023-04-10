package org.nam16tuoimatem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Revenue {
    private int year;
    private int month;
    private Double revenue;
}
