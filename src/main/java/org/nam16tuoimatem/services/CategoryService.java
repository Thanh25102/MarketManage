package org.nam16tuoimatem.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.entity.Category;

import java.util.List;

public class CategoryService {
    private final SessionFactory factory;
    private final TransactionManager<Category> transaction;

    private static CategoryService instance;

    public static CategoryService getInstance() {
        if(instance == null)
            instance = new CategoryService();
        return instance;
    }

    private CategoryService() {
        factory = HibernateInitialize.factory;
        this.transaction = new TransactionManager<>();
    }

    public Category findOne(Integer id) {
        return transaction.doInTransaction(() -> {
            Session session = factory.getCurrentSession();
            return session.get(Category.class, id);
        });
    }

    public List<Category> findAll() {
        return transaction.doInTransaction(() -> {
            Session session = factory.getCurrentSession();
            return session.createQuery("FROM Category").getResultList();
        });
    }

    public List<Category> findAll2() {
        return transaction.doInTransaction(() -> {
            Session session = factory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> query = builder.createQuery(Category.class);
            Root<Category> root = query.from(Category.class);
            query.select(root);
            return session.createQuery(query).getResultList();
        });
    }
}
