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
    private final Class<T> type;

    protected ParentService(Class<T> type) {
        this.type = type;
        transaction = new TransactionManager();
    }
}
