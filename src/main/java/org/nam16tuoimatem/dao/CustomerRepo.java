package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Customers;

import java.util.List;

public class CustomerRepo extends BaseRepo<Customers> implements CrudRepository<Customers> {
    private static CustomerRepo instance;

    private CustomerRepo() {
        super(Customers.class);
    }

    public static CustomerRepo getInstance() {
        if (instance == null) instance = new CustomerRepo();
        return instance;
    }

    @Override
    public List<Customers> findAll() {
        return super.findAll();
    }

    @Override
    public Customers findOne(Integer id) {
        return findById(id);
    }

    @Override
    public Customers saveOrUpdate(Customers customers) {
        return super.saveOrUpdate(customers);
    }

    @Override
    public void delete(Integer id) {
        factory.getCurrentSession().createQuery("delete from Customers c WHERE c.id = :i")
                .setParameter("i",id).executeUpdate();
    }
}
