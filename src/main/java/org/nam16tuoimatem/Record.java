package org.nam16tuoimatem;

import java.util.Date;

public class Record {
    public record VegetableRecord(Integer vegetableId,String vegetableName,String unit,Integer amount,String image,Double price, String categoryName){}

    public record OrderRecord(Integer orderId, Integer customerId, String customerName, Double total, Date date,  String notes) {
    }

    public record CustomerRecord(Integer customerId, String password, String fullname, String address, String city) {
    }

    public record VegetableOrderRecord(Integer vegetableId, String vegetableName, Double price, Integer count, Double total) {
    }

    public record OrderDetailRecord(Integer orderId, Integer vegetableId, Integer quantity, Double price) {
    }
}