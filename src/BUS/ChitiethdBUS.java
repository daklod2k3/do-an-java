package BUS;

import DAO.ChitietHDDAO;
import DTO.ChiTietHD;
import GUI.MainMenu;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ChitiethdBUS {
    private List<ChiTietHD> list;
    private ChitietHDDAO dao;


    public ChitiethdBUS(){
//        hoadonList = new ArrayList<>();
        dao = new ChitietHDDAO();
        updateList();
    }

    public void updateList(){
        try {
            list = dao.getAll();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<ChiTietHD> getFromHoaDonId(String id){
        if (id == null || id.trim().equals(""))
            return null;
        try
        {
            return dao.getListFromMaHD(id);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }



    public void addHD(ChiTietHD item){
        try {
            dao.insert(item);
//            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Thêm hóa đơn thành công", "", JOptionPane.INFORMATION_MESSAGE);
            updateList();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL!" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<ChiTietHD> getList() {
        return list;
    }


}
