package org.nam16tuoimatem;

import java.util.Date;

public class Record {
    public record VegetableRecord(Integer vegetableId, String vegetableName, String unit, Integer amount, String image,
                                  Double price, String categoryName) {
    }

    public record CategoryRecord(Integer categoryId, String name, String description) {
    }

    public record CustomerRecord(Integer customerId, String password, String fullname, String address, String city) {
    }

    public record OrderRecord(Integer orderId, Date date, Double total, String note, String customerName) {
    }

    public record OrderDetailRecord(Integer orderId, Integer vegetableId, Integer quantity, Double price) {
    }
}
