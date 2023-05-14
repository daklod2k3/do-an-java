/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Anh Huy
 */
public class KhachHangBUS {
      KhachHangDAO khachHangDAO = new KhachHangDAO();
    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();}
    public int add(KhachHangDTO kh){
        return khachHangDAO.add(kh);
    }
    public int update(KhachHangDTO kh){
        return khachHangDAO.update(kh);
    }
    public int delete(KhachHangDTO Makh){
        return khachHangDAO.delete(toString());
    }
     public ArrayList<KhachHangDTO> getALL() {
        return (ArrayList<KhachHangDTO>) khachHangDAO.getALL();
    }
      public KhachHangDTO findByID(KhachHangDTO MaKH) {
        return khachHangDAO.findByID(toString());
    }
}
