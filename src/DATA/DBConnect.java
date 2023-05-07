package DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    private String user = "root";
    private String password = "";
    private String host = "jdbc:mysql://localhost/sieuthimini";
    private Connection con = null;
    private Statement state = null;
    private String mess = null;

    public void Connect()
    {
        try
        {
            con = DriverManager.getConnection(host, user, password);
        }
        catch (SQLException e)
        {
           mess = e.getMessage();
        }
    }

    public void disConnect(){
        try
        {
            con.close();
        }
        catch (SQLException e)
        {
            mess = e.getMessage();
        }
    }



}
