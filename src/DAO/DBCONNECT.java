package DAO;

import GUI.MainMenu;
import MyCustom.MyDialog;

import javax.swing.*;
import java.sql.*;

public class DBCONNECT {

    private static String host = "jdbc:mysql://localhost:3306/";
    private static String user = "root";
    private static String pass = "";
    private static String dbname = "sieuthimini";

    private static Statement state;
    private static Connection conn;
    public static int errType = 0;
    // 0 - ko có lỗi
    // 1 - lỗi không tìm thấy driver
    // 2 - lỗi kết nối database
    // 3 - lỗi tạo statement

    public static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(host + dbname + "?useSSL=false", user, pass);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi kết nối Database!" , "", JOptionPane.ERROR_MESSAGE);
            MainMenu.currentFrame.dispose();
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi không tìm thấy jdbc!", "", JOptionPane.ERROR_MESSAGE);
            MainMenu.currentFrame.dispose();
        }
    }

    public static Connection getConn(){
        connect();
        return conn;
    }

    public static Statement getState(){
        if (state == null) {
            if (conn == null) {
                connect();
                if (conn == null) return null;
            }
            try{
                state = conn.createStatement();
                return state;
            }catch (SQLException e){
                errType = 3;
                JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi kết nối database!", "", JOptionPane.ERROR_MESSAGE);
                MainMenu.currentFrame.dispose();
                return null;
            }
        } else return state;
    }

    public static String getError(){
        return switch (DBCONNECT.errType) {
            case 1 -> "Lỗi không tìm thấy driver";
            case 2 -> "Lỗi không kết nối được database";
            case 3 -> "Lỗi truy xuất query";
            default -> "Không có lỗi";
        };
    }

    public static ResultSet getResult(String query){
        try {
            ResultSet rs = DBCONNECT.getState().executeQuery(query);
            return rs;
        }catch (SQLException e){
            DBCONNECT.errType = 3;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi kết nối database!", "", JOptionPane.ERROR_MESSAGE);
            MainMenu.currentFrame.dispose();
        }
        return null;
    }

}
