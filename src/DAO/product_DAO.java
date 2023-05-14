/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.product_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class product_DAO extends conndb{
    public ArrayList<product_DTO> getAllProducts() {
       ArrayList<product_DTO> arr = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM mathang join loaimathang on mathang.MaLoai = loaimathang.Maloai";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   product_DTO p = new product_DTO();
                   p.setMaSP(rs.getString("MaMatHang"));
                   p.setTenSP(rs.getString("TenMatHang"));
                   p.setMaLoai(rs.getString("MaLoai"));
                   p.setLoaiSP(rs.getString("TenLoai"));
                   p.setSoLuong(rs.getInt("SoLuong"));
                   p.setDvTinh(rs.getString("DonViTinh"));
                   p.setGiaNhap(rs.getFloat("DonGiaNhap"));
                   p.setGiaBan(rs.getFloat("DonGiaBan"));
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
    
    public boolean addNewProduct(ArrayList<product_DTO> newProductList) {
       boolean result = false;
       if(openConnection()) {
           try {
               String sql = "INSERT INTO mathang VALUES(?,?,?,?,?,?,?,?)";
               PreparedStatement prest = con.prepareStatement(sql);
               int count = 0;
               for(int i=0;i<newProductList.size();i++) {
                    prest.setString(1, newProductList.get(i).getMaSP());
                    prest.setString(2, newProductList.get(i).getDvTinh());
                    prest.setInt(3, newProductList.get(i).getSoLuong());
                    prest.setFloat(4, newProductList.get(i).getGiaNhap());
                    prest.setFloat(5, newProductList.get(i).getGiaBan());
                    prest.setString(6, newProductList.get(i).getTenSP());
                    prest.setBoolean(7, newProductList.get(i).isTrangThai());
                    prest.setString(8,newProductList.get(i).getMaLoai());
                    count += prest.executeUpdate();
               }

               if(count == newProductList.size()) {
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
    public boolean addOldProduct(ArrayList<product_DTO> oldProductList) {
       boolean result = false;
       if(openConnection()) {
           try {
               String sql = "UPDATE mathang SET SoLuong = SoLuong + ? WHERE MaMatHang = ?";
               PreparedStatement prest = con.prepareStatement(sql);
               int count = 0;
               for(int i=0;i<oldProductList.size();i++) {
                    prest.setInt(1, oldProductList.get(i).getSoLuong());
                    prest.setString(2, oldProductList.get(i).getMaSP());
                    count += prest.executeUpdate();
               }
               if(count == oldProductList.size()) {
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
    public boolean hasProductID(String id) {
       boolean result = false;
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM mathang WHERE MaMatHang = '" + id + "'";
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
    public boolean fixProduct(product_DTO proDTO, String current_maSP) {
        if(openConnection()) {
           try {
                String sql = "UPDATE mathang SET MaMatHang = ?, DonViTinh = ?, SoLuong = ?,"
                + " DonGiaNhap = ?, DonGiaBan = ?, TenMatHang = ?, TrangThai = ?, MaLoai = ? WHERE MaMatHang = '"+current_maSP+"'";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setString(1, proDTO.getMaSP());
                prest.setString(2, proDTO.getDvTinh());
                prest.setInt(3, proDTO.getSoLuong());
                prest.setFloat(4, proDTO.getGiaNhap());
                prest.setFloat(5, proDTO.getGiaBan());
                prest.setString(6, proDTO.getTenSP());
                prest.setBoolean(7, proDTO.isTrangThai());
                prest.setString(8, proDTO.getMaLoai());
                if(prest.executeUpdate() >= 1) return true;
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
        return false;
    }
    public boolean hideProduct(String maSP) {
        if(openConnection()) {
           try {
                String sql = "UPDATE mathang SET TrangThai = 0 WHERE MaMatHang = '"+maSP+"'";
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
