package org.nam16tuoimatem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.entity.Category;
import org.nam16tuoimatem.services.CategoryService;

import java.io.IOException;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        LOG.info("hello");
        CategoryService categoryService = new CategoryService(new CategoryDao());
        Category category = categoryService.findOne(2);
        System.out.println(category);
    }
}