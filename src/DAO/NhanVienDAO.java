/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DatabaseHelper;
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
public class NhanVienDAO {
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
    
    public int add(NhanVienDTO nv ){
        
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="insert into NhanVien(MaNV,TenNV,SDT,DiaChi,GioiTinh,NgaySinh,Luong,ChucVu,TrangThai) values(?,?,?,?,?,?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1, nv.getMaNV() );
            sttm.setString(2, nv.getTenNV());
            sttm.setString(3, nv.getPhone());
            sttm.setString(4, nv.getDiaChi());
            sttm.setBoolean(5,nv.isGioiTinh() );
            sttm.setString(6, date_format.format(nv.getNgaySinh()));
            sttm.setFloat(7, (float) nv.getLuong());
            sttm.setBoolean(8, nv.isChucVu());
            sttm.setBoolean(9, nv.isTrangThai());
            if(sttm.executeUpdate()>0){
                System.out.println("Add thanh cong ");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try { 
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    public ArrayList<NhanVienDTO> getall(){
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
             String sSQL="select * from NhanVien";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.createStatement();
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
        } catch (Exception e) {
        }
        return ds;
    }
    public int delete(String maNV) {
    Connection conn = null;
    PreparedStatement sttm = null;
    boolean isDeleted = false;
    try {
        // Xóa các tài khoản liên quan đến nhân viên
        String sSQL1 = "update taiKhoan set TrangThai = 0 where MaNV = ?";
        conn = DatabaseHelper.getDBConnect();
        sttm = conn.prepareStatement(sSQL1);
        sttm.setString(1, maNV);
        sttm.executeUpdate();

        // Xóa nhân viên
        String sSQL2 = "update NhanVien set TrangThai = 0 where MaNV = ?";
        sttm = conn.prepareStatement(sSQL2);
        sttm.setString(1, maNV);
        if (sttm.executeUpdate() > 0) {
            System.out.println("Xoa thanh cong");
            isDeleted = true;
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.toString());
    } finally {
        try {
            sttm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    if (isDeleted) {
        return 1;
    } else {
        return -1;
    }
}
     public int update(NhanVienDTO nvNew){
       Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="update  NhanVien set TenNV=?,SDT=?,DiaChi=?,GioiTinh=?,NgaySinh=?,Luong=?,ChucVu=?,TrangThai=? where MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1, nvNew.getTenNV());
            sttm.setString(2, nvNew.getPhone());
            sttm.setString(3, nvNew.getDiaChi());
            sttm.setBoolean(4, nvNew.isGioiTinh());
            sttm.setString(5, date_format.format(nvNew.getNgaySinh()));
            sttm.setFloat(6, (float) nvNew.getLuong());
            sttm.setBoolean(7, nvNew.isChucVu());
            sttm.setBoolean(8, nvNew.isTrangThai());
            sttm.setString(9, nvNew.getMaNV());

            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong ");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try { 
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
     public NhanVienDTO find(String maNV){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs=null;
         NhanVienDTO nv = new NhanVienDTO();
        try {
            String sSQL="select * from NhanVien where MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
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
            System.out.println("Error"+e.toString());
        }finally{
            try { 
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
     public ArrayList<NhanVienDTO> search(String maNV){
        ArrayList<NhanVienDTO> lsSearch = new ArrayList<>();
         Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs=null;
         NhanVienDTO nv = new NhanVienDTO();
        try {
            String sSQL="select * from NhanVien where MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
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
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return lsSearch;
    }
     public void xoaAll(){
         Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
           ArrayList<NhanVienDTO> ds = new ArrayList<>();
        try {
             String sSQL="delete  from NhanVien";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.createStatement();
            sttm.executeUpdate(sSQL);
            
        } catch (Exception e) {
             System.out.println("Error"+e.toString());
        }finally{
            try { 
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
     }
    
     
}
