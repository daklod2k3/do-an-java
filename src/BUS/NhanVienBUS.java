/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author defaultuser0
 */
public class NhanVienBUS {
    public ArrayList<NhanVienDTO> dsnv;

    public NhanVienBUS() {
    }
    NhanVienDAO nvDAO = new NhanVienDAO();
    public void loadNV(){
        dsnv = new ArrayList<>();
        dsnv=nvDAO.getall();
    }
    public boolean hasNV(String maNV){
        for(NhanVienDTO nv : dsnv){
            if(nv.getMaNV().equals(maNV)){
                return true;
            }
        }
        return false;
    }
    public String addNV(NhanVienDTO nv) throws SQLException{
        if(hasNV(nv.getMaNV()))
            return "Mã nhân viên đã tồn tại";
        if(nvDAO.add(nv)==1)
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    public String delNV(String maNV){
         if(nvDAO.delete(maNV)==1)
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    public String updateNV(NhanVienDTO nv){
        if(nvDAO.update(nv)==1)
            return "Cập nhật thành công";
        return "Cập nhật thất bại";
    }
}
