package org.nam16tuoimatem.services;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nam16tuoimatem.config.HibernateInitialize;

import java.util.List;

public class TransactionManager<T> {
    private final SessionFactory factory;

    public TransactionManager() {
        this.factory = HibernateInitialize.factory;
    }

    protected List<T> doInTransaction(GetList<T> test) {
        Transaction transaction = null;
        try {
            transaction = factory.getCurrentSession().beginTransaction();
            List<T> result = test.execute();
            transaction.commit();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        }
    }

    protected T doInTransaction(Get<T> test) {
        Transaction transaction = null;
        try {
            transaction = factory.getCurrentSession().beginTransaction();
            T result = test.execute();
            transaction.commit();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        }
    }

    protected void doInTransaction(IExecute execute) {
        Transaction transaction = null;
        try {
            transaction = factory.getCurrentSession().beginTransaction();
            execute.execute();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    protected interface GetList<E> {
        List<E> execute();
    }

    protected interface Get<E> {
        E execute();
    }

    protected interface IExecute {
        void execute();
    }
}
