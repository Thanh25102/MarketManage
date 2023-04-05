package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.OrderRepo;
import org.nam16tuoimatem.entity.Order;

import java.util.List;

public class OrderService extends ParentService<Order> {
    private static OrderService instance;
    private final OrderRepo orderRepo;

    private OrderService() {
        super(Order.class);
        orderRepo = OrderRepo.getInstance();
    }

    private OrderService getInstance() {
        if (instance == null) instance = new OrderService();
        return instance;
    }

    public List<Order> findAll() {
        return (List<Order>) transaction.doInTransaction(() -> orderRepo.findAll());
    }

    public Order saveOrUpdate(Order order) {
        return transaction.doInTransaction(() -> orderRepo.saveOrUpdate(order));
    }
}
