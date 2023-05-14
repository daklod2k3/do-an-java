
SET time_zone = "+00:07";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Cơ sở dữ liệu: `project_sieuthi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--


CREATE TABLE `chitiethd` (
  `SoLuong` int(10) NOT NULL,
  `status` bit(1) NOT NULL,
  `DonGia` float NOT NULL,
  `MAMH` char(10) NOT NULL,
  `MAHD` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--
-- Bẫy `chitiethd`
--
DELIMITER $$
CREATE TRIGGER `Them_ChiTiet` AFTER INSERT ON `chitiethd` FOR EACH ROW UPDATE `mathang`
SET SoLuong = SoLuong - NEW.SoLuong
WHERE MAMH = NEW.MAMH
$$
DELIMITER ;
-- DELIMITER $$
-- CREATE TRIGGER `Xoa_ChiTiet` AFTER DELETE ON `chitiethd` FOR EACH ROW BEGIN
--  	UPDATE `sanpham`
-- 	SET SoLuong = SoLuong + OLD.SoLuong
-- 	WHERE `mathang`.`mamh` = OLD.mamh;
-- END
-- $$
-- DELIMITER ;
--
-- Cấu trúc bảng cho bảng `hoadon`
--
-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `DonGia` float NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `status` bit(1) NOT NULL,
  `MAPN` char(10) NOT NULL,
  `MAMH` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--
-- Bẫy `phieunhaphang`
--
DELIMITER $$
CREATE TRIGGER `ThemNhapHang` AFTER INSERT ON `chitietphieunhap` FOR EACH ROW UPDATE mathang SET SoLuong = SoLuong + NEW.SoLuong WHERE MAMH = NEW.MAMH
$$
DELIMITER ;
-- --------------------------------------------------------


CREATE TABLE `hoadon` (
  `MAHD` char(10) NOT NULL,
  `TongTien` float NOT NULL,
  `NgayLap` date NOT NULL,
  `status` bit(1) NOT NULL,
  `MANV` char(10) NOT NULL,
  `MAKH` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` char(10) NOT NULL,
  `TEN` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SDT` varchar(50) NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `status` bit(1) NOT NULL,
  `KHThanThiet` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaimathang`
--

CREATE TABLE `loaimathang` (
  `MaLoai` char(10) NOT NULL,
  `TenLoai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mathang`
--

CREATE TABLE `mathang` (
  `MAMH` char(10) NOT NULL,
  `DonViTinh` varchar(50) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGiaNhap` float NOT NULL,
  `DonGiaBan` float NOT NULL,
  `TenMatHang` varchar(100) NOT NULL,
  `status` bit(1) NOT NULL,
  `MaLoai` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` char(10) NOT NULL,
  `TenNCC` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SDT` varchar(50) NOT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` char(10) NOT NULL,
  `TenNhanVien` varchar(100) NOT NULL,
  `SDT` varchar(50) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `NgaySinh` date NOT NULL,
  `Luong` float NOT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `TongTien` float NOT NULL,
  `NgayLap` date NOT NULL,
  `MAPN` char(10) NOT NULL,
  `status` bit(1) NOT NULL,
  `MaNCC` char(10) NOT NULL,
  `MANV` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `username` char(30) NOT NULL,
  `password` char(30) NOT NULL,
  `status` bit(1) NOT NULL,
  `MANV` char(10) NOT NULL,
  `Quyen` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MAMH`,`MAHD`),
  ADD KEY `FK_chitiethd_maHD` (`MAHD`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MAPN`,`MAMH`),
  ADD KEY `FK_chitietphieunhap_maMH` (`MAMH`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`),
  ADD KEY `FK_hoadon_maNV` (`MANV`),
  ADD KEY `FK_hoadon_maKH` (`MAKH`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `loaimathang`
--
ALTER TABLE `loaimathang`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`MAMH`),
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
  ADD PRIMARY KEY (`MANV`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPN`),
  ADD KEY `FK_phieunhap_maNCC` (`MaNCC`),
  ADD KEY `FK_phieunhap_maNV` (`MANV`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FK_taikhoan_maNV` (`MANV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `FK_chitiethd_maHD` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitiethd_maMH` FOREIGN KEY (`MAMH`) REFERENCES `mathang` (`MAMH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_chitietphieunhap_maMH` FOREIGN KEY (`MAMH`) REFERENCES `mathang` (`MAMH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_chitietphieunhap_maPN` FOREIGN KEY (`MAPN`) REFERENCES `phieunhap` (`MAPN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_hoadon_maKH` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_hoadon_maNV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `FK_phieunhap_maNV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_taikhoan_maNV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
