/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author defaultuser0
 */
public class KhachHangDAO {
    Connection conn = null;
    PreparedStatement sttm = null;
  //  ArrayList<KhachHang> ls = new ArrayList<>();
    
    public int add(KhachHangDTO kh ){
        try {
            String sSQL = "insert KhachHang(MaKH,TenKH,GioiTinh,DiaChi,SoDienThoai,KhachHangTT,TrangThai) "
            + "values(?,?,?,?,?,?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,kh.getMaKH());
            sttm.setString(2,kh.getTenKH());
            sttm.setBoolean(3,kh.isGioiTinh());
            sttm.setString(4,kh.getDiaChi());
            sttm.setString(5,kh.getSoDienThoai());
            sttm.setBoolean(6,kh.isKhachHangTT());
            sttm.setBoolean(7,true);
            if (sttm.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    public int update(KhachHangDTO kh ){
        try {
            String sSQL = "update KhachHang set TenKH = ?, SoDienThoai=?, DiaChi=?,GioiTinh=?,KhachHangTT=?, TrangThai=? where MaKH =?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(7,kh.getMaKH());
            sttm.setString(1,kh.getTenKH());
            sttm.setBoolean(4,kh.isGioiTinh());
            sttm.setString(3,kh.getDiaChi());
            sttm.setString(2,kh.getSoDienThoai());
            sttm.setBoolean(5,kh.isKhachHangTT());
            sttm.setBoolean(6,kh.isTrangThai());
            if (sttm.executeUpdate()>0){
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    public int delete(String  MaKH){
        try {
            String sSQL = "update KhachHang set TrangThai = 0 where MaKH = ?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,MaKH);
            if (sttm.executeUpdate()>0){
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+ e.toString());
        }
        return -1;
    }
    public  List<KhachHangDTO> getALL(){
        List<KhachHangDTO> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try{
            String sSQL ="select * from KhachHang ";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSoDienThoai(rs.getString(5));
                kh.setKhachHangTT(rs.getBoolean(6));
                kh.setTrangThai(rs.getBoolean(7));
                ls.add(kh);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        finally{
            try{
                rs.close(); sttm.close();conn.close();
            } catch (Exception e){
            }
        }
        return ls;
    }
    public KhachHangDTO findByID(String MaKH){
        ResultSet rs = null;
        Statement sttm = null;
        try{
            String sSQL = "select * from KhachHang where MaKH='"+MaKH+"'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSoDienThoai(rs.getString(5));
                kh.setKhachHangTT(rs.getBoolean(6));
                kh.setTrangThai(rs.getBoolean(7));
                return kh;
            }
            } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        finally{
            try{
                rs.close(); sttm.close();conn.close();
            } catch (Exception e){
            }
        }
        return null;
        }
    public List<KhachHangDTO> findByName(String name){
        ResultSet rs = null;
        Statement sttm = null;
        List<KhachHangDTO> ls = new ArrayList<>();
        try{
            String sSQL = "select * from KhachHang where TenKH like '%"+name+"%'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSoDienThoai(rs.getString(5));
                kh.setKhachHangTT(rs.getBoolean(6));
                kh.setTrangThai(rs.getBoolean(7));
                ls.add(kh);
            }
            } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }
        finally{
            try{
                rs.close(); sttm.close();conn.close();
            } catch (Exception e){
            }
        }
        return ls;
        }
}
