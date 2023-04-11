package org.nam16tuoimatem.mapper;

import org.nam16tuoimatem.Record.CategoryRecord;
import org.nam16tuoimatem.entity.Category;

import java.util.function.Function;

public class CategoryMapper implements Function<Category, CategoryRecord> {
    private static CategoryMapper instance;
    public static CategoryMapper getInstance() {
        if (instance == null) instance = new CategoryMapper();
        return instance;
    }
    private CategoryMapper() {}
    @Override
    public CategoryRecord apply(Category category) {
        return new CategoryRecord(category.getCategoryId(), category.getName(), category.getDescription());
    }
}
