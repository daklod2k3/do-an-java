/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.conndb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import DTO.NhanVienDTO;

/**
 *
 * @author defaultuser0
 */
public class NhanVienDAO extends conndb{
    ArrayList<NhanVienDTO> ls = new ArrayList<>();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy/MM/dd");

    
    
   /* public int add(NhanVien nv){
        ls.add(nv);
        return 1;
    }
     public NhanVien find(String maNV){
        for(NhanVien nv : ls){
            if(nv.getMaNV().equals(maNV)){
                return nv;
            }
        }
        return null;
    }
    public ArrayList<NhanVien> getall(){
        return ls;
    }
    public int delete(String maNV){
        NhanVien nv = find(maNV);
        if(nv!=null){
            ls.remove(nv);
            return 1;
        }
        return -1;
    }
    public int update(NhanVien nvNew){
       for(NhanVien nv : ls ){
           if(nv.getMaNV().equals(nvNew.getMaNV())){
               nv.setMaNV( nvNew.getMaNV());
               nv.setTenNV(nvNew.getTenNV());
               nv.setPhone(nvNew.getPhone());
               nv.setGioiTinh(nvNew.isGioiTinh());
               nv.setNgaySinh(nvNew.getNgaySinh());
               nv.setLuong(nvNew.getLuong());
               nv.setTrangThai(nvNew.isTrangThai());
               nv.setDiaChi(nvNew.getDiaChi());
               return 1;
           }
       }
       return -1;
    }
    public ArrayList<NhanVien> search(String maNV){
        ArrayList<NhanVien> lsSearch = new ArrayList<>();
        for(NhanVien nv : ls){
            if(nv.getMaNV().equals(maNV)){
                lsSearch.add(nv);
            }
        }
        return lsSearch;
    }
*/
    public void sapXepTheoTen(){
        Comparator<NhanVienDTO> cmp = new Comparator<NhanVienDTO>() {
            @Override
            public int compare(NhanVienDTO o1, NhanVienDTO o2) {
                return o1.splitName(o1.getTenNV()).compareTo(o2.splitName(o2.getTenNV()));
                }
        };  
        Collections.sort(ls, cmp);
    }
    
   public int add(NhanVienDTO nv) throws SQLException {
    PreparedStatement sttm = null;
        if(openConnection()) {
            try {
                    String sSQL = "INSERT INTO `nhanvien`(`MaNhanVien`, `TenNhanVien`, `SoDienThoai`, `DiaChi`, `GioiTinh`, `NgaySinh`, `Luong`, `ChucVu`, `TrangThai`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        sttm = con.prepareStatement(sSQL);
        sttm.setString(1, nv.getMaNV());
        sttm.setString(2, nv.getTenNV());
        sttm.setString(3, nv.getPhone());
        sttm.setString(4, nv.getDiaChi());
        sttm.setBoolean(5, nv.isGioiTinh());
        sttm.setString(6, date_format.format(nv.getNgaySinh()));
        sttm.setFloat(7, (float) nv.getLuong());
        sttm.setBoolean(8, nv.isChucVu());
        sttm.setBoolean(9, nv.isTrangThai());
        if (sttm.executeUpdate() > 0) {
            System.out.println("Add thanh cong");
            return 1;
        } else {
            System.out.println("Add that bai");
            return -1;
        }
        } catch(Exception e) {
             e.printStackTrace();
        }
       } 
        return 0;
}
    public ArrayList<NhanVienDTO> getall(){
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        Statement sttm = null;
        ResultSet rs = null;
        if(openConnection()){
            try {
                 String sSQL="SELECT * FROM nhanvien;";
                sttm=con.createStatement();
                rs=sttm.executeQuery(sSQL);
                while(rs.next()){
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setMaNV(rs.getString(1));
                    nv.setTenNV(rs.getString(2));
                    nv.setPhone(rs.getString(3));
                    nv.setDiaChi(rs.getString(4));
                    nv.setGioiTinh(rs.getBoolean(5));
                    nv.setNgaySinh(rs.getDate(6));
                    nv.setLuong((double) rs.getFloat(7));
                    nv.setChucVu(rs.getBoolean(8));
                    nv.setTrangThai(rs.getBoolean(9));
                    ds.add(nv);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ds;
    }
    public int delete(String maNV) {
        PreparedStatement sttm = null;
        boolean isDeleted = false;
        if(openConnection()) {
            try {
            // Xóa các tài khoản liên quan đến nhân viên
            String sSQL1 = "UPDATE taikhoan SET trangthai = 0 WHERE MaNhanVien = ?";

            sttm = con.prepareStatement(sSQL1);
            sttm.setString(1, maNV);
            sttm.executeUpdate();

            // Xóa nhân viên
            String sSQL2 = "update nhanvien set trangthai = 0 where  MaNhanVien = ?";
            sttm = con.prepareStatement(sSQL2);
            sttm.setString(1, maNV);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xoa thanh cong");
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
        }
        }
        if (isDeleted) {
            return 1;
        } else {
            return -1;
        }
}
    public boolean checkTrangThai(String maNV) {
    PreparedStatement sttm = null;
    ResultSet rs = null;
    boolean trangThai = false;
    if (openConnection()) {
        try {
            String sSQL = "SELECT TrangThai FROM nhanvien WHERE MaNhanVien = ?";
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, maNV);
            rs = sttm.executeQuery();
            
            if (rs.next()) {
                trangThai = rs.getBoolean("TrangThai");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }
    
    return trangThai;
}
    public int update(NhanVienDTO nvNew) {
    if (openConnection()) {
        try {
            PreparedStatement sttm = null;
            String sSQL = "UPDATE `nhanvien` SET `TenNhanVien`=?, `SoDienThoai`=?, `DiaChi`=?, `GioiTinh`=?, `NgaySinh`=?, `Luong`=?, `ChucVu`=?, `TrangThai`=? WHERE `MaNhanVien`=?";
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, nvNew.getTenNV());
            sttm.setString(2, nvNew.getPhone());
            sttm.setString(3, nvNew.getDiaChi());
            sttm.setBoolean(4, nvNew.isGioiTinh());
            sttm.setString(5, date_format.format(nvNew.getNgaySinh()));
            sttm.setFloat(6, (float) nvNew.getLuong());
            sttm.setBoolean(7, nvNew.isChucVu());
            sttm.setBoolean(8, nvNew.isTrangThai());
            sttm.setString(9, nvNew.getMaNV());
            
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update thành công");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return -1;
}
     public NhanVienDTO find(String maNV){
         if(openConnection()) {
             try {
                PreparedStatement sttm = null;
                ResultSet rs=null;
                NhanVienDTO nv = new NhanVienDTO();
                String sSQL="SELECT * FROM nhanvien WHERE MaNhanVien = ?";
            
            sttm=con.prepareStatement(sSQL);
            sttm.setString(1, maNV);
           rs=sttm.executeQuery();
                sttm.setString(1, maNV);
            while(rs.next()){
                
                 nv.setMaNV(rs.getString(1));
                 nv.setTenNV(rs.getString(2));
                 nv.setPhone(rs.getString(3));
                 nv.setDiaChi(rs.getString(4));
                 nv.setGioiTinh(rs.getBoolean(5));
                 nv.setNgaySinh(rs.getDate(6));
                 nv.setLuong((double)rs.getFloat(7));
                 nv.setChucVu(rs.getBoolean(8));
                 nv.setTrangThai(rs.getBoolean(9));
                return nv;
                
            }
             } catch (Exception e) {
             
             }finally{
            try { 
                con.close();
            } catch (Exception e) {
            }
        }
         }
        return null;
    }
     public ArrayList<NhanVienDTO> search(String maNV){
        ArrayList<NhanVienDTO> lsSearch = new ArrayList<>();
        PreparedStatement sttm = null;
        ResultSet rs=null;
         NhanVienDTO nv = new NhanVienDTO();
         if(openConnection()) {
             try {
             String sSQL="SELECT * FROM nhanvien WHERE MaNhanVien = ?";
           
            sttm=con.prepareStatement(sSQL);
            sttm.setString(1, maNV);
           rs=sttm.executeQuery();
                sttm.setString(1, maNV);
            while(rs.next()){
                 nv.setMaNV(rs.getString(1));
                 nv.setTenNV(rs.getString(2));
                 nv.setPhone(rs.getString(3));
                 nv.setDiaChi(rs.getString(4));
                 nv.setGioiTinh(rs.getBoolean(5));
                 nv.setNgaySinh(rs.getDate(6));
                 nv.setLuong((double)rs.getFloat(7));
                 nv.setChucVu(rs.getBoolean(8));
                 nv.setTrangThai(rs.getBoolean(9));
                    lsSearch.add(nv);
                
            }
             } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try { 
                con.close();
            } catch (Exception e) {
            }
        }
         }

        return lsSearch;
    }
     public void xoaAll(){
        Statement sttm = null;
        ResultSet rs = null;
           ArrayList<NhanVienDTO> ds = new ArrayList<>();
           if(openConnection()) {
                       try {
             String sSQL="DELETE FROM nhanvien";
            
            sttm=con.createStatement();
            sttm.executeUpdate(sSQL);
            
        } catch (Exception e) {
             System.out.println("Error"+e.toString());
        }finally{
            try { 
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
           }

     }
    
     
}
