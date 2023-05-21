/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author defaultuser0
 */
public class TaiKhoanBUS {
     public ArrayList<TaiKhoanDTO> dstk;

    public TaiKhoanBUS() {
    }
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
     public void loadTK(){
        dstk = new ArrayList<>();
        dstk=tkDAO.getall();
    }
     public boolean hasTK(String tenTK){
        for(TaiKhoanDTO tk : dstk){
            if(tk.getTenTK().equals(tenTK)){
                return true;
            }
        }
        return false;
    }
    public String addTK(TaiKhoanDTO tk ){
        if(hasTK(tk.getTenTK()))
            return "Tài khoản đã tồn tại";
        if(tkDAO.add(tk)==1)
            return "Thêm thành công";
        return "Thêm thất bại";
    }
 
}
