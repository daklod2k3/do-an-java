-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 11, 2023 lúc 03:58 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project_sieuthi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `SoLuong` int(10) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `DonGia` float NOT NULL,
  `MaMatHang` char(10) NOT NULL,
  `MaHoaDon` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `DonGia` float NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `MaPhieuNhap` char(10) NOT NULL,
  `MaMatHang` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` char(10) NOT NULL,
  `TongTien` float NOT NULL,
  `NgayLap` date NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `MaNhanVien` char(10) NOT NULL,
  `MaKhachHang` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` char(10) NOT NULL,
  `TenKhachHang` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SoDienThoai` varchar(50) NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `KHThanThiet` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaimathang`
--

CREATE TABLE `loaimathang` (
  `MaLoai` char(10) NOT NULL,
  `TenLoai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mathang`
--

CREATE TABLE `mathang` (
  `MaMatHang` char(10) NOT NULL,
  `DonViTinh` varchar(50) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGiaNhap` float NOT NULL,
  `DonGiaBan` float NOT NULL,
  `TenMatHang` varchar(100) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `MaLoai` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` char(10) NOT NULL,
  `TenNCC` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SoDienThoai` varchar(50) NOT NULL,
  `TrangThai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` char(10) NOT NULL,
  `TenNhanVien` varchar(100) NOT NULL,
  `SoDienThoai` varchar(50) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `NgaySinh` date NOT NULL,
  `Luong` float NOT NULL,
  `TrangThai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `TongTien` float NOT NULL,
  `NgayLap` date NOT NULL,
  `MaPhieuNhap` char(10) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `MaNCC` char(10) NOT NULL,
  `MaNhanVien` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` char(30) NOT NULL,
  `MatKhau` char(30) NOT NULL,
  `TrangThai` bit(1) NOT NULL,
  `MaNhanVien` char(10) NOT NULL,
  `Quyen` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`MaMatHang`,`MaHoaDon`),
  ADD KEY `FK_chitietdonhang_maHD` (`MaHoaDon`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`,`MaMatHang`),
  ADD KEY `FK_chitietphieunhap_maMH` (`MaMatHang`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `FK_hoadon_maNV` (`MaNhanVien`),
  ADD KEY `FK_hoadon_maKH` (`MaKhachHang`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Chỉ mục cho bảng `loaimathang`
--
ALTER TABLE `loaimathang`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`MaMatHang`),
  ADD KEY `FK_mathang_maloai` (`MaLoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `FK_phieunhap_maNCC` (`MaNCC`),
  ADD KEY `FK_phieunhap_maNV` (`MaNhanVien`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenTaiKhoan`),
  ADD KEY `FK_taikhoan_maNV` (`MaNhanVien`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `FK_chitietdonhang_maHD` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitietdonhang_maMH` FOREIGN KEY (`MaMatHang`) REFERENCES `mathang` (`MaMatHang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_chitietphieunhap_maMH` FOREIGN KEY (`MaMatHang`) REFERENCES `mathang` (`MaMatHang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitietphieunhap_maPN` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_hoadon_maKH` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_hoadon_maNV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `mathang`
--
ALTER TABLE `mathang`
  ADD CONSTRAINT `FK_mathang_maloai` FOREIGN KEY (`MaLoai`) REFERENCES `loaimathang` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_phieunhap_maNCC` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_phieunhap_maNV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_taikhoan_maNV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
