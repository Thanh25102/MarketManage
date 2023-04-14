package org.nam16tuoimatem.mapper;

import org.nam16tuoimatem.Record.VegetableOrderRecord;
import org.nam16tuoimatem.entity.Vegetable;
import org.nam16tuoimatem.entity.Order;

import java.util.function.Function;

public class OrderMapper implements Function<Vegetable, VegetableOrderRecord> {
    private static OrderMapper instance;

    public static OrderMapper getInstance() {
        if (instance == null) instance = new OrderMapper();
        return instance;
    }
    
    private OrderMapper() {
    }
//    public record VegetableOrderRecord(Integer vegetableId, String vegetableName, Double price, Integer count, Double total) {

    @Override
    public VegetableOrderRecord apply(Vegetable vegetable) {
        return null;
    }
}
