package org.nam16tuoimatem.services;

import org.nam16tuoimatem.Record.VegetableRecord;
import org.nam16tuoimatem.dao.VegetableRepo;
import org.nam16tuoimatem.entity.Vegetable;
import org.nam16tuoimatem.mapper.VegetableMapper;
import org.nam16tuoimatem.model.SearchMap;

import java.util.List;
import java.util.stream.Collectors;

public class VegetableService extends ParentService<Vegetable> {
    private static VegetableService instance;
    private final VegetableRepo vegetableRepo;
    private final VegetableMapper vegetableMapper;

    private VegetableService() {
        super(Vegetable.class);
        vegetableRepo = VegetableRepo.getInstance();
        vegetableMapper = VegetableMapper.getInstance();
    }

    public static VegetableService getInstance() {
        if (instance == null) instance = new VegetableService();
        return instance;
    }

    public List<VegetableRecord> findAll() {
        List<Vegetable> vegetables = (List<Vegetable>) transaction.doInTransaction(vegetableRepo::findAll);
        return vegetables.stream().map(vegetableMapper)
                .collect(Collectors.toList());
    }

    public VegetableRecord findOne(Integer id) {
        Vegetable vegetable = transaction.doInTransaction(() -> vegetableRepo.findOne(id));
        return vegetableMapper.apply(vegetable);
    }

    public List<VegetableRecord> findByFields(List<SearchMap> searchMap) {
        List<Vegetable> vegetables = (List<Vegetable>) transaction.doInTransaction(() -> vegetableRepo.findByFields(searchMap));
        return vegetables.stream().map(vegetableMapper)
                .collect(Collectors.toList());
    }

    public Double totalMoney() {
        List<VegetableRecord> vegetables = findAll();
        return vegetables.stream()
                .mapToDouble(vegetable -> vegetable.price() * vegetable.amount())
                .sum();
    }

    public VegetableRecord saveOrUpdate(Vegetable vegetable) {
        Vegetable vegetableSaved = transaction.doInTransaction(() -> vegetableRepo.saveOrUpdate(vegetable));
        return vegetableMapper.apply(vegetableSaved);
    }

    public void delete(Integer id) {
        transaction.doInTransaction(() -> vegetableRepo.delete(id));
    }
}
