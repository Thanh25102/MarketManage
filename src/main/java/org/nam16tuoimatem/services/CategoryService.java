package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.entity.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao;
    private final TransactionManager<Category> transaction;

    public CategoryService(CategoryDao categoryDao, TransactionManager<Category> transaction) {
        this.categoryDao = categoryDao;
        this.transaction = transaction;
    }

    public Category findOne(Integer id) {
        return transaction.doInTransaction(() ->
                categoryDao.findOne(id)
        );
    }

    public List<Category> findAll() {
        return transaction.doInTransaction(categoryDao::findAll);
    }
}
