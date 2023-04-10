package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.CategoryRepo;
import org.nam16tuoimatem.entity.Category;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;

public class CategoryService extends ParentService<Category> {
    private static CategoryService instance;
    private final CategoryRepo categoryRepo;

    private CategoryService() {
        super(Category.class);
        categoryRepo = CategoryRepo.getInstance();
    }

    public static CategoryService getInstance() {
        if (instance == null) instance = new CategoryService();
        return instance;
    }

    public Category findOne(Integer id) {
        return transaction.doInTransaction(() -> categoryRepo.findOne(id));
    }

    public List<Category> findByFields(List<SearchMap> searchMap) {
        return (List<Category>) transaction.doInTransaction(() -> categoryRepo.findByFields(searchMap));
    }

    public List<Category> findAll() {
        return (List<Category>) transaction.doInTransaction(() -> categoryRepo.findAll());
    }
}
