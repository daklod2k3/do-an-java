/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets.Classes;

import DAO.conndb;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class NhanVien extends conndb{
    private String maNhanVien;
    private String tenNhanVien;
    private String sdt;
    private String diaChi;
    private boolean gioiTinh;
    private Date ngaySinh;
    private float luong;
    private boolean trangThai;
    public NhanVien() {
        
    }
    public NhanVien(String maNhanVien, String tenNhanVien, String sdt, String diaChi, boolean gioiTinh, Date ngaySinh, float luong, boolean trangThai) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.luong = luong;
        this.trangThai = trangThai;
    }
    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> arr = new ArrayList<>();
            if(openConnection()) {
                try {
                    String sql = "SELECT * FROM nhanvien";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()) {
                        NhanVien nv = new NhanVien();
                        nv.setMaNhanVien(rs.getString("MaNhanVien"));
                        nv.setTenNhanVien(rs.getString("TenNhanVien"));
                        nv.setSdt(rs.getString("SoDienThoai"));
                        nv.setDiaChi(rs.getString("DiaChi"));
                        nv.setNgaySinh(rs.getDate("NgaySinh"));
                        nv.setLuong(rs.getFloat("Luong"));
                        nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                        nv.setTrangThai(rs.getBoolean("TrangThai"));
                        arr.add(nv);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    closeConnection();
                }
        }
        return arr;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
