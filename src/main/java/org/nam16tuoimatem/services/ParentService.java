package org.nam16tuoimatem.services;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nam16tuoimatem.config.HibernateInitialize;

import java.util.List;

class ParentService<T> {
    protected final TransactionManager<T> transaction;
    protected final SessionFactory factory;
    private final Class<T> type;

    protected ParentService(Class<T> type) {
        this.type = type;
        factory = HibernateInitialize.factory;
        transaction = new TransactionManager();
    }

    protected List<T> findByFields(Session session, List<SearchMap> searchMap) {
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

    protected CriteriaQuery<T> getCriteriaQuery(Session session) {
        return session.getCriteriaBuilder().createQuery(type);
    }

    protected Root<T> getRoot(Session session) {
        return getCriteriaQuery(session).from(type);
    }

    @Data
    @AllArgsConstructor
    public static class SearchMap {
        private String field;
        private Object value;
    }
}
