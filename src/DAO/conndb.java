/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author defaultuser0
 */
    public class conndb {
    protected Connection con = null;

    public boolean openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/sieuthimini?useSSL=false";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return con;
    }
        
}
