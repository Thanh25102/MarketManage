package org.nam16tuoimatem.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.List;

@Data
@AllArgsConstructor
public class SearchMap {
    private String field;
    private Object value;
}