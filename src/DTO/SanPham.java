package DTO;

public class SanPham {
    private String MASP;
    private String MaLoai;
    private String TenSanPham;
    private int SoLuong;
    private float DonGiaNhap;
    private float DonGiaBan;
    private String DonViTinh;
    private int status;

    public SanPham(String MASP, String maLoai, String tenSanPham, int soLuong, float donGiaNhap, float donGiaBan, String donViTinh, int status) {
        this.MASP = MASP;
        MaLoai = maLoai;
        TenSanPham = tenSanPham;
        SoLuong = soLuong;
        DonGiaNhap = donGiaNhap;
        DonGiaBan = donGiaBan;
        DonViTinh = donViTinh;
        this.status = status;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String maLoai) {
        MaLoai = maLoai;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(float donGiaNhap) {
        DonGiaNhap = donGiaNhap;
    }

    public float getDonGiaBan() {
        return DonGiaBan;
    }

    public void setDonGiaBan(float donGiaBan) {
        DonGiaBan = donGiaBan;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        DonViTinh = donViTinh;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
