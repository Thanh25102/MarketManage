package org.nam16tuoimatem.services;

import org.nam16tuoimatem.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService extends ParentService<Order> {
    private static OrderService instance;

    private OrderService() {
        super(Order.class);
    }

    private OrderService getInstance() {
        if (instance == null) instance = new OrderService();
        return instance;
    }

    public List<Order> findAll() {
        return transaction.doInTransaction(() ->
                        factory.getCurrentSession().createQuery("FROM Order")
                                .getResultList()).stream()
                .collect(Collectors.toList());
    }

    public Order saveOrUpdate(Order order) {
        return transaction.doInTransaction(() -> factory.getCurrentSession().merge(order));
    }
}
