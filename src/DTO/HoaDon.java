package DTO;

import java.sql.Date;

public class HoaDon {
    private String MAHD;
    private String MANV;
    private String MAKH;
    private float TongTien;
    private Date NgayLap;
    private int status;

    public HoaDon(){};
    public HoaDon(String MAHD, String MANV, String MAKH, float tongTien, Date ngayLap, int status) {
        this.MAHD = MAHD;
        this.MANV = MANV;
        this.MAKH = MAKH;
        TongTien = tongTien;
        NgayLap = ngayLap;
        this.status = status;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date ngayLap) {
        NgayLap = ngayLap;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
