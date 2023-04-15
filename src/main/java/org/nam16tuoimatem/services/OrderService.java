package org.nam16tuoimatem.services;

import org.nam16tuoimatem.dao.OrderRepo;
import org.nam16tuoimatem.entity.Order;
import org.nam16tuoimatem.exception.DateToInValidException;
import org.nam16tuoimatem.model.RevenueType;
import org.nam16tuoimatem.Record.OrderRecord;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService extends ParentService<Order> {

    private static OrderService instance;
    private final OrderRepo orderRepo;

    private OrderService() {
        super(Order.class);
        orderRepo = OrderRepo.getInstance();
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public List<OrderRecord> findAll() {
        List<Order> list = (List<Order>) transaction.doInTransaction(orderRepo::findAll);
        return list.stream().map(item
                -> new OrderRecord(item.getOrderId(),
                        item.getCustomersByCustomerId().getCustomerId(),
                        item.getCustomersByCustomerId().getFullname(),
                        item.getTotal(),
                        item.getDate(),
                        item.getNote()
                )
        ).collect(Collectors.toList());
    }

    public Order saveOrUpdate(Order order) {
        return transaction.doInTransaction(() -> orderRepo.saveOrUpdate(order));
    }

    public Double revenue() {
        List<OrderRecord> orders = findAll();
        return orders.stream()
                .mapToDouble(order -> order.total())
                .sum();
    }

    private Date validateDateTo(Date dateForm, Date dateTo) {
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime(dateForm);
        Calendar calendarTo = Calendar.getInstance();
        calendarTo.setTime(dateTo);
        if (calendarFrom.get(Calendar.YEAR) < calendarTo.get(Calendar.YEAR)) {
            calendarTo.set(Calendar.YEAR, calendarFrom.get(Calendar.YEAR));
            calendarTo.set(Calendar.MONTH, Calendar.DECEMBER);
            int lastDay = calendarTo.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendarTo.set(Calendar.DAY_OF_MONTH, lastDay);
            dateTo = calendarTo.getTime();
        }
        return dateTo;
    }

//    public Map<Integer, Double> revenueWithMonth(Date dateForm, Date dateTo) throws DateToInValidException {
//        return revenue(dateForm, dateTo, RevenueType.MONTH);
//    }
//
//    public Map<Integer, Double> revenueWithYear(Date dateForm, Date dateTo) throws DateToInValidException {
//        return revenue(dateForm, dateTo, RevenueType.YEAR);
//    }
//
//    private Map<Integer, Double> revenue(Date dateForm, Date dateTo, RevenueType type) throws DateToInValidException {
//        if (dateForm.compareTo(dateTo) == 1) {
//            throw new DateToInValidException();
//        }
//        Date dateValid = type.compareTo(RevenueType.MONTH) == 0 ? validateDateTo(dateForm, dateTo) : dateTo;
//
//        Map<Integer, Double> total = new HashMap<>();
//        List<Order> orders = findAll();
//        orders.stream()
//                .filter(order -> order.getDate().after(dateForm) && order.getDate().before(dateValid))
//                .forEach(order -> {
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime(order.getDate());
//                    int calendarType = type.compareTo(RevenueType.MONTH) == 0 ? Calendar.MONTH : Calendar.YEAR;
//                    total.put(calendar.get(calendarType), total.getOrDefault(calendar.get(calendarType), 0D) + order.getTotal());
//                });
//        return total;
//    }
}
