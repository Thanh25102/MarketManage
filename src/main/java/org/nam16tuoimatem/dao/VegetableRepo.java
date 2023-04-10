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
        return super.findAll();
    }

    @Override
    public Vegetable findOne(Integer id) {
        return super.findById(id);
    }

    @Override
    public Vegetable saveOrUpdate(Vegetable vegetable) {
        return super.saveOrUpdate(vegetable);
    }

    @Override
    public void delete(Integer id) {
        Vegetable vegetable = new Vegetable();
        vegetable.setVegetableId(id);
        factory.getCurrentSession().remove(vegetable);
    }
}
