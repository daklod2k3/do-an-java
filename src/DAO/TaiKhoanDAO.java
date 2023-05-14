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
import java.util.ArrayList;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

/**
 *
 * @author defaultuser0
 */
public class TaiKhoanDAO {
    ArrayList<TaiKhoanDTO> ls = new ArrayList<>();
    
   public TaiKhoanDTO find(String tenTk){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement sttm = null;
        TaiKhoanDTO tk= new TaiKhoanDTO();
        try {

            String sSQL="select * from TaiKhoan where tentaikhoan=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1,tenTk);
            rs=sttm.executeQuery();
            while(rs.next()){

                NhanVienDTO nv = new NhanVienDTO(rs.getString(4));
                tk.setTenTK(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setTrangThai(true);
                tk.setNv(nv);
                tk.setQuyen(1);
               return tk;

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally{
            try {
                rs.close(); sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

public int checkLogin(String tenTK, String mk) {
    Connection conn = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;
    try {
        String sSQL = "SELECT trangThai FROM taiKhoan WHERE tentaikhoan = ? AND matKhau = ?";
        conn = DatabaseHelper.getDBConnect();
        sttm = conn.prepareStatement(sSQL);
        sttm.setString(1, tenTK);
        sttm.setString(2, mk);
        rs = sttm.executeQuery();
        if (rs.next()) {
            boolean trangThai = rs.getBoolean("trangThai");
            if (trangThai) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.toString());
        return -1;
    } finally {
        try {
            conn.close();
            sttm.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}

public boolean checkTK(String tk) {
    Connection conn = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;
    try {
        conn = DatabaseHelper.getDBConnect();
        String sSQL = "SELECT * FROM TaiKhoan WHERE tentaikhoan=?";
        sttm = conn.prepareStatement(sSQL);
        sttm.setString(1, tk);
        rs = sttm.executeQuery();
        if (rs.next()) {
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (sttm != null) {
                sttm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}
    public boolean checkMaNV(String maNV) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String sSQL = "SELECT MaNV FROM dbo.NhanVien WHERE MaNV = ?";
        conn = DatabaseHelper.getDBConnect();
        ps = conn.prepareStatement(sSQL);
        ps.setString(1, maNV);
        rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}
    public int add(TaiKhoanDTO tk ){
          Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="insert into TaiKhoan (tentaikhoan,matKhau,trangThai,maNV,quyen) values (?,?,?,?,?)";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1,tk.getTenTK() );
            sttm.setString(2, tk.getMatKhau());
            sttm.setBoolean(3, true);
            sttm.setString(4, tk.getNv().getMaNV());
            sttm.setInt(5,1);
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
    public int setPass(TaiKhoanDTO tk ){
          Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="update TaiKhoan set matKhau = ? where tentaikhoan=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1,tk.getMatKhau());
            sttm.setString(2, tk.getTenTK());
            if(sttm.executeUpdate()>0){
                System.out.println("sua thanh cong ");
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
     public int update(TaiKhoanDTO tk ){
          Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="UPDATE taiKhoan SET trangThai = 0 WHERE tentaikhoan IN (SELECT tentaikhoan FROM NhanVien WHERE maNV = ?)";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1,tk.getTenTK() );
            sttm.setString(2, tk.getMatKhau());
            sttm.setBoolean(3, true);
            sttm.setString(4, tk.getNv().getMaNV());
            sttm.setInt(5,1);
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
      public ArrayList<TaiKhoanDTO> getall(){
        ArrayList<TaiKhoanDTO> ds = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
             String sSQL="select * TaiKhoan";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.createStatement();
            rs=sttm.executeQuery(sSQL);
            while(rs.next()){
                TaiKhoanDTO tk = new TaiKhoanDTO();
                NhanVienDTO nv = new NhanVienDTO(rs.getString(4));
                tk.setTenTK(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setTrangThai(rs.getBoolean(3));
                tk.setNv(nv);
                tk.setQuyen(rs.getInt(5));
                ds.add(tk);
            }
        } catch (Exception e) {

        }
        return ds;
    }
    }
    

