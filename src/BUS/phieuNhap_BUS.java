/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.phieuNhap_DAO;
import DTO.phieuNhap_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class phieuNhap_BUS {
    phieuNhap_DAO pn;
    public ArrayList<phieuNhap_DTO> getAllPN() {
        pn = new phieuNhap_DAO();
        return pn.getAllPN();
    }
    public boolean hasPhieuNhapID(String id) {
        pn = new phieuNhap_DAO();
        return pn.hasPhieuNhapID(id);
    }
    public boolean addPhieuNhap(phieuNhap_DTO pn_DTO) {
        pn = new phieuNhap_DAO();
        if(pn.addPhieuNhap(pn_DTO)) 
            return true;
        return false;
    }
}
