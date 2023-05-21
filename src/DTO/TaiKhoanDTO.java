/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DTO.NhanVienDTO;

/**
 *
 * @author defaultuser0
 */
public class TaiKhoanDTO {
    String tenTK;
    String matKhau;
    boolean trangThai;
    NhanVienDTO nv ;
    int quyen;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String tenTK, String matKhau, boolean trangThai, NhanVienDTO nv, int quyen) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.nv = nv;
        this.quyen = quyen;
    }

    public String getTenTK() {
        return tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public NhanVienDTO getNv() {
        return nv;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setNv(NhanVienDTO nv) {
        this.nv = nv;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
    
}
