/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anh Huy
 */
public class KhachHangDAO extends conndb{
    
    public ArrayList<KhachHangDTO> getALL() {
       ArrayList<KhachHangDTO> ls = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM khachhang";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(5));
                kh.setDiaChi(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setKhachHangTT(rs.getBoolean(7));
                kh.setTrangThai(rs.getBoolean(6));
                ls.add(kh);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return ls;
   }
    public boolean add(KhachHangDTO kh ){
        if(openConnection()) {
        try {
            String sql = "INSERT into khachhang values(?,?,?,?,?,?,?)";
            PreparedStatement sttm = con.prepareStatement(sql);
                sttm.setString(1, kh.getMaKH());
                sttm.setString(2, kh.getTenKH());
                sttm.setString(3, kh.getDiaChi());
                sttm.setString(4, kh.getSoDienThoai());
                sttm.setBoolean(5,kh.isGioiTinh());
                sttm.setBoolean(6,true); 
                sttm.setBoolean(7,kh.isKhachHangTT());
            if (sttm.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return true;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());  }
        finally{
               closeConnection();
           }
        }
        return false;
    }
    public boolean update(KhachHangDTO kh ){
        if(openConnection()) {
        try {
            String sql = "UPDATE khachhang SET TenKhachHang = ?, DiaChi=? ,SoDienThoai=?, GioiTinh=?,TrangThai=? ,KHThanThiet=?  WHERE MaKhachHang =?";
            PreparedStatement sttm = con.prepareStatement(sql);
                sttm.setString(7, kh.getMaKH());
                sttm.setString(1, kh.getTenKH());
                sttm.setString(2, kh.getDiaChi());
                sttm.setString(3, kh.getSoDienThoai());
                sttm.setBoolean(4,kh.isGioiTinh());
                sttm.setBoolean(5,kh.isTrangThai()); 
                sttm.setBoolean(6,kh.isKhachHangTT());
            if (sttm.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return true;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString()); }
        finally{
               closeConnection();
           }
        }
        return false;
    }
    public boolean delete(String  MaKH){
        if(openConnection()) {
        try {
            String sql = "UPDATE khachhang set TrangThai = 0 WHERE MaKhachHang = ?";
            PreparedStatement sttm = con.prepareStatement(sql);
            sttm.setString(1,MaKH);
            if (sttm.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return true;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString()); }
        finally{
               closeConnection();
           }
        }
        return false;
    }
    public List<KhachHangDTO> findByName(String name){
       ArrayList<KhachHangDTO> ls = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM khachhang WHERE TenKhachHang like '%"+name+"%'";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(5));
                kh.setDiaChi(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setKhachHangTT(rs.getBoolean(7));
                kh.setTrangThai(rs.getBoolean(6));
                ls.add(kh);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return ls;
   }
    public ArrayList<KhachHangDTO> getAll() {
       ArrayList<KhachHangDTO> ls = new ArrayList<>();
       if(openConnection()) {
           try {
               String sql = "SELECT * FROM khachhang WHERE TrangThai = 1";
               Statement s = con.createStatement();
               ResultSet rs = s.executeQuery(sql);
               while(rs.next()) {
                   KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(5));
                kh.setDiaChi(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setKhachHangTT(rs.getBoolean(7));
                kh.setTrangThai(rs.getBoolean(6));
                ls.add(kh);
               }
           } catch (Exception e) {
               System.out.println(e);
           } finally {
               closeConnection();
           }
       }
       return ls;
   }
}
