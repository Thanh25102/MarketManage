package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.VegetableRepo;
import org.nam16tuoimatem.entity.Vegetable;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;

public class VegetableService extends ParentService<Vegetable> {
    private static VegetableService instance;
    private final VegetableRepo vegetableRepo;

    private VegetableService() {
        super(Vegetable.class);
        vegetableRepo = VegetableRepo.getInstance();
    }

    public static VegetableService getInstance() {
        if (instance == null) instance = new VegetableService();
        return instance;
    }

    public List<Vegetable> findAll() {
        return (List<Vegetable>) transaction.doInTransaction(vegetableRepo::findAll);
    }

    public Vegetable findOne(Integer id) {
        return transaction.doInTransaction(() -> vegetableRepo.findOne(id));
    }

    public List<Vegetable> findByFields(List<SearchMap> searchMap) {
        return (List<Vegetable>) transaction.doInTransaction(() -> vegetableRepo.findByFields(searchMap));
    }

    public Double totalMoney() {
        List<Vegetable> vegetables = findAll();
        return vegetables.stream()
                .mapToDouble(vegetable -> vegetable.getPrice() * vegetable.getAmount())
                .sum();
    }

    public Vegetable saveOrUpdate(Vegetable vegetable) {
        return transaction.doInTransaction(() -> vegetableRepo.saveOrUpdate(vegetable));
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> vegetableRepo.delete(id));
    }
}
