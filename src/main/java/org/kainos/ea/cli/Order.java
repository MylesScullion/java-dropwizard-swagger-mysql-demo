package org.kainos.ea.cli;


import java.util.Date;
public class Order implements Comparable<Order>{

    private int orderId;
    private int customerId;
    private Date orderDate;
    public Order(int setOrderId, int setCustomerId, Date setOrderDate) {
        this.orderId = setOrderId;
        this.customerId = setCustomerId;
        this.orderDate = setOrderDate;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

@Override
    public String toString() {
        return "OrderID: " + this.getOrderId() + ", CustomerID: " + this.getCustomerId() + ", OrderDate: " + this.getOrderDate();
}

    @Override
    public int compareTo(Order order) {
        return this.getOrderDate().compareTo(order.getOrderDate());
    }
}
