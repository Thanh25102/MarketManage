package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.services.CategoryService;
import org.nam16tuoimatem.services.CustomerService;

import java.util.List;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CategoryService categoryService = CategoryService.getInstance();
        categoryService.findAll().forEach(LOG::info);
        CustomerService customerService = CustomerService.getInstance();
        customerService.findByFields(List.of(new CustomerService.SearchMap("city", "london"), new CustomerService.SearchMap("address", "30 Broadway"))).forEach(System.out::println);

    }

}