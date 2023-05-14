
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class conndb {
    protected Connection con = null;
    public boolean openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/project_sieuthi";
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
