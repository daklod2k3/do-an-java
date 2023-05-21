package DAO;

import DTO.ChiTietHD;
import DTO.HoaDon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChitietHDDAO {
    private String mahd_key = "MaHoaDon";
    private String masp_key = "MaMatHang";
    private String dongia_key = "DonGia";
    private String soluong_key = "SoLuong";
    private String trangthai_key = "TrangThai";

    public List<ChiTietHD> getAll() throws SQLException {
        List<ChiTietHD> list = new ArrayList<>();
        Statement state = DBCONNECT.getState();
        ResultSet rs = state.executeQuery("SELECT * FROM chitietdonhang");
        if (rs == null) return null;
        while (rs.next()){
            ChiTietHD cthd = new ChiTietHD();
            cthd.setMAHD(rs.getString(mahd_key));
            cthd.setSoLuong(rs.getInt(soluong_key));
            cthd.setStatus(rs.getBoolean(trangthai_key));
            cthd.setDonGia(rs.getFloat(dongia_key));
            cthd.setMAMH(rs.getString(masp_key));
            list.add(cthd);
        }
        return list;
    }

    public List<ChiTietHD> getListFromMaHD(String id) throws SQLException{
        List<ChiTietHD> list = new ArrayList<>();
        String sql = "SELECT * FROM chitietdonhang WHERE MaHoaDon=?";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
        prset.setString(1, id);

        ResultSet rs = prset.executeQuery();
        if (rs == null) return null;
        while (rs.next()){
            ChiTietHD cthd = new ChiTietHD();
            cthd.setMAHD(rs.getString(mahd_key));
            cthd.setSoLuong(rs.getInt(soluong_key));
            cthd.setStatus(rs.getBoolean(trangthai_key));
            cthd.setDonGia(rs.getFloat(dongia_key));
            cthd.setMAMH(rs.getString(masp_key));
            list.add(cthd);
        }
        return list;
    }

    public boolean insert(ChiTietHD item) throws SQLException{
        String sql = "INSERT INTO chitietdonhang VALUES(?,?,?,?,?)";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
//        prset.setString(1, table_key);
        prset.setInt(1, item.getSoLuong());
        prset.setBoolean(2, item.getStatus());
        prset.setFloat(3, item.getDonGia());
        prset.setString(4, item.getMAMH());
        prset.setString(5, item.getMAHD());
        return prset.executeUpdate() >= 1;
    }

    public boolean update(ChiTietHD item) throws  SQLException{
        String sql = "UPDATE chitietdonhang SET ?=?,?=?,?=?,?=? WHERE ?=? AND ?=?";
        PreparedStatement prset = DBCONNECT.getConn().prepareStatement(sql);
//        prset.setString(1, table_key);
        prset.setString(1, trangthai_key);
        prset.setString(3, dongia_key);
        prset.setString(5, soluong_key);
        prset.setString(7, mahd_key);
        prset.setString(9, masp_key);
        prset.setBoolean(2, item.getStatus());
        prset.setString(4, item.getMAMH());
        prset.setInt(6, item.getSoLuong());
        prset.setString(8, item.getMAHD());
        prset.setString(10, item.getMAMH());
        return prset.executeUpdate() >= 1;
    }

    public boolean delete(ChiTietHD item) throws SQLException {
        item.setStatus(false);
        return update(item);
    }

//    public boolean get

}
