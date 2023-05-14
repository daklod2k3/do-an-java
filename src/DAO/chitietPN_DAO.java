/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chitietPN_DTO;
import DTO.phieuNhap_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class chitietPN_DAO extends conndb{
    public boolean addChiTietPN(ArrayList<chitietPN_DTO> chiList) {
        boolean result = false;
        if(openConnection()) {
            try {
                int count = 0;
               String sql = "INSERT INTO chitietphieunhap VALUES(?,?,?,?,?)";
               PreparedStatement prest = con.prepareStatement(sql);
               for(int i=0;i<chiList.size();i++) {
                    prest.setFloat(1, chiList.get(i).getDonGia());
                    prest.setInt(2, chiList.get(i).getSoLuong());
                    prest.setBoolean(3, chiList.get(i).isTrangThai());
                    prest.setString(4, chiList.get(i).getMaPN());
                    prest.setString(5, chiList.get(i).getMaSP());
                    count+=prest.executeUpdate();
               }

               if(count == chiList.size()) {
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
    public ArrayList<chitietPN_DTO> getAllChiTietPN() {
        ArrayList<chitietPN_DTO> arr = new ArrayList<>();
        if(openConnection()) {
            try {
                int count = 0;
               String sql = "SELECT * FROM chitietphieunhap";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   chitietPN_DTO chiTiet = new chitietPN_DTO();
                   chiTiet.setMaPN(rs.getString("MaPhieuNhap"));
                   chiTiet.setMaSP(rs.getString("MaMatHang"));
                   chiTiet.setSoLuong(rs.getInt("SoLuong"));
                   chiTiet.setDonGia(rs.getFloat("DonGia"));
                   chiTiet.setTrangThai(rs.getBoolean("TrangThai"));
                   arr.add(chiTiet);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
        return arr;
    }
}
