
package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {
    protected Connection con = null;
    protected Statement st = null;
    public boolean openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/qlsieuthi";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(dbUrl,username,password);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public void closeConnection() {
        try {
            if(con!=null) {
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
