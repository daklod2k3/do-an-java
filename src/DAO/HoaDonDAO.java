package DAO;

import DTO.HoaDon;
import MyCustom.MyDialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoaDonDAO {
    private List<HoaDon> hoaDons = new ArrayList<>();

    public List<HoaDon> getAll() throws SQLException {
        List<HoaDon> rs = new ArrayList<>();
        ResultSet query = DBCONNECT.getResult("SELECT * FROM hoadon");
        while (query.next()){
            HoaDon tmp = new HoaDon(
                    query.getString("MaHoaDon"),
                    query.getString("MaNhanVien"),
                    query.getString("MaKhachHang"),
                    query.getFloat("TongTien"),
                    query.getDate("NgayLap"),
                    query.getInt("TrangThai")
            );
            rs.add(tmp);
        }
        return rs;
    }

//    public HoaDon getById(){
//        try {
//            Statement state = DBCONNECT.getState();
//
//        }
//    }

}
