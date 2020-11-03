package edu.tarleton.restorder;

import java.util.ArrayList;
import java.util.List;


public class Database {
    
    private static final List<Order> orders = new ArrayList<>();
    
    public static void addOrder(Order order) {
        orders.add(order);
    }
    
    public static void deleteOrder(String id) {
        for (int i=0; i<orders.size();i++) {
            if (orders.get(i).getId().equals(id)) {
                orders.remove(i);
            }
            System.out.println(orders);
        }
    }
    
    public static List<Order> getOrders() {
        return orders;
    }
}
