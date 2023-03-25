package org.nam16tuoimatem.services;

import org.hibernate.Session;
import org.nam16tuoimatem.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService extends ParentService<Category> {
    private static CategoryService instance;

    private CategoryService() {
        super(Category.class);
    }

    public static CategoryService getInstance() {
        if (instance == null) instance = new CategoryService();
        return instance;
    }

    public Category findOne(Integer id) {
        return transaction.doInTransaction(() -> factory.getCurrentSession().get(Category.class, id));
    }

    public List<Category> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap)).stream().collect(Collectors.toList());
    }

    public List<Category> findAll() {
        return transaction.doInTransaction(() -> factory.getCurrentSession().createQuery("FROM Category").getResultList()).stream().collect(Collectors.toList());
    }

    public List<Category> findAll2() {
        return (List<Category>) transaction.doInTransaction(() -> {
            Session session = factory.getCurrentSession();
            return session.createQuery(getCriteriaQuery(session).select(getRoot(session))).getResultList();
        });
    }
}
