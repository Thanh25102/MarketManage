package org.nam16tuoimatem.services;

import org.nam16tuoimatem.entity.Vegetable;

import java.util.List;
import java.util.stream.Collectors;

public class VegetableService extends ParentService<Vegetable> {
    private static VegetableService instance;

    private VegetableService() {
        super(Vegetable.class);
    }

    public static VegetableService getInstance() {
        if (instance == null) instance = new VegetableService();
        return instance;
    }

    public List<Vegetable> findAll() {
        return transaction.doInTransaction(() -> factory.getCurrentSession().createQuery("FROM Vegetable").getResultList()).stream().collect(Collectors.toList());
    }

    public Vegetable findOne(Integer id) {
        return transaction.doInTransaction(() -> factory.getCurrentSession().get(Vegetable.class, id));
    }

    public List<Vegetable> findByFields(List<SearchMap> searchMap) {
        return transaction.doInTransaction(() -> findByFields(factory.getCurrentSession(), searchMap)).stream().collect(Collectors.toList());
    }

    public Double totalMoney() {
        List<Vegetable> vegetables = findAll();
        return vegetables.stream()
                .mapToDouble(vegetable -> vegetable.getPrice() * vegetable.getAmount())
                .sum();
    }

    public Vegetable saveOrUpdate(Vegetable vegetable) {
        return transaction.doInTransaction(() -> factory.getCurrentSession().merge(vegetable));
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() ->
                factory.getCurrentSession().createQuery("delete from Vegetable where id =: i")
                        .setParameter("i", id).executeUpdate()
        );
    }
}
