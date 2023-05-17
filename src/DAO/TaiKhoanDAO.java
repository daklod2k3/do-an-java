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
import java.util.ArrayList;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

/**
 *
 * @author defaultuser0
 */
public class TaiKhoanDAO extends conndb{
    ArrayList<TaiKhoanDTO> ls = new ArrayList<>();
    
   public TaiKhoanDTO find(String tenTk){
        ResultSet rs = null;
        PreparedStatement sttm = null;
        TaiKhoanDTO tk= new TaiKhoanDTO();
        if(openConnection()) {
            try {
            String sSQL="SELECT * FROM taikhoan WHERE TenTaiKhoan=?";
            sttm=con.prepareStatement(sSQL);
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
                con.close();
            } catch (Exception e) {
            }
        }
        }
        return null;
    }

public int checkLogin(String tenTK, String mk) {
    PreparedStatement sttm = null;
    ResultSet rs = null;
    if(openConnection()) {
        try {
            String sSQL = "SELECT TrangThai FROM taikhoan WHERE TenTaiKhoan = ? AND MatKhau = ?";
        sttm = con.prepareStatement(sSQL);
        sttm.setString(1, tenTK);
        sttm.setString(2, mk);
        rs = sttm.executeQuery();
        if (rs.next()) {
            boolean trangThai = rs.getBoolean("TrangThai");
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
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
    return 1;
}

public boolean checkTK(String tk) {
    PreparedStatement sttm = null;
    ResultSet rs = null;
    boolean exists = false;
    if (openConnection()) {
        try {
            String sSQL = "SELECT * FROM taikhoan WHERE TenTaiKhoan=?";
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, tk);
            rs = sttm.executeQuery();
            if (rs.next()) {
                exists = true;
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
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return exists;
}
   public boolean checkMaNV(String maNV) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean exists = false;
    if (openConnection()) {
        try {
            String sSQL = "SELECT MaNhanVien FROM nhanvien WHERE MaNhanVien = ?";
            ps = con.prepareStatement(sSQL);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            if (rs.next()) {
                exists = true;
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
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return exists;
}
    public int add(TaiKhoanDTO tk) {
    PreparedStatement sttm = null;
    if (openConnection()) {
        try {
            String sSQL = "INSERT INTO `taikhoan`(`TenTaiKhoan`, `MatKhau`, `TrangThai`, `MaNhanVien`, `Quyen`) VALUES (?, ?, ?, ?, ?)";
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, tk.getTenTK());
            sttm.setString(2, tk.getMatKhau());
            sttm.setBoolean(3, true);
            sttm.setString(4, tk.getNv().getMaNV());
            sttm.setInt(5, 1);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Add thanh cong");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sttm != null) {
                    sttm.close();
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return -1;
}
   
  public int setPass(TaiKhoanDTO tk) {
    PreparedStatement sttm = null;
    if (openConnection()) {
        try {
            String sSQL = "UPDATE taikhoan SET MatKhau = ? WHERE TenTaiKhoan = ?";
            sttm = con.prepareStatement(sSQL);
            sttm.setString(1, tk.getMatKhau());
            sttm.setString(2, tk.getTenTK());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Sua thanh cong");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sttm != null) {
                    sttm.close();
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return -1;
}
     public int update(TaiKhoanDTO tk ){
          Connection conn = null;
        PreparedStatement sttm = null;
       if(openConnection()){
           try {
               String sSQL="UPDATE taikhoan SET TrangThai = 0 WHERE TenTaiKhoan IN (SELECT TenTaiKhoan FROM nhanvien WHERE MaNhanVien = ?)";
            
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
           }
       }
        return -1;
    }
      public ArrayList<TaiKhoanDTO> getall(){
        ArrayList<TaiKhoanDTO> ds = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        if(openConnection()){
            try {
            String sSQL="select * taikhoan";
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
        }
        return ds;
    }
      
    }
    

