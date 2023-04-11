package org.nam16tuoimatem.services;

import org.nam16tuoimatem.Record.CategoryRecord;
import org.nam16tuoimatem.dao.CategoryRepo;
import org.nam16tuoimatem.entity.Category;
import org.nam16tuoimatem.mapper.CategoryMapper;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService extends ParentService<Category> {
    private static CategoryService instance;
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    private CategoryService() {
        super(Category.class);
        categoryRepo = CategoryRepo.getInstance();
        categoryMapper = CategoryMapper.getInstance();
    }

    public static CategoryService getInstance() {
        if (instance == null) instance = new CategoryService();
        return instance;
    }

    public CategoryRecord findOne(Integer id) {
        Category category = transaction.doInTransaction(() -> categoryRepo.findOne(id));
        return categoryMapper.apply(category);
    }

    public List<CategoryRecord> findByFields(List<SearchMap> searchMap) {
        List<Category> categories = (List<Category>) transaction.doInTransaction(() -> categoryRepo.findByFields(searchMap));
        return categories.stream().map(categoryMapper).collect(Collectors.toList());
    }

    public CategoryRecord saveOrUpdate(Category category) {
        return categoryMapper.apply(transaction.doInTransaction(() -> categoryRepo.saveOrUpdate(category)));
    }

    public List<CategoryRecord> findAll() {
        List<Category> categories = (List<Category>) transaction.doInTransaction(() -> categoryRepo.findAll());
        return categories.stream().map(categoryMapper).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> categoryRepo.delete(id));
    }
}
