package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDon;
import GUI.MainMenu;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HoaDonBUS {
    private List<HoaDon> hoadonList;
    private HoaDonDAO dao;

    public HoaDonBUS(){
//        hoadonList = new ArrayList<>();
        dao = new HoaDonDAO();
        updateList();
    }

    public void updateList(){
        try {
            hoadonList = dao.getAll();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public HoaDon getHoaDonFromId(String id){
        if (id == null || id.trim().equals(""))
            return null;
        try
        {
            return dao.getById(id);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL " + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String createID(){
        updateList();
        return "HD" + (hoadonList.size() + 1);
    }

    public void addHD(HoaDon hd){
        try {
            dao.insert(hd);
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Thêm hóa đơn thành công", "", JOptionPane.INFORMATION_MESSAGE);
            updateList();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainMenu.currentFrame, "Lỗi SQL!" + e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<HoaDon> getList(){
        return hoadonList;
    }

}
