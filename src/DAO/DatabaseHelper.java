/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static String user = "root";
    private static String password = "";
    private static String host = "jdbc:mysql://localhost/sieuthimini";

    public static Connection getDBConnect()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(host, user, password);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return con;
    }





}
