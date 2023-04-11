package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Customers;

public class CustomerRepo extends BaseRepo<Customers> {
    private static CustomerRepo instance;

    private CustomerRepo() {
        super(Customers.class);
    }

    public static CustomerRepo getInstance() {
        if (instance == null) instance = new CustomerRepo();
        return instance;
    }
}
