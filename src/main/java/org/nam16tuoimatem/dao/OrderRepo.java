package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Order;

public class OrderRepo extends BaseRepo<Order> {
    private static OrderRepo instance;

    private OrderRepo() {
        super(Order.class);
    }

    public static OrderRepo getInstance() {
        if (instance == null) instance = new OrderRepo();
        return instance;
    }

}
