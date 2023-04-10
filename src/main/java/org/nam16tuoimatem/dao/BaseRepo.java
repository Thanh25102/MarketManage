package org.nam16tuoimatem.dao;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;

class BaseRepo<T> {
    protected final SessionFactory factory;
    private final Class<T> type;

    protected BaseRepo(Class<T> type) {
        this.type = type;
        factory = HibernateInitialize.factory;
    }

    public T findById(Integer id) {
        return factory.getCurrentSession().get(type, id);
    }
    public List<T> findAll() {
        Session session = factory.getCurrentSession();
        CriteriaQuery<T> query = getCriteriaQuery(factory.getCurrentSession());
        query.select(getRoot(session));
        return session.createQuery(query).getResultList();
    }

    public List<T> findByFields(List<SearchMap> searchMap) {
        Session session = factory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = getCriteriaQuery(session);
        Root<T> root = criteria.from(type);

        criteria.select(root);
        searchMap.forEach(search ->
                criteria.where(
                        search.getField() instanceof String ?
                                criteriaBuilder.and(criteriaBuilder.like(root.get(search.getField()), search.getValue().toString())) :
                                criteriaBuilder.and(criteriaBuilder.equal(root.get(search.getField()), search.getValue()))
                )
        );

        TypedQuery<T> query = session.createQuery(criteria);
        return query.getResultList();
    }

    public T saveOrUpdate(T data) {
        return factory.getCurrentSession().merge(data);
    }

    protected CriteriaQuery<T> getCriteriaQuery(Session session) {
        return session.getCriteriaBuilder().createQuery(type);
    }

    protected Root<T> getRoot(Session session) {
        return getCriteriaQuery(session).from(type);
    }


}
