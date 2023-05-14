/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.category_DAO;
import DTO.category_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class category_BUS {
    category_DAO c;
    public ArrayList<category_DTO> getAllCategorys() {
        c = new category_DAO();
        return c.getAllCategorys();
    }
    public String addCategory(category_DTO cate) {
        c = new category_DAO();
        if(c.hasCategoryID(cate.getMaLoai())) 
            return "Mã loại đã tồn tại!";
        if(c.hasCategoryName(cate.getTenLoai()))
            return "Tên loại đã tồn tại!";
        if(c.addCategory(cate)) 
            return "Thêm thành công!";
        else 
            return "Thêm thất bại!";
    }
    public String fixCategory(category_DTO cate,String current_maLoai) {
        c = new category_DAO();
        if(c.fixCategory(cate,current_maLoai)) 
            return "Sửa thành công!";
        else 
            return "Sửa thất bại!";
    }
    public String deleteCategory(String maLoai) {
        c = new category_DAO();
        if(c.deleteCategory(maLoai)) 
            return "Xóa thành công!";
        else 
            return "Xóa thất bại!";
    }

}
