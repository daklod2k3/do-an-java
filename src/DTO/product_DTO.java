/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class product_DTO {
    private String maSP;
    private String tenSP;
    private String maLoai;
    private String loaiSP;
    private int soLuong;
    private String dvTinh;
    private float giaNhap;
    private float giaBan;
    private boolean trangThai;
    public product_DTO() {
        
    }
    public product_DTO(String maSP,String tenSP, String maLoai,String loaiSP,int soLuong,String dvTinh,float giaNhap,float giaBan,boolean trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maLoai = maLoai;
        this.loaiSP = loaiSP;
        this.soLuong = soLuong;
        this.dvTinh = dvTinh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }
    /**
     * @return the giaBan
     */
    public float getGiaBan() {
        return giaBan;
    }

    /**
     * @return the giaNhap
     */
    public float getGiaNhap() {
        return giaNhap;
    }

    /**
     * @return the maSP
     */
    public String getMaSP() {
        return maSP;
    }
    public String getLoaiSP() {
        return loaiSP;
    }


    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }
    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }
    public String getDvTinh() {
        return dvTinh;
    }
    /**
     * @return the trangThai
     */
    public boolean isTrangThai() {
        return trangThai;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    public void setDvTinh(String dvTinh) {
        this.dvTinh = dvTinh;
    }
    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    /**
     * @param giaNhap the giaNhap to set
     */
    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }



}
