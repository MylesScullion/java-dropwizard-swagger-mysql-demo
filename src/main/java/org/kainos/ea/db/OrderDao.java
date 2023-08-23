package org.kainos.ea.db;

import org.kainos.ea.cli.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class OrderDao {
    private static DatabaseConnector databaseConnector = new DatabaseConnector();


    public List<Order> getAllOrders() throws SQLException {

        Connection c = databaseConnector.getConnection();
            Statement st = c.createStatement();

            ResultSet rs =st.executeQuery("SELECT OrderID, CustomerID, OrderDate FROM `Order`;");

            List<Order> orderList = new ArrayList<>();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("CustomerID"),
                        rs.getDate("OrderDate")
                );
                orderList.add(order);
            }
            return orderList;

//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            return null;
//        }
    }
    public static Order getOrderById(int id) throws SQLException {
        Connection c =databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate" + " From `Order` where OrderID = " + id);

        while (rs.next()) {
            return  new Order (
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );
        }
        return null;
    }

}
