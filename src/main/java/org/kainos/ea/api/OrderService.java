package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.Product;
import org.kainos.ea.client.FailedToGetOrdersException;
import org.kainos.ea.client.FailedToGetProductsException;
import org.kainos.ea.client.OrderDoesNotExistException;
import org.kainos.ea.client.ProductDoesNotExistException;
import org.kainos.ea.db.OrderDao;
import org.kainos.ea.db.DatabaseConnector;


import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    public List<Order> getAllOrders() throws FailedToGetOrdersException {
        List<Order> orderList = null;
        try {
            orderList = orderDao.getAllOrders();
        } catch (SQLException e) {
            throw new FailedToGetOrdersException();
        }

//        List<Integer> cusIDs = orderList.stream().map(order -> order.getOrderId()).collect(Collectors.toList());
//        cusIDs.stream()
//             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
//



        return orderList;
    }
    public Order getOrderById(int id) throws FailedToGetOrdersException, OrderDoesNotExistException {
        try {
            Order order =OrderDao.getOrderById(id);

            if (order == null) {
                throw new OrderDoesNotExistException();
            }
            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }
    }




}
