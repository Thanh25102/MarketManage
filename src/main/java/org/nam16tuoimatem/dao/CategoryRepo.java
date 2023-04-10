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
}
