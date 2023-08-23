package org.kainos.ea.db;

import org.kainos.ea.cli.Order;
import org.kainos.ea.api.OrderService;
import org.kainos.ea.cli.Product;
import org.kainos.ea.api.ProductService;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    private static Connection conn;

    public static java.sql.Connection getConnection() throws SQLException {
        String user, password, host, name;

        if(conn != null && !conn.isClosed()) {return conn;}

        try
            (FileInputStream propStream = new FileInputStream("db.properties")) {

            Properties props = new Properties();
            props.load(propStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            name = props.getProperty("name");

            if(user == null || password == null || host == null)
                throw new IllegalAccessException("Properties file must exist " +
                        "and must contain user, password, name and host properties.");

            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + name + "?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            {
                System.out.println("I will always run!");
            }
        }
        return null;



    }
}
