package org.nam16tuoimatem.services;

import org.nam16tuoimatem.entity.Customers;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService extends ParentService<Customers> {

    private static CustomerService instance;

    private CustomerService() {
        super(Customers.class);
    }

    public static CustomerService getInstance() {
        if (instance == null)
            instance = new CustomerService();
        return instance;
    }

    public List<Customers> findAll() {
        return transaction.doInTransaction(() ->
                factory.getCurrentSession().createQuery("FROM Customers").getResultList()
        ).stream().collect(Collectors.toList());
    }

    public Customers findOne(Long id) {
        return transaction.doInTransaction(() ->
                factory.getCurrentSession().get(Customers.class, id)
        );
    }

    public List<Customers> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap)).stream().collect(Collectors.toList());
    }

    public Customers saveOrUpdate(Customers customers) {
        return transaction.doInTransaction(() ->
                factory.getCurrentSession().merge(customers)
        );
    }

    public void delete(Long id) {
        transaction.doInTransaction(() ->
                factory.getCurrentSession().remove(id)
        );
    }
}
