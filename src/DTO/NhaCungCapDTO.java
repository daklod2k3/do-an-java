/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class NhaCungCapDTO {
    private String maNCC,tenNCC,SDT,diaChiNCC;
    private int trangThai;

    public NhaCungCapDTO() {
        this.trangThai=1;
    }

    public NhaCungCapDTO(String maNCC, String tenNCC, String SDT, String diaChiNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.SDT = SDT;
        this.diaChiNCC = diaChiNCC;
        this.trangThai = 1;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
