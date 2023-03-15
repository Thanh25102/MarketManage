package org.nam16tuoimatem.services;

import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.nam16tuoimatem.dao.CategoryDao;
import org.nam16tuoimatem.entity.CategoryEntity;

public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryEntity findOne(Integer id){
        return  categoryDao.findOne(id);
    }
}
