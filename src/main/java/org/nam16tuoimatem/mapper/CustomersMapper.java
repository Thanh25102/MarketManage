package org.nam16tuoimatem.mapper;


import org.nam16tuoimatem.Record.CustomerRecord;
import org.nam16tuoimatem.entity.Customers;

import java.util.function.Function;

public class CustomersMapper implements Function<Customers, CustomerRecord> {
    private static CustomersMapper instance;

    public static CustomersMapper getInstance() {
        if (instance == null) instance = new CustomersMapper();
        return instance;
    }

    private CustomersMapper() {
    }

    @Override
    public CustomerRecord apply(Customers customers) {
        return new CustomerRecord(customers.getCustomerId(), customers.getPassword(), customers.getFullname(), customers.getAddress(), customers.getCity());
    }
}