package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.services.VegetableService;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        VegetableService vegetableService = VegetableService.getInstance();
        vegetableService.findAll().forEach(System.out::println);
        vegetableService.delete(9);
    }
}