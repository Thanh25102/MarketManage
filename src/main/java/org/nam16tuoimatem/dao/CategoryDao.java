package org.nam16tuoimatem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.entity.CategoryEntity;

public class CategoryDao {
    private SessionFactory factory = HibernateInitialize.factory;

    public CategoryEntity findOne(Integer id){
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CategoryEntity category= session.get(CategoryEntity.class,id);
        transaction.commit();
        return category;
    }
}
