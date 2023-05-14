/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author defaultuser0
 */
public class NhanVienDTO {
    String maNV;
    String tenNV;
    String phone;
    String diaChi;
    boolean gioiTinh;
    Date ngaySinh;
    double luong;
    boolean chucVu;
    boolean trangThai;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV) {
        this.maNV = maNV;
    }

    public NhanVienDTO(String maNV, String tenNV, String phone, String diaChi, boolean gioiTinh, Date ngaySinh, double luong, boolean chucVu, boolean trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.phone = phone;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.luong = luong;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getPhone() {
        return phone;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public double getLuong() {
        return luong;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    

  
    public String splitName(String tenNV){
        String name = tenNV.substring(tenNV.lastIndexOf(" ")+1);
        return name;
    }

    
    
}
