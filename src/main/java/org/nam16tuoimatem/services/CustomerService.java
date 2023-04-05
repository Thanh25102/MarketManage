package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.CustomerRepo;
import org.nam16tuoimatem.entity.Customers;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService extends ParentService<Customers> {

    private static CustomerService instance;
    private final CustomerRepo customerRepo;

    private CustomerService() {
        super(Customers.class);
        customerRepo = CustomerRepo.getInstance();
    }

    public static CustomerService getInstance() {
        if (instance == null)
            instance = new CustomerService();
        return instance;
    }

    public List<Customers> findAll() {
        return (List<Customers>) transaction.doInTransaction(() -> customerRepo.findAll());
    }

    public Customers findOne(Integer id) {
        return transaction.doInTransaction(() -> customerRepo.findOne(id));
    }

    public List<Customers> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> customerRepo.findByFields(searchMap)).stream().collect(Collectors.toList());
    }

    public Customers saveOrUpdate(Customers customers) {
        return transaction.doInTransaction(() -> customerRepo.saveOrUpdate(customers));
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> customerRepo.delete(id));
    }
}
