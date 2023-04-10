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
}
