/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author defaultuser0
 */
public class KhachHangDTO {
    String maKH;
    String tenKH; 
    boolean gioiTinh;
    String diaChi;
    String soDienThoai;
    boolean khachHangTT;
    boolean trangThai;
    public KhachHangDTO() {
    }
    
    public KhachHangDTO(String maKH) {
        this.maKH = maKH;
    }

    public KhachHangDTO(String maKH, String tenKH, boolean gioiTinh, String diaChi, String soDienThoai, boolean khachHangTT, boolean trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.khachHangTT = khachHangTT;
        this.trangThai = trangThai;
    }

    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isKhachHangTT() {
        return khachHangTT;
    }

    public void setKhachHangTT(boolean khachHangTT) {
        this.khachHangTT = khachHangTT;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", khachHangTT=" + khachHangTT + ", trangThai=" + trangThai + '}';
    }

    
}
