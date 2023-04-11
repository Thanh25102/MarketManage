package org.nam16tuoimatem.services;

import org.nam16tuoimatem.Record.CustomerRecord;
import org.nam16tuoimatem.dao.CustomerRepo;
import org.nam16tuoimatem.entity.Customers;
import org.nam16tuoimatem.mapper.CustomersMapper;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService extends ParentService<Customers> {

    private static CustomerService instance;
    private final CustomerRepo customerRepo;
    private final CustomersMapper customersMapper;

    private CustomerService() {
        super(Customers.class);
        customerRepo = CustomerRepo.getInstance();
        customersMapper= CustomersMapper.getInstance();
    }

    public static CustomerService getInstance() {
        if (instance == null)
            instance = new CustomerService();
        return instance;
    }

    public List<CustomerRecord> findAll() {
        List<Customers> customers= (List<Customers>) transaction.doInTransaction(customerRepo::findAll);
        return customers.stream().map(customersMapper).collect(Collectors.toList());
    }

    public CustomerRecord findOne(Integer id) {
        return customersMapper.apply(transaction.doInTransaction(() -> customerRepo.findOne(id)));
    }

    public List<CustomerRecord> findByFields(List<SearchMap> searchMap) {
        List<Customers> customers=  (List<Customers>) transaction.doInTransaction(() -> customerRepo.findByFields(searchMap));
        return customers.stream().map(customersMapper).collect(Collectors.toList());
    }

    public CustomerRecord saveOrUpdate(Customers customers) {
        return customersMapper.apply(transaction.doInTransaction(() -> customerRepo.saveOrUpdate(customers)));
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> customerRepo.delete(id));
    }
}
