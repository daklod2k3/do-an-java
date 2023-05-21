package GUI;

import BUS.ChitiethdBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.product_BUS;
import DAO.NhanVienDAO;
import DTO.*;
import GUI.Component.Variable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExportHoaDonToPDF {
    public static String printPDF(HoaDon hoaDon) throws NullPointerException{

        KhachHangBUS khachHangBUS = new KhachHangBUS();
        ChitiethdBUS chitiethdBUS = new ChitiethdBUS();
        product_BUS productBus = new product_BUS();
        ChiTietHD chiTietHD = new ChiTietHD();

        KhachHangDTO khachHangDTO = null;
        NhanVienDTO nhanVienDTO = null;


        Document document = new Document();


        try {
            PdfWriter.getInstance(document, new FileOutputStream(hoaDon.getMAHD() + ".pdf"));

            document.open();

            BaseFont baseFont = BaseFont.createFont("libs/fonts/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font vietnameseFont = new Font(baseFont, 12);

            // Add invoice information
            Paragraph title = new Paragraph("HÓA ĐƠN", vietnameseFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph invoiceNumber = new Paragraph("Mã hóa đơn: " + hoaDon.getMAHD() , vietnameseFont);
            document.add(invoiceNumber);

            for (KhachHangDTO kh : khachHangBUS.getALL()){
                System.out.println(kh.getMaKH());
                if (kh.getMaKH().equals(hoaDon.getMAKH())){
                    khachHangDTO = kh;
                    break;
                }
            }
            if (khachHangDTO == null)
                throw new NullPointerException();

            for (NhanVienDTO nv : new NhanVienDAO().getall()){
                if (nv.getMaNV().equals(hoaDon.getMANV())){
                    nhanVienDTO = nv;
                    break;
                }
            }
            if (nhanVienDTO == null)
                throw new NullPointerException();

            Paragraph customerName = new Paragraph("Tên khách hàng: " + khachHangDTO.getTenKH(), vietnameseFont);
            document.add(customerName);

            Paragraph employeeName = new Paragraph("Tên nhân viên: " + nhanVienDTO.getTenNV(), vietnameseFont);
            document.add(employeeName);

            Paragraph date = new Paragraph("Ngày lập: " + hoaDon.getNgayLap().toString() , vietnameseFont);
            document.add(date);

            Paragraph empty = new Paragraph(" " , vietnameseFont);
            document.add(empty);

            // Add table
            PdfPTable table = new PdfPTable(5); // Number of columns

            table.setWidthPercentage(100); // Table width as a percentage of the page width
            table.addCell(new Paragraph("ID" , vietnameseFont));
            table.addCell(new Paragraph("Sản phẩm" , vietnameseFont));
            table.addCell(new Paragraph("Đơn giá" , vietnameseFont));
            table.addCell(new Paragraph("Số lượng", vietnameseFont));
            table.addCell(new Paragraph("Thành tiền" , vietnameseFont));
            // Add table rows
            float tong = 0;
            for (ChiTietHD item : chitiethdBUS.getFromHoaDonId(hoaDon.getMAHD())){
                product_DTO sp = productBus.getProduct(item.getMAMH());
                table.addCell(new Paragraph(sp.getMaSP(), vietnameseFont));
                table.addCell(new Paragraph(sp.getTenSP(), vietnameseFont));
                table.addCell(new Paragraph(String.valueOf(item.getDonGia()), vietnameseFont));
                table.addCell(new Paragraph(String.valueOf(item.getSoLuong()), vietnameseFont));
                table.addCell(new Paragraph(String.valueOf(item.getDonGia() * item.getSoLuong()), vietnameseFont));
                tong += item.getDonGia() * item.getSoLuong();
            }

            document.add(table);

            Paragraph lbTong = new Paragraph("Thành tiền: " + tong, vietnameseFont);
            lbTong.setAlignment(Element.ALIGN_RIGHT);
            document.add(lbTong);


            document.close();
            return hoaDon.getMAHD() + ".pdf";
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
