package org.nam16tuoimatem.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.entity.Category;

import java.util.List;

public class CategoryDao {
    private final SessionFactory factory;

    public CategoryDao() {
        this.factory = HibernateInitialize.factory;
    }

    public Category findOne(Integer id) {
        Session session = factory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public List<Category> findAll() {
        Session session = factory.getCurrentSession();
        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // Create CriteriaQuery
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        // Set the root entity and select all records
        Root<Category> root = query.from(Category.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public List<Category> findAll2() {
        Session session = factory.getCurrentSession();
        session.enableFilter("categoryid").setParameter("c",2);
        return session.createQuery("FROM Category").getResultList();
    }

}
