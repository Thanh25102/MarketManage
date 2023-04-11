package org.nam16tuoimatem.mapper;

import org.nam16tuoimatem.Record.VegetableRecord;
import org.nam16tuoimatem.entity.Vegetable;

import java.util.function.Function;

public class VegetableMapper implements Function<Vegetable, VegetableRecord> {
    private static VegetableMapper instance;
    public static VegetableMapper getInstance() {
        if (instance == null) instance = new VegetableMapper();
        return instance;
    }
    private VegetableMapper() {
    }
    @Override
    public VegetableRecord apply(Vegetable vegetable) {
        return new VegetableRecord(
                vegetable.getVegetableId(), vegetable.getVegetableName(), vegetable.getUnit(), vegetable.getAmount(),vegetable.getImage(), vegetable.getPrice(), vegetable.getCategoryByCategoryId().getName()
        );
    }
}
