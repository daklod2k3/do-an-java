/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import DTO.LoaiDTO;
import DTO.NhanVienDTO;

/**
 *
 * @author defaultuser0
 */
public class LoaiDAO {
    ArrayList<LoaiDTO> ls = new ArrayList<>();



    public int add(LoaiDTO loai ){

        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="insert into loaimathang(maloai, tenloai) values(?,?)";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1, loai.getMaLoai() );
            sttm.setString(2, loai.getTenLoai());
            if(sttm.executeUpdate()>0){
                System.out.println("Add thanh cong ");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    public ArrayList<LoaiDTO> getall(){
        ArrayList<LoaiDTO> ds = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL="select * from loaimathang";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.createStatement();
            rs=sttm.executeQuery(sSQL);
            while(rs.next()){
                LoaiDTO loai = new LoaiDTO();
                loai.setMaLoai(rs.getString(1));
                loai.setTenLoai(rs.getString(2));
                ds.add(loai);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    public int delete(String maloai) {
        Connection conn = null;
        PreparedStatement sttm = null;
        boolean isDeleted = false;
        try {

            String sSQL2 = "delete from loaimathang where maloai = ?";
            sttm = conn.prepareStatement(sSQL2);
            sttm.setString(1, maloai);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xoa thanh cong");
                isDeleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                sttm.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.toString());
            }
        }
        if (isDeleted) {
            return 1;
        } else {
            return -1;
        }
    }
    public int update(LoaiDTO loai){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL="update loaimathang set tenloai=? where MaNV=?";
            conn=DatabaseHelper.getDBConnect();
            sttm=conn.prepareStatement(sSQL);
            sttm.setString(1, loai.getTenLoai());
            sttm.setString(2, loai.getMaLoai());


            if(sttm.executeUpdate()>0){
                System.out.println("update thanh cong ");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }




}
