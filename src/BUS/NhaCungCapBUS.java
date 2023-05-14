/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhaCungCapBUS {

    public ArrayList<NhaCungCapDTO> dsncc;

    public NhaCungCapBUS() {
    }
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();

    public void loadNCC() {
        dsncc = new ArrayList<>();
        dsncc = nccDAO.getAllNCC();
    }

    public ArrayList<NhaCungCapDTO> getdsncc() {
        return dsncc;
    }

    public boolean hasNCC(String maNCC) {
        for (NhaCungCapDTO ncc : dsncc) {
            if (ncc.getMaNCC().equals(maNCC)) {
                return true;
            }
        }
        return false;
    }
    public String addNCC(NhaCungCapDTO ncc){
        if(hasNCC(ncc.getMaNCC()))
            return "Mã đã tồn tại";
        if(nccDAO.addNCC(ncc))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delNCC(String maNCC){
        if(nccDAO.delNCC(maNCC))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    public String updateNCC(NhaCungCapDTO ncc){
        if(nccDAO.updateNCC(ncc))
            return "Cập nhật thành công";
        return "Cập nhật thất bại";
    }
     public void ImportExcelDatabase(File file){
        nccDAO.ImportExcelDatabase(file);
        
    }
}
