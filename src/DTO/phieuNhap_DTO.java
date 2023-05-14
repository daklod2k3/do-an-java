/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class phieuNhap_DTO {
    private String maPhieuNhap;
    private String maNCC;
    private String maNhanVien;
    private float tongTien;
    private Date ngayNhap;
    private boolean trangThai;

    public phieuNhap_DTO() {
    }

    public phieuNhap_DTO(String maPhieuNhap, String maNCC, String maNhanVien, float tongTien, Date ngayNhap, boolean trangThai) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNCC = maNCC;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
