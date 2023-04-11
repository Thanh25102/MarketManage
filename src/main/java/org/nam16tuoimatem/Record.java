package org.nam16tuoimatem;

import java.sql.Date;

public class Record {
    public record VegetableRecord(Integer vegetableId, String vegetableName, String unit, Integer amount, String image,
                                  Double price) {
    }

    public record CustomersRecord(Integer customerId, String password, String fullname, String address, String city) {
    }

    public record OrderRecord(Integer orderId, Date date, Double total, String note) {
    }

    public record OrderDetail(Integer orderId, Integer vegetableId, Integer quantity, Double price) {
    }

    public record CategoryRecord(Integer categoryId, String name, String description) {
    }
}
