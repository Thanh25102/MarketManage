package org.nam16tuoimatem.mapper;

import org.nam16tuoimatem.Record.OrderDetailRecord;
import org.nam16tuoimatem.entity.OrderDetail;

import java.util.function.Function;

public class OrderDetailMapper implements Function<OrderDetail, OrderDetailRecord> {
    private static OrderDetailMapper instance;

    public OrderDetailMapper getInstance() {
        if (instance == null) instance = new OrderDetailMapper();
        return instance;
    }

    private OrderDetailMapper() {
    }

    @Override
    public OrderDetailRecord apply(OrderDetail orderDetail) {
        return new OrderDetailRecord(orderDetail.getOrderId(), orderDetail.getVegetableId(), orderDetail.getQuantity(), orderDetail.getPrice());
    }
}
