package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.entity.Category;

public class CategoryService extends TransactionManager<Category> {
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Category findOne(Integer id) {
        return doInTransaction(() -> categoryDao.findOne(id));
    }
}
