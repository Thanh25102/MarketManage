package org.nam16tuoimatem.services;

import org.nam16tuoimatem.entity.Vegetable;

import java.util.List;

public class VegetableService extends ParentService<Vegetable> {
    private static VegetableService instance;

    public static VegetableService getInstance() {
        if (instance == null) instance = new VegetableService();
        return instance;
    }

    private VegetableService() {
        super(Vegetable.class);
    }

    public List<Vegetable> findAll() {
        return transaction.doInTransaction(() -> factory.getCurrentSession().createQuery("FROM Vegetable").getResultList());
    }

    public List<Vegetable> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap));
    }

    public Double totalMoney() {
        List<Vegetable> vegetables = findAll();
        return vegetables.stream()
                .mapToDouble(vegetable -> vegetable.getPrice() * vegetable.getAmount())
                .sum();
    }
}
