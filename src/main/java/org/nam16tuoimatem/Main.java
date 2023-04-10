package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.exception.DateToInValidException;
import org.nam16tuoimatem.model.SearchMap;
import org.nam16tuoimatem.services.OrderService;
import org.nam16tuoimatem.services.VegetableService;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        VegetableService vegetableService = VegetableService.getInstance();
        vegetableService.findAll().forEach(System.out::println);
    }
}