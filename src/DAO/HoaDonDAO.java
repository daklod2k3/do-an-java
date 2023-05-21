package DAO;

import DTO.ChiTietHD;
import DTO.HoaDon;
import MyCustom.MyDialog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HoaDonDAO {

    private String table_key = "hoadon";
    private String mahd_key = "MaHoaDon";
    private String tong_key = "TongTien";
    private String date_key = "NgayLap";
    private String status_key = "TrangThai";
    private String manv_key = "MaNhanVien";
    private String makh_key = "MaKhachHang";
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

    public boolean insert(HoaDon hd) throws SQLException{
        String sql = "INSERT INTO hoadon VALUES(?,?,?,?,?,?)";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
//        prset.setString(1, table_key);
        prset.setString(1, hd.getMAHD());
        prset.setFloat(2, hd.getTongTien());
        prset.setDate(3, hd.getNgayLap());
        prset.setInt(4, hd.getStatus());
        prset.setString(5, hd.getMANV());
        prset.setString(6, hd.getMAKH());
        return prset.executeUpdate() >= 1;
    }

    public boolean update(HoaDon hd) throws  SQLException{
        String sql = "UPDATE hoadon SET ?=?,?=?,?=?,?=?,?=? WHERE ?=?";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
//        prset.setString(1, table_key);
        prset.setString(1, mahd_key);
        prset.setString(3, tong_key);
        prset.setString(5, date_key);
        prset.setString(7, status_key);
        prset.setString(9, manv_key);
        prset.setString(11, makh_key);
        prset.setString(2, hd.getMAHD());
        prset.setFloat(4, hd.getTongTien());
        prset.setDate(6, hd.getNgayLap());
        prset.setInt(8, hd.getStatus());
        prset.setString(11, hd.getMANV());
        prset.setString(13, hd.getMAKH());
        return prset.executeUpdate() >= 1;
    }

    public boolean delete(HoaDon hd) throws SQLException {
        hd.setStatus(0);
        return update(hd);
    }



    public HoaDon getById(String id) throws SQLException{
        String sql = "SELECT * FROM hoadon WHERE MaHoaDon=?";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
        prset.setString(1, id);

        ResultSet rs = prset.executeQuery();
        if (rs == null) return null;
        while (rs.next()){
            HoaDon hd = new HoaDon();
            hd.setMAHD(rs.getString(mahd_key));
            hd.setMAKH(rs.getString(makh_key));
            hd.setMANV(rs.getString(manv_key));
            hd.setTongTien(rs.getFloat(tong_key));
            hd.setNgayLap(rs.getDate(date_key));
            hd.setStatus(rs.getInt(status_key));
            return hd;
        }
        return null;
    }

}
