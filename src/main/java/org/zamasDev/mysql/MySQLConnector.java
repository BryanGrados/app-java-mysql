package org.zamasDev.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sistema?serverTimezone=UTC";
            String usr = "root";
            String psw = "Bryan123GRK";
            con = DriverManager.getConnection(url, usr, psw);
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error >> de conexion con la BD" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error >> general : " + e.getMessage());
        }
        return con;
    }

}
