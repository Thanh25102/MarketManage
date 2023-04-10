package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Category;

import java.util.List;

public class CategoryRepo extends BaseRepo<Category> implements CrudRepository<Category> {
    private static CategoryRepo instance;

    private CategoryRepo() {
        super(Category.class);
    }

    public static CategoryRepo getInstance() {
        if (instance == null) instance = new CategoryRepo();
        return instance;
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }


    @Override
    public Category findOne(Integer id) {
        return findById(id);
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return super.saveOrUpdate(category);
    }

    @Override
    public void delete(Integer id) {
        Category category = new Category();
        category.setCategoryId(id);
        factory.getCurrentSession().remove(category);
    }
}
