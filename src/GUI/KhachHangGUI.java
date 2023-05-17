/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Anh Huy
 */
public class KhachHangGUI extends JPanel {
         KhachHangDAO dao = new KhachHangDAO();
           String find = "";
    /**
     * Creates new form KhachHangGUI
     */
    public KhachHangGUI() {
        initComponents();
        tbl_KhachHang.getColumn("Xoá").setCellRenderer(new ButtonRenderer());
        MouseClickBtn();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        refBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        txt_diachi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        rdKo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rdCo = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txt_find = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_makh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_tenkh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();


        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thêm khách hàng");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        refBtn.setBackground(new java.awt.Color(0, 204, 255));
        refBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        refBtn.setForeground(new java.awt.Color(255, 255, 255));
        refBtn.setIcon(new javax.swing.ImageIcon(("/img/Refresh.png"))); // NOI18N
        refBtn.setText("Làm mới");
        refBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(("img/view.png"))); // NOI18N
        jButton1.setText("Danh sách ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(0, 204, 255));
        addBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(("img/Plus.png"))); // NOI18N
        addBtn.setText("Thêm");
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 204, 255));
        updateBtn.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(("img/tools.png"))); // NOI18N
        updateBtn.setText("Sửa");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        buttonGroup2.add(rdKo);
        rdKo.setSelected(true);
        rdKo.setText("Không");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giới tính");

        buttonGroup2.add(rdCo);
        rdCo.setText("Có");

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Khách hàng thân thiết");

        txt_find.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_findCaretUpdate(evt);
            }
        });
        txt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_findActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng");

        jButton2.setBackground(new java.awt.Color(51, 204, 255));
        jButton2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(("img/excel.png"))); // NOI18N
        jButton2.setText("Xuất excel");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(txt_find))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txt_diachi)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(228, 228, 228)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdKo)
                        .addGap(18, 18, 18)
                        .addComponent(rdCo)))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn)
                    .addComponent(updateBtn))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(refBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdKo)
                            .addComponent(rdCo)
                            .addComponent(jLabel6)
                            .addComponent(rdNam)
                            .addComponent(rdNu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn)))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Địa Chỉ", "SĐT", "Khách Hàng Thân Thiết", "Trạng thái", "Xoá"
            }
        ));
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }// </editor-fold>//GEN-END:initComponents

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        int stt = tbl_KhachHang.rowAtPoint(evt.getPoint());
        setModel(dao.getALL().get(stt));
        txt_makh.setEnabled(false);
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if(validateForm()){
        KhachHangDTO kh = getModel();
        if (dao.add(kh)){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTable();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }}
    }//GEN-LAST:event_addBtnActionPerformed

    private void refBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refBtnActionPerformed
        txt_tenkh.setText("");
        txt_makh.setText("");
        txt_makh.setEnabled(true);
        txt_diachi.setText("");
        txt_sdt.setText("");
        rdNam.setSelected(true);
        rdKo.setSelected(true);
        
    }//GEN-LAST:event_refBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        KhachHangDTO kh = getModelUpdate();
        if (dao.update(kh)){
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillTable();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void txt_findCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_findCaretUpdate
        find = txt_find.getText();
        fillTable();
    }//GEN-LAST:event_txt_findCaretUpdate

    private void txt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_findActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_findActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    fillTable1();
    }//GEN-LAST:event_jButton1ActionPerformed

//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        KhachHangDAO bus = new KhachHangDAO();
//        ArrayList<KhachHangDTO> list = bus.getAll();
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("khachhang");
//
//            XSSFRow row = null;
//            XSSFCell cell = null;
//
//            row = sheet.createRow(0);
//
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("STT");
//
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue("Mã khách hàng");
//
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue("Tên khách hàng");
//
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("Giới tính");
//
//            cell = row.createCell(4, CellType.STRING);
//            cell.setCellValue("Số điện thoại");
//
//            cell = row.createCell(5, CellType.STRING);
//            cell.setCellValue("Địa chỉ");
//
//            int i = 1;
//            for (KhachHangDTO kh : list) {
//                row = sheet.createRow(0 + i);
//
//                cell = row.createCell(0, CellType.NUMERIC);
//                cell.setCellValue(i);
//
//                cell = row.createCell(1, CellType.NUMERIC);
//                cell.setCellValue(kh.getMaKH());
//
//                cell = row.createCell(2, CellType.STRING);
//                cell.setCellValue(kh.getTenKH());
//
//                cell = row.createCell(3, CellType.STRING);
//                cell.setCellValue(kh.isGioiTinh());
//
//                cell = row.createCell(4, CellType.STRING);
//                cell.setCellValue(kh.getSoDienThoai());
//
//                cell = row.createCell(5, CellType.NUMERIC);
//                cell.setCellValue(kh.getDiaChi());
//
//                i++;
//            }
//
//            File f = new File("D://khachhang.xlsx");
//            try {
//                FileOutputStream fis = new FileOutputStream(f);
//
//                workbook.write(fis);
//                fis.close();
//                JOptionPane.showMessageDialog(rootPane, "Xuất file thành công: D:/khachhang.xlsx","Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }//GEN-LAST:event_jButton2ActionPerformed
public void fillTable1(){
    DefaultTableModel tblmodel = (DefaultTableModel)tbl_KhachHang.getModel(); // Sử dụng tbl_danhsach thay vì tbl_KhachHang
    tblmodel.setRowCount(0);
    for(KhachHangDTO kh : dao.findByName(find)){
        if(kh.isTrangThai()){ // Chỉ lấy khách hàng đang hoạt động
            Object data [] = new Object[8];
            data[0]=kh.getMaKH();
            data[1]=kh.getTenKH();
            data[2]=kh.isGioiTinh()?"Nam":"Nữ";
            data[3]=kh.getDiaChi();
            data[4]=kh.getSoDienThoai();
            data[5]=kh.isKhachHangTT()?"Khách lẻ":"Khách vip";
            if(kh.isTrangThai()){
                data[6]="Hoạt động";
            }else{
                data[6]="Đã xóa";
            }
            data[7]="X";
            tblmodel.addRow(data);
        }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangGUI().setVisible(true);
            }
        });
    }

public KhachHangDTO getModel(){
        KhachHangDTO kh = new KhachHangDTO();
        kh.setMaKH("KH"+txt_makh.getText());
        kh.setTenKH(txt_tenkh.getText());
        kh.setDiaChi(txt_diachi.getText());
        kh.setSoDienThoai(txt_sdt.getText());
        boolean gt = false;
        if(rdNam.isSelected()){
            gt=true;
        }
        kh.setGioiTinh(gt);
        
        boolean khtt = false;
        if(rdKo.isSelected()){
            khtt=true;
        }
        kh.setKhachHangTT(khtt);
        
        kh.setTrangThai(true);
        return kh;
    }
public KhachHangDTO getModelUpdate(){
        KhachHangDTO kh = new KhachHangDTO();
        kh.setMaKH(txt_makh.getText());
        kh.setTenKH(txt_tenkh.getText());
        kh.setDiaChi(txt_diachi.getText());
        kh.setSoDienThoai(txt_sdt.getText());
        boolean gt = false;
        if(rdNam.isSelected()){
            gt=true;
        }
        kh.setGioiTinh(gt);
        
        boolean khtt = false;
        if(rdKo.isSelected()){
            khtt=true;
        }
        kh.setKhachHangTT(khtt);
        
        kh.setTrangThai(true);
        return kh;
    }
    public void setModel(KhachHangDTO kh){
        txt_makh.setText(kh.getMaKH());
        txt_tenkh.setText(kh.getTenKH());
        txt_diachi.setText(kh.getDiaChi());
        txt_sdt.setText(kh.getSoDienThoai() );
        if(kh.isGioiTinh()){
            rdNam.setSelected(true);
        }
        else rdNu.setSelected(true);
        if(kh.isKhachHangTT()){
            rdKo.setSelected(true);
        }
        else rdCo.setSelected(true);
    }
    public void fillTable(){
        DefaultTableModel tblmodel = (DefaultTableModel)tbl_KhachHang.getModel();
        tblmodel.setRowCount(0);
        for(KhachHangDTO kh : dao.findByName(find)){
            Object data [] = new Object[8];
            data[0]=kh.getMaKH();
            data[1]=kh.getTenKH();
            data[2]=kh.isGioiTinh()?"Nam":"Nữ";
            data[3]=kh.getDiaChi();
            data[4]=kh.getSoDienThoai();
            data[5]=kh.isKhachHangTT()?"Khách lẻ":"Khách vip";
            if(kh.isTrangThai()){
                data[6]="Hoạt động";
            }else{
                data[6]="Đã xóa";
            }
            data[7]="X";
            tblmodel.addRow(data);
        }
    }
    public boolean validateForm(){
        if(txt_makh.getText().isEmpty()|| txt_tenkh.getText().isEmpty()|| 
                txt_diachi.getText().isEmpty()||
                txt_sdt.getText().isEmpty()
                )
            return false;
          try {
        int maKH = Integer.parseInt(txt_makh.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Mã khách hàng phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng chữ cho trường tên NV
    if (!txt_tenkh.getText().matches("^[a-zA-Z ]*$")) {
        JOptionPane.showMessageDialog(this, "Tên khách hàng chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng số cho trường SDT
    if (!txt_sdt.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Số điện thoại phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        return true;
    }
    private void showComfirmRemove() {
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chứ?", "Question", 2) == 0) {
            String maKH = txt_makh.getText();
            if(dao.delete(maKH)){
                JOptionPane.showMessageDialog(this, "Xoá thành công");
            }
            fillTable();
        }
    }
private void MouseClickBtn()
{
   tbl_KhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tbl_KhachHang.rowAtPoint(evt.getPoint());
                int col = tbl_KhachHang.columnAtPoint(evt.getPoint());
                if (row >= 0 && col == 7) {
                    showComfirmRemove();
                    
                }
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCo;
    private javax.swing.JRadioButton rdKo;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JButton refBtn;
    public javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_find;
    public javax.swing.JTextField txt_makh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenkh;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
