package org.nam16tuoimatem.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.nam16tuoimatem.config.HibernateInitialize;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class TransactionManager<T> {
    private final Logger LOG = LogManager.getLogger(TransactionManager.class);
    private final SessionFactory factory;

    public TransactionManager() {
        this.factory = HibernateInitialize.factory;
    }

    protected Collection<T> doInTransaction(GetList<T> test) {
        Transaction transaction = null;
        Session session = factory.getCurrentSession();
        try {
            transaction = session.beginTransaction();
            List<T> result = test.execute();
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Can't not execute service : " + this.getClass() + " Error :" + e);
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    protected T doInTransaction(Get<T> test) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            T result = test.execute();
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Can't not execute service : " + e);
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    protected void doInTransaction(IExecute execute) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            execute.execute();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            LOG.error("Can't not execute service : " + e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    protected interface GetList<E> {
        List<E> execute();
    }

    protected interface Get<E> {
        E execute() throws IOException;
    }

    protected interface IExecute {
        void execute();
    }
}
