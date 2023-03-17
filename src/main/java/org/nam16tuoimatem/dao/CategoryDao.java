package org.nam16tuoimatem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.entity.Category;

public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao() {
        this.factory = HibernateInitialize.factory;
    }

    public Category findOne(Integer id) {
        Session session = factory.getCurrentSession();
        return session.get(Category.class, id);
    }
}
