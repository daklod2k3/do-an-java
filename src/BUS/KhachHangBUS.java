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
    public boolean add(KhachHangDTO kh){
        return khachHangDAO.add(kh);
    }
    public boolean update(KhachHangDTO kh){
        return khachHangDAO.update(kh);
    }
    public boolean delete(KhachHangDTO Makh){
        return khachHangDAO.delete(toString());
    }
     public ArrayList<KhachHangDTO> getALL() {
        return (ArrayList<KhachHangDTO>) khachHangDAO.getALL();
    }
      public ArrayList<KhachHangDTO> getAll() {
        return (ArrayList<KhachHangDTO>) khachHangDAO.getALL();
    }
}
