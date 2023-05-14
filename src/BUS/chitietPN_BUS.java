/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chitietPN_DAO;
import DTO.chitietPN_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class chitietPN_BUS {
    chitietPN_DAO chiDAO;
    public boolean addChiTietPN(ArrayList<chitietPN_DTO> chiList) {
        chiDAO = new chitietPN_DAO();
        return chiDAO.addChiTietPN(chiList);
    }
    public ArrayList<chitietPN_DTO> getAllChiTietPN() {
        chiDAO = new chitietPN_DAO();
        return chiDAO.getAllChiTietPN();
    }
}
