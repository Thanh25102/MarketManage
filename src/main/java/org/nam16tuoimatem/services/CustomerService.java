package org.nam16tuoimatem.services;

import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.entity.Customers;

import java.util.List;

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
        );
    }

    public Customers findOne(Long id) {
        return transaction.doInTransaction(() ->
                factory.getCurrentSession().get(Customers.class, id)
        );
    }

    public List<Customers> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap));
    }

    public void saveOrUpdate(Customers customers) {
        transaction.doInTransaction(() ->
                factory.getCurrentSession().merge(customers)
        );
    }

    public void delete(Long id) {
        transaction.doInTransaction(() ->
                factory.getCurrentSession().remove(id)
        );
    }
}
