package org.nam16tuoimatem.dao;

import org.nam16tuoimatem.entity.Vegetable;

public class VegetableRepo extends BaseRepo<Vegetable> {
    private static VegetableRepo instance;

    private VegetableRepo() {
        super(Vegetable.class);
    }

    public static VegetableRepo getInstance() {
        if (instance == null) instance = new VegetableRepo();
        return instance;
    }
}
