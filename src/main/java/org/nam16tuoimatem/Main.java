package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.services.CategoryService;
import org.nam16tuoimatem.services.TransactionManager;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService(new CategoryDao(), new TransactionManager<>());
        categoryService.findAll().forEach(LOG::info);
    }
}