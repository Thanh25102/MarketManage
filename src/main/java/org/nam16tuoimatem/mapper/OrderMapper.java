package org.nam16tuoimatem.mapper;

import org.nam16tuoimatem.Record.OrderRecord;
import org.nam16tuoimatem.entity.Order;

import java.util.function.Function;

public class OrderMapper implements Function<Order, OrderRecord> {
    private static OrderMapper instance;

    public static OrderMapper getInstance() {
        if (instance == null) instance = new OrderMapper();
        return instance;
    }

    private OrderMapper() {
    }

    @Override
    public OrderRecord apply(Order order) {
        return new OrderRecord(order.getOrderId(),order.getDate(), order.getTotal(), order.getNote(), order.getCustomersByCustomerId().getFullname());
    }
}
