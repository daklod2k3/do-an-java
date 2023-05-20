/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets.Classes;

import DAO.conndb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Admin
 */
public class NhaCungCap extends conndb{
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sdt;
    private boolean trangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt, boolean trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    public ArrayList<NhaCungCap> getAllNCC() {
        ArrayList<NhaCungCap> arr = new ArrayList<>();
            if(openConnection()) {
                try {
                    String sql = "SELECT * FROM nhacungcap";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()) {
                        NhaCungCap ncc = new NhaCungCap();
                        ncc.setMaNCC(rs.getString("MaNCC"));
                        ncc.setTenNCC(rs.getString("TenNCC"));
                        ncc.setSdt(rs.getString("SoDienThoai"));
                        ncc.setDiaChi(rs.getString("DiaChi"));
                        ncc.setTrangThai(rs.getBoolean("TrangThai"));
                        arr.add(ncc);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    closeConnection();
                }
        }
        return arr;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
