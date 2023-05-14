/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chitietPN_BUS;
import DTO.chitietPN_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class chitietPN_GUI {
    chitietPN_BUS chiBUS;
    public boolean addChiTietPN(ArrayList<chitietPN_DTO> chiList) {
        chiBUS = new chitietPN_BUS();
        return chiBUS.addChiTietPN(chiList);
    }
    public ArrayList<chitietPN_DTO> getAllChiTietPN() {
        chiBUS = new chitietPN_BUS();
        return chiBUS.getAllChiTietPN();
    }
}
