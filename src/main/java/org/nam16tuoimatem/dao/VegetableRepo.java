package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Vegetable;

import java.util.List;

public class VegetableRepo extends BaseRepo<Vegetable> implements CrudRepository<Vegetable> {
    private static VegetableRepo instance;

    private VegetableRepo() {
        super(Vegetable.class);
    }

    public static VegetableRepo getInstance() {
        if (instance == null) instance = new VegetableRepo();
        return instance;
    }

    @Override
    public List<Vegetable> findAll() {
        return  factory.getCurrentSession().createQuery("FROM Vegetable")
                .getResultList();
    }

    @Override
    public Vegetable findOne(Integer id) {
        return factory.getCurrentSession().get(Vegetable.class, id);
    }

    @Override
    public Vegetable saveOrUpdate(Vegetable vegetable) {
        return factory.getCurrentSession().merge(vegetable);
    }

    @Override
    public void delete(Integer id) {
        factory.getCurrentSession().createQuery("delete from Vegetable where id =: i")
                .setParameter("i", id).executeUpdate();
    }
}
