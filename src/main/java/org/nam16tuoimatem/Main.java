package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.services.CategoryService;
import org.nam16tuoimatem.services.CustomerService;
import org.nam16tuoimatem.services.VegetableService;

import java.util.List;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        VegetableService vegetableService = VegetableService.getInstance();
        System.out.println(vegetableService.totalMoney());
    }

}