package org.nam16tuoimatem.services;

class ParentService<T> {
    protected final TransactionManager<T> transaction;
    private final Class<T> type;

    protected ParentService(Class<T> type) {
        this.type = type;
        transaction = new TransactionManager();
    }
}
