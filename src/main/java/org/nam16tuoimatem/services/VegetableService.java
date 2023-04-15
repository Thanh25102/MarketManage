package org.nam16tuoimatem.services;

import org.nam16tuoimatem.Record.VegetableRecord;
import org.nam16tuoimatem.dao.VegetableRepo;
import org.nam16tuoimatem.entity.Vegetable;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;
import java.util.stream.Collectors;

public class VegetableService extends ParentService<Vegetable> {

    private static VegetableService instance;
    private final VegetableRepo vegetableRepo;

    private VegetableService() {
        super(Vegetable.class);
        vegetableRepo = VegetableRepo.getInstance();
    }

    public static VegetableService getInstance() {
        if (instance == null) {
            instance = new VegetableService();
        }
        return instance;
    }

    public List<VegetableRecord> findAll() {
        List<Vegetable> vegetables = (List<Vegetable>) transaction.doInTransaction(vegetableRepo::findAll);
        return vegetables.stream().map(v -> new VegetableRecord(v.getVegetableId(),
                v.getVegetableName(),
                v.getUnit(),
                v.getAmount(),
                v.getImage(),
                v.getPrice(),
                v.getCategoryByCategoryId().getName())).collect(Collectors.toList());
    }

    public Vegetable findOne(Integer id) {
        return transaction.doInTransaction(() -> vegetableRepo.findOne(id));
    }

    public List<VegetableRecord> findByFields(List<SearchMap> searchMap) {
        List<Vegetable> vegetables = (List<Vegetable>) transaction.doInTransaction(() -> 
                vegetableRepo.findByFields(searchMap));
        if(vegetables == null) return List.of();
        return vegetables.stream().map(v -> new VegetableRecord(v.getVegetableId(),
                v.getVegetableName(),
                v.getUnit(),
                v.getAmount(),
                v.getImage(),
                v.getPrice(),
                v.getCategoryByCategoryId().getName())).collect(Collectors.toList());
    }

    public Double totalMoney() {
        List<VegetableRecord> vegetables = findAll();
        return vegetables.stream()
                .mapToDouble(vegetable -> vegetable.price() * vegetable.amount())
                .sum();
    }

    public Vegetable saveOrUpdate(Vegetable vegetable) {
        return transaction.doInTransaction(() -> vegetableRepo.saveOrUpdate(vegetable));
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> vegetableRepo.delete(id));
    }
}
