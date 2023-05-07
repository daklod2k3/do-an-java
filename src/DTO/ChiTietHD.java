package DTO;

public class ChiTietHD {
    private String MAMH;
    private String MAHD;
    private float DonGia;
    private int SoLuong;
    private boolean status;

    public ChiTietHD(String MAMH, String MAHD, float donGia, int soLuong, boolean status) {
        this.MAMH = MAMH;
        this.MAHD = MAHD;
        DonGia = donGia;
        SoLuong = soLuong;
        this.status = status;
    }

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }

    public String getMAHD() {
        return MAHD;
    }

    public void setMAHD(String MAHD) {
        this.MAHD = MAHD;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
