/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.phieuNhap_DTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class phieuNhap_DAO extends conndb{
    public ArrayList<phieuNhap_DTO> getAllPN() {
       ArrayList<phieuNhap_DTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM phieunhap";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   phieuNhap_DTO p = new phieuNhap_DTO();
                   p.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
                   p.setMaNCC(rs.getString("MaNCC"));
                   p.setMaNhanVien(rs.getString("MaNhanVien"));
                   p.setNgayNhap(rs.getDate("NgayLap"));
                   p.setTongTien(rs.getFloat("TongTien"));
                   p.setTrangThai(rs.getBoolean("TrangThai"));
                   arr.add(p);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return arr;
   }
    public boolean hasPhieuNhapID(String id) {
        boolean result = false;
        if(openConnection()) {
           try {
               String sql = "SELECT * FROM phieunhap WHERE MaPhieuNhap = '" + id + "'";
               Statement s = con.createStatement();
               ResultSet rs =  s.executeQuery(sql);
               result = rs.next(); 
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return result;
    }
    public boolean addPhieuNhap(phieuNhap_DTO pn) {
        boolean result = false;
        if(openConnection()) {
           try {
               // đổi kiểu dữ liệu date trong java sang date trong sql
               java.util.Date utilDate = new java.util.Date();
               Date sqlDate = new Date(utilDate.getTime());
               String sql = "INSERT INTO phieunhap VALUES(?,?,?,?,?,?)";
               PreparedStatement prest = con.prepareStatement(sql);
               prest.setFloat(1, pn.getTongTien());
               
               prest.setDate(2, sqlDate);
               prest.setString(3, pn.getMaPhieuNhap());
               prest.setBoolean(4, pn.isTrangThai());
               prest.setString(5, pn.getMaNCC());
               prest.setString(6, pn.getMaNhanVien());
               if(prest.executeUpdate() >= 1) {
                   result = true;
               }
            } catch (Exception e) {
               System.out.println(e);
            } finally {
               closeConnection();
            }
        }
        return result;
    }
}
