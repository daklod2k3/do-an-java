/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.category_DTO;
import DTO.product_DTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class category_DAO extends conndb{
    public ArrayList<category_DTO> getAllCategorys() {
       ArrayList<category_DTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM loaimathang";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   category_DTO c = new category_DTO();
                   c.setMaLoai(rs.getString("MaLoai"));
                   c.setTenLoai(rs.getString("TenLoai"));
                   arr.add(c);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return arr;
   }
    public boolean hasCategoryID(String id) {
        if(openConnection()) {
           try {
               String sql = "SELECT * FROM loaimathang WHERE MaLoai = '" + id + "'";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               if(rs.next()) return true;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return false;
    }
    public boolean hasCategoryName(String name) {
        if(openConnection()) {
           try {
               String sql = "SELECT * FROM `loaimathang` WHERE LOWER('"+name+"') = LOWER(TenLoai)";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               if(rs.next()) return true;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return false;
    }
    public boolean addCategory(category_DTO cate) {
        if(openConnection()) {
           try {
               String sql = "INSERT INTO loaimathang VALUES (?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, cate.getMaLoai());
                prest.setString(2, cate.getTenLoai());
                if(prest.executeUpdate() >= 1) return true ;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
        return false;
    }
    public boolean fixCategory(category_DTO cate, String current_maLoai) {
        if(openConnection()) {
           try {
               String sql = "UPDATE loaimathang SET MaLoai = ?, TenLoai = ? WHERE MaLoai = '"+current_maLoai+"'";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, cate.getMaLoai());
                prest.setString(2, cate.getTenLoai());
                if(prest.executeUpdate() >= 1) return true ;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
        return false;
    }
    public boolean deleteCategory(String maLoai) {
        if(openConnection()) {
           try {
                String sql = "DELETE FROM loaimathang WHERE MaLoai = '"+maLoai+"'";
                Statement s = con.createStatement();
                int rs = s.executeUpdate(sql);
                if(rs >= 1) return true;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
        return false;
    }
}
