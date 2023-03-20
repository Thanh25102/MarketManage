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
import org.nam16tuoimatem.entity.Customers;

import java.util.List;

class ParentService<T> {
    protected final TransactionManager<T> transaction;
    protected final SessionFactory factory;
    @Data
    @AllArgsConstructor
    public static class SearchMap {
        private String field;
        private Object value;
    }
    private final Class<T> type;

    protected ParentService(Class<T> type) {
        this.type = type;
        factory = HibernateInitialize.factory;
        transaction = new TransactionManager<T>();
    }

    protected List<T> findByFields(Session session, List<SearchMap> searchMap) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);
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
}
