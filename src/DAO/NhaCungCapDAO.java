/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class NhaCungCapDAO extends conndb{
    public NhaCungCapDAO() {
    }

    public ArrayList<NhaCungCapDTO> getAllNCC() {

        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();

        if (openConnection()) {
            try {

                String sql = "SELECT * FROM nhacungcap WHERE TrangThai = 1";

                ResultSet rs = con.createStatement().executeQuery(sql);

                while (rs.next()) {
                    String maNCC = rs.getString("MaNCC");
                    String tenNCC = rs.getString("TenNCC");
                    String diaChiNCC = rs.getString("DiaChi");
                    String SDT = rs.getString("SoDienThoai");

                    NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, SDT, diaChiNCC);
                    dsncc.add(ncc);
                }
                closeConnection();

            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dsncc;
    }

    public boolean addNCC(NhaCungCapDTO ncc) {
        boolean result = false;
        PreparedStatement stmt = null;
        if (openConnection()) {
            try {
                String sql = "Insert into nhacungcap values(?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, ncc.getMaNCC());
                stmt.setString(2, ncc.getTenNCC());
                stmt.setString(3, ncc.getDiaChiNCC());
                stmt.setString(4, ncc.getSDT());
                stmt.setInt(5, ncc.getTrangThai());
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    public boolean updateNCC(NhaCungCapDTO ncc) {
        boolean result = false;
        PreparedStatement stmt = null;
        if (openConnection()) {
            try {
                String sql = "UPDATE nhacungcap SET TenNCC=?, DiaChi=?, SoDienThoai=? WHERE MaNCC=?";
                
                stmt = con.prepareStatement(sql);
                stmt.setString(4, ncc.getMaNCC());
                stmt.setString(1, ncc.getTenNCC());
                stmt.setString(2, ncc.getDiaChiNCC());
                stmt.setString(3, ncc.getSDT());
                
                if (stmt.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection();
            }
        }
        return result;
    }

    public boolean delNCC(String maNCC) {
        boolean result = false;
        Statement stmt = null;
        
        if (openConnection()) {
            try {
                String sql = "UPDATE nhacungcap SET TrangThai = 0 WHERE MaNCC = '"+maNCC+"'";
                stmt = con.createStatement();
                
                if(stmt.executeUpdate(sql) >= 1)
                    result = true;
                System.out.println(sql);
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                 closeConnection();
            }
        }
        return result;
    }
    public void ImportExcelDatabase(File file){
       if (openConnection()){
           try{
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String maNCC = row.getCell(0).getStringCellValue();
                String tenNCC = row.getCell(1).getStringCellValue();
                
                String diaChi = row.getCell(2).getStringCellValue();
                String SDT = row.getCell(3).getStringCellValue();
                
                
                
                String sql_check = "SELECT * FROM nhacungcap WHERE MaNCC='"+maNCC+"'";
                ResultSet rs = con.createStatement().executeQuery(sql_check);
                if(!rs.next()){
                    String sql = "INSERT INTO nhacungcap VALUES (";
                    sql += "'"+maNCC+"',";
                    sql += "N'"+tenNCC+"',";                    
                    sql += "N'"+diaChi+"',";
                    sql += "'"+SDT+"',";
                    sql += "1)";
                    System.out.println(sql);
                    con.createStatement().executeUpdate(sql);
                }
                else{
                    String sql = "UPDATE nhacungcap SET ";
                    sql += "TenNCC='"+tenNCC+"', ";
                    
                    sql += "DiaChi='"+diaChi+"', ";
                    sql += "SoDienThoai='"+SDT+"', ";
                    
                    sql += "TrangThai='"+1+"' ";
                    sql += "WHERE MaNCC='"+maNCC+"'";
                    System.out.println(sql);    
                    con.createStatement().executeUpdate(sql);
                }
            }
            in.close();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        
    }
}

//    public boolean hasNCC(String maNCC) {
//        boolean flag = false;
//        if (mySQL.getConnection() != null) {
//            try {
//                String sql = "SELECT * FROM nhacungcap WHERE TrangThai = 1 and maNCC = " + maNCC;
//                ResultSet rs = mySQL.executeQuery(sql);
//                flag = rs.next();
//            } catch (SQLException ex) {
//                Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return flag;
//    }
//    public void delete(String maNCC)
//    {
//        MySQLConnect mySQL = new MySQLConnect();
//        String sql = "UPDATE nhacungcap SET TrangThai = 0 WHERE MaNCC = "+ maNCC;
//        mySQL.executeUpdate(sql);
//        System.out.println(sql);
//    }
//}
