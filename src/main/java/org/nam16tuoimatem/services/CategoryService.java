package org.nam16tuoimatem.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.nam16tuoimatem.entity.Category;

import java.util.List;

public class CategoryService extends ParentService<Category> {
    private static CategoryService instance;

    private CategoryService() {
        super(Category.class);
    }

    public static CategoryService getInstance() {
        if (instance == null)
            instance = new CategoryService();
        return instance;
    }

    public Category findOne(Integer id) {
        return transaction.doInTransaction(() ->
                factory.getCurrentSession().get(Category.class, id)
        );
    }

    public List<Category> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap));
    }

    public List<Category> findAll() {
        return transaction.doInTransaction(() -> factory.getCurrentSession().createQuery("FROM Category").getResultList());
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
