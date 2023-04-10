package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Order;

import java.util.List;

public class OrderRepo extends BaseRepo<Order> implements CrudRepository<Order> {
    private static OrderRepo instance;

    private OrderRepo() {
        super(Order.class);
    }

    public static OrderRepo getInstance() {
        if (instance == null) instance = new OrderRepo();
        return instance;
    }

    @Override
    public List<Order> findAll() {
        return factory.getCurrentSession()
                .createQuery("FROM Order")
                .getResultList();
    }

    @Override
    public Order findOne(Integer id) {
        return factory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public Order saveOrUpdate(Order order) {
        return factory.getCurrentSession().merge(order);
    }

    @Override
    public void delete(Integer id) {
        Order order = new Order();
        order.setOrderId(id);
        factory.getCurrentSession().remove(order);
    }
}
