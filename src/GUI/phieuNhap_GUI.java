/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.phieuNhap_BUS;
import BUS.product_BUS;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.category_DTO;
import DTO.chitietPN_DTO;
import DTO.phieuNhap_DTO;
import DTO.product_DTO;
import assets.Classes.NhaCungCap;
import assets.Classes.NhanVien;
import assets.Classes.ProductImportStorage;
import assets.Classes.Validate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author Admin
 */
public class phieuNhap_GUI extends JPanel {
    ArrayList<NhaCungCapDTO> arrNCC;
    ArrayList<chitietPN_DTO> chiTietList;
    DefaultTableModel modelTable;
    DefaultTableModel modelTablePN;
    DefaultTableModel modelTableCTPN;
    private String current_MaSP;
    private String current_TenSP;
    private String current_LoaiSP;
    private int current_soLuongNhapKho;
    private String current_DvTinh;
    private float current_GiaNhap;
    private float current_GiaBan;
    private float current_DonGia;
    phieuNhap_BUS pn = new phieuNhap_BUS();
    /**
     * Creates new form add
     */
    public phieuNhap_GUI() {
        initComponents(); 
        modelTable = (DefaultTableModel)jTable1.getModel();
        modelTablePN = (DefaultTableModel)jTable2.getModel();
        modelTableCTPN = (DefaultTableModel)jTable3.getModel();
        loadForm();
        loadAllPN();
        loadchiTietPN();
        loadSP();
    }
    public void loadForm() {
        loadNCC();
        loadNV();
        loadLoaiSP();
        //Ngày lập phiếu nhập hàng
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateTimeString = dateFormat.format(currentDate);
        jTextField4.setText(dateTimeString);
    }
    public void loadNCC() {
        NhaCungCapBUS ncc = new NhaCungCapBUS();
        ncc.loadNCC();
        arrNCC = new ArrayList<>();
        arrNCC = ncc.dsncc;
        if (arrNCC == null || arrNCC.size() == 0){
            return;
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(int i=0;i<arrNCC.size();i++) {
            // lọc các NCC còn hoạt động
            if(arrNCC.get(i).getTrangThai() == 1) {
                model.addElement(arrNCC.get(i).getMaNCC());
            }
        }
        jTextField12.setText(arrNCC.get(0).getMaNCC());
        jTextField13.setText(arrNCC.get(0).getTenNCC());
        jTextField14.setText(arrNCC.get(0).getDiaChiNCC());
        jTextField15.setText(arrNCC.get(0).getSDT());
        jComboBox2.setModel(model);
    }
    public void loadNV() {
        NhanVienBUS nvBUS = new NhanVienBUS();
        nvBUS.loadNV();
        ArrayList<NhanVienDTO> arr = nvBUS.dsnv;
//        arr = nv.getAllNhanVien();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(int i=0;i<arr.size();i++) {
            // nhân viên có đi làm, lọc bỏ nhân viên nghỉ
            if(arr.get(i).isTrangThai()) { 
                model.addElement(arr.get(i).getMaNV());
            }
        }
        jComboBox3.setModel(model);
    }
    public void loadLoaiSP() {
        // gọi category_GUI để lấy categoryList
        ArrayList<category_DTO> arr = new ArrayList<>();
        arr = new category_GUI().getAllCategorys();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(int i=0;i<arr.size();i++) {
            model.addElement(arr.get(i).getTenLoai());
        }
        jComboBox5.setModel(model);
    }
    public void loadAllPN() {
        modelTablePN.setRowCount(0);
        ArrayList<phieuNhap_DTO> arr = new ArrayList<>();
        arr = pn.getAllPN();
        for(int i=0;i<arr.size();i++) {
            String maPN = arr.get(i).getMaPhieuNhap();
            String maNCC = arr.get(i).getMaNCC();
            String maNV = arr.get(i).getMaNhanVien();
            float tongTien = arr.get(i).getTongTien();
            Date ngayLap = arr.get(i).getNgayNhap();
            Object[] row = {maPN,maNCC,maNV,ngayLap,tongTien};
            modelTablePN.addRow(row);
        }
        jTable2.setModel(modelTablePN);
        
    }
    public void loadSP() {
        if(ProductImportStorage.arrList.size() != 0) {
            for(int i=0;i<ProductImportStorage.arrList.size();i++) {
                modelTable.addRow(ProductImportStorage.arrList.get(i));
            }
            jTable1.setModel(modelTable);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable();
        jTextField16 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new JTable();

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1382, 770));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel6.setText("Mã sản phẩm");

        jLabel7.setText("Tên sản phẩm");

        jTextField7.setToolTipText("");

        jLabel12.setText("Loại sản phẩm");

        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { " " }));

        jLabel8.setText("Số lượng");

        jLabel9.setText("Đơn vị tính");

        jLabel10.setText("Giá nhập");

        jLabel11.setText("Giá bán");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/refresh.png"))); // NOI18N
        jButton6.setText("Làm mới");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/plus.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Nhà cung cấp");

        jLabel15.setText("Mã NCC");

        jLabel16.setText("Tên NCC");

        jLabel17.setText("Địa chỉ");

        jLabel18.setText("Số điện thoại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(23, 23, 23)
                            .addComponent(jTextField15))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(56, 56, 56)
                            .addComponent(jTextField14))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(45, 45, 45)
                            .addComponent(jTextField13))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu nhập"));

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn vị tính", "Giá nhập", "Giá bán", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, Integer.class, String.class, Float.class, Float.class, Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField16.setText("0.0");
        jTextField16.setEnabled(false);

        jLabel14.setText("Tổng tiền");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/printer.png"))); // NOI18N
        jButton1.setText("In phiếu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Mã phiếu nhập");

        jLabel1.setText("Chi nhánh");

        jTextField2.setText("Chi nhánh chính");

        jLabel2.setText("Ngày Nhập");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhân Viên");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/remove.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/refresh.png"))); // NOI18N
        jButton4.setText("Làm mới");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/service.png"))); // NOI18N
        jButton5.setText("Sửa");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(42, 42, 42)
                                .addComponent(jButton4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4)
                                    .addComponent(jComboBox3, 0, 147, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton4))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhập Hàng", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu nhập"));

        jLabel13.setText("Mã phiếu nhập");

        jLabel21.setText("Mã nhà cung cấp");

        jLabel22.setText("Mã nhân viên");

        jLabel23.setText("Ngày lập");

        jLabel24.setText("Tổng tiền");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày lập", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, Integer.class, Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Nhập Hàng", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

//        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jComboBox5.setSelectedIndex(0);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int index = jComboBox2.getSelectedIndex();
        for(int i=0;i<arrNCC.size();i++) {
            // lọc các NCC còn hoạt động
            if(arrNCC.get(i).getTrangThai()==1 && i==index) {
                jTextField12.setText(arrNCC.get(i).getMaNCC());
                jTextField13.setText(arrNCC.get(i).getTenNCC());
                jTextField14.setText(arrNCC.get(i).getDiaChiNCC());
                jTextField15.setText(arrNCC.get(i).getSDT());
            }
        }
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //gọi phương thức validateProduct product_GUI
       product_GUI prodcut = new product_GUI();
       String maSP = jTextField6.getText();
       String tenSP = jTextField7.getText();
       String loaiSP = (String) jComboBox5.getSelectedItem();
       String soLuongNhapKho = jTextField5.getText();
       String dvTinh = jTextField9.getText();
       String giaNhap = jTextField10.getText();
       String giaBan = jTextField11.getText();
       
       float donGia = 0;
       if(prodcut.validateProduct(maSP,tenSP,soLuongNhapKho,dvTinh,giaNhap,giaBan))
       {
            if(Integer.parseInt(soLuongNhapKho) <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
            }
            if(Float.parseFloat(giaNhap) <= 0) {
                JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
            }
            if(Float.parseFloat(giaBan) <= 0) {
                JOptionPane.showMessageDialog(null, "Giá bán không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
            }
            // xử lý trùng mã sản phẩm trong các sản phẩm nhập vào
            int current_row = 0;
            while (current_row < jTable1.getRowCount()) {
                if(maSP.equalsIgnoreCase((String) jTable1.getValueAt(current_row, 0)))
                {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm "+maSP+" đã tồn tại "
                    + "trong đơn hàng nhập vào kho!","Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                current_row++;
            }
            // nhập sản phẩm thành công
            donGia = Float.parseFloat(giaNhap) * Integer.parseInt(soLuongNhapKho);
            // Cập nhật tổng tiền của phiếu nhập            
            float tongTien = Float.parseFloat(jTextField16.getText()) + donGia;
            jTextField16.setText(Float.toString(tongTien));
            // thêm vào table
            Object[] row = {maSP,tenSP,loaiSP,Integer.parseInt(soLuongNhapKho)
                    ,dvTinh,Float.parseFloat(giaNhap),Float.parseFloat(giaBan),donGia};
            modelTable.addRow(row);
            jTable1.setModel(modelTable);

            // thêm vào ProdcutImportStorage
            ProductImportStorage.arrList.add(row);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) {
            int a = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa?",
                "Xóa sản phẩm",JOptionPane.YES_NO_OPTION);
            if(a==JOptionPane.YES_OPTION) {
                int row = jTable1.getSelectedRow();
                // Cập nhật tổng tiền của phiếu nhập
                float donGia = (float)jTable1.getValueAt(row, 7);
                float tongTien = Float.parseFloat(jTextField16.getText()) - donGia;
                
                // xóa khỏi ProdcutImportStorage
                String maSP = jTable1.getValueAt(row, 0).toString();
                for(int i=0;i<ProductImportStorage.arrList.size();i++) {
                    String current_maSP = (String)ProductImportStorage.arrList.get(i)[0];
                    if(current_maSP.equalsIgnoreCase(maSP)) {
                        ProductImportStorage.arrList.remove(i);
                    }
                }
                // xóa trên table
                jTextField16.setText(Float.toString(tongTien));
                modelTable.removeRow(row);
                jTable1.setModel(modelTable);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    public boolean ValidatePhieuNhap(String maPN) {
        if(!Validate.ValidateMaPN(maPN)) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không hợp lệ! Vui lòng nhập đúng định dạng (PNxx)",
                    "Thông báo",JOptionPane.OK_OPTION);
            return false;  
        }
        // kiểm tra tồn tại
        if(pn.hasPhieuNhapID(maPN)) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại!",
                    "Thông báo",JOptionPane.OK_OPTION);
                return false;
        }
        return true;
    }
    public String checkMaLoai(String loaiSP) {
        // check mã loại từ tên loại sp
        category_GUI cateGUI = new category_GUI();
        String maLoai = "";
        ArrayList<category_DTO> cateList = cateGUI.getAllCategorys();
        for(int i=0;i<cateList.size();i++) {
            if(loaiSP.equalsIgnoreCase(cateList.get(i).getTenLoai())) {
                maLoai = cateList.get(i).getMaLoai();
            }
        }
        return maLoai;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // validate phiếu nhập hàng
        String maPN = jTextField17.getText();
        String maNhanVien = (String)jComboBox3.getSelectedItem();
        String maNCC = (String)jComboBox2.getSelectedItem();
        float tongTien = Float.parseFloat(jTextField16.getText());
        String ngayNhapDate = jTextField4.getText();
        if(ValidatePhieuNhap(maPN)) {
            if(jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Chưa có sản phẩm nào!"
                        ,"Thông báo",JOptionPane.YES_OPTION);
                return;
            }
            int row = 0;
            while (row < jTable1.getRowCount()) {
                if(Integer.parseInt(jTable1.getValueAt(row, 3).toString()) == 0)
                {
                    JOptionPane.showMessageDialog(null, "Sản phẩm " + jTable1.getValueAt(row, 0) + 
                        " chưa có số lượng nhập","Thông báo",JOptionPane.YES_OPTION);
                    return;
                }
                row++;
            }
            // submit phieunhap, chitietphieunhap, mathang
                // mặt hàng
            ArrayList<product_DTO> produList = new ArrayList<>();
            int current_row = 0;
            while(current_row < jTable1.getRowCount()) {
                product_DTO product = new product_DTO();
                product.setMaSP((String) jTable1.getValueAt(current_row, 0));
                product.setTenSP((String) jTable1.getValueAt(current_row, 1));
                product.setMaLoai(checkMaLoai((String) jTable1.getValueAt(current_row, 2)));
                product.setLoaiSP((String) jTable1.getValueAt(current_row, 2));
                product.setSoLuong((int) jTable1.getValueAt(current_row, 3));
                product.setDvTinh((String) jTable1.getValueAt(current_row, 4));
                product.setGiaNhap((float) jTable1.getValueAt(current_row, 5));
                product.setGiaBan((float) jTable1.getValueAt(current_row, 6));
                product.setTrangThai(false);
                produList.add(product);
                current_row++;
            }
                // phiếu nhập
            phieuNhap_DTO pn_DTO = new phieuNhap_DTO();
            pn_DTO.setMaPhieuNhap(maPN);
            pn_DTO.setMaNCC(maNCC);
            pn_DTO.setMaNhanVien(maNhanVien);
            pn_DTO.setNgayNhap(new Date());
            pn_DTO.setTongTien(tongTien);
            pn_DTO.setTrangThai(true);
                // chi tiết phiếu nhập
            chitietPN_GUI chiGUI = new chitietPN_GUI();
            ArrayList<chitietPN_DTO> chiList = new ArrayList<>();
            current_row = 0;
            while(current_row < jTable1.getRowCount()) {
                chitietPN_DTO chiTiet = new chitietPN_DTO();
                chiTiet.setMaPN(maPN);
                chiTiet.setMaSP((String) jTable1.getValueAt(current_row, 0));
                chiTiet.setSoLuong((int) jTable1.getValueAt(current_row, 3));
                chiTiet.setDonGia((float) jTable1.getValueAt(current_row, 7));
                chiTiet.setTrangThai(true);
                chiList.add(chiTiet);
                current_row++;
            }
            if(product_GUI.addProduct(produList) && pn.addPhieuNhap(pn_DTO) && chiGUI.addChiTietPN(chiList)) {
                JOptionPane.showMessageDialog(null, "Thành công!"
                        ,"Thông báo",JOptionPane.YES_OPTION);
                clearALL();
                loadAllPN();
                loadchiTietPN();
                //clear ProductImportStorage
                ProductImportStorage.arrList.clear();
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void clearALL() {
        jComboBox5.setSelectedIndex(0);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jTextField17.setText("");
        jTextField16.setText("0.0");
        modelTable.setRowCount(0);
        jTable1.setModel(modelTable);
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearALL();
        // xóa toàn bộ sản phẩm ra khỏi ProductImportStorage
        ProductImportStorage.arrList.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed
    private void loadchiTietPN() {
        chitietPN_GUI chiTiet = new chitietPN_GUI();
        chiTietList = chiTiet.getAllChiTietPN();
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        float tongTien = (float) jTable2.getValueAt(row, 4);
        java.sql.Date date = (java.sql.Date) jTable2.getValueAt(row, 3);
        jTextField1.setText((String)jTable2.getValueAt(row, 0));
        jTextField3.setText((String)jTable2.getValueAt(row, 1));
        jTextField8.setText((String)jTable2.getValueAt(row, 2));
        jTextField18.setText(date.toString());
        jTextField19.setText(Float.toString(tongTien));
        // load các chi tiết phiếu nhập của phiếu nhập tương ứng vào Jtable3
        modelTableCTPN.setRowCount(0);
        String maPN = (String)jTable2.getValueAt(row, 0);
        for(int i=0;i<chiTietList.size();i++) {
            if(maPN.equalsIgnoreCase(chiTietList.get(i).getMaPN())) {
                Object rowCTPN[] = {chiTietList.get(i).getMaPN(),
                chiTietList.get(i).getMaSP(),chiTietList.get(i).getSoLuong(),chiTietList.get(i).getDonGia()};
                modelTableCTPN.addRow(rowCTPN);
            }
        }
        jTable3.setModel(modelTableCTPN);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if(row!=-1) {
            product_GUI prodcut = new product_GUI();
            String maSP = jTextField6.getText();
            String tenSP = jTextField7.getText();
            String loaiSP = (String) jComboBox5.getSelectedItem();
            String soLuongNhapKho = jTextField5.getText();
            String dvTinh = jTextField9.getText();
            String giaNhap = jTextField10.getText();
            String giaBan = jTextField11.getText();
            float donGia = 0;
            // sản phẩm nhập thêm số lượng, chỉ cho phép cập nhật lại số lượng
            product_BUS pBUS = new product_BUS();
            if(pBUS.isExist(current_MaSP)) {
                if(!maSP.equalsIgnoreCase(current_MaSP) || !tenSP.equalsIgnoreCase(current_TenSP)
                  || !loaiSP.equalsIgnoreCase(current_LoaiSP) || !dvTinh.equalsIgnoreCase(current_DvTinh)
                  || Float.parseFloat(giaNhap) != current_GiaNhap || Float.parseFloat(giaBan) != current_GiaBan) {
                    JOptionPane.showMessageDialog(null, "Không được sửa lại các thông tin khác ngoài số lượng!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                if(!Validate.ValidateNumber(soLuongNhapKho) || Integer.parseInt(soLuongNhapKho) <= 0) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Sửa thành công!"
                         ,"Thông báo",JOptionPane.OK_OPTION);
                jTable1.setValueAt(Integer.parseInt(soLuongNhapKho), row, 3);
                donGia = Integer.parseInt(soLuongNhapKho) * current_GiaNhap;
                jTable1.setValueAt(donGia, row, 7);
                // cập nhật lại tổng tiền
                float tongTien = 0;
                 int current_row = 0;
                 while (current_row < jTable1.getRowCount()) {
                     tongTien+= Float.parseFloat(jTable1.getValueAt(current_row, 7).toString());
                     current_row++;
                 }
                 jTextField16.setText(Float.toString(tongTien));
                return;
            }
            if(prodcut.validateProduct(maSP,tenSP,soLuongNhapKho,dvTinh,giaNhap,giaBan))
            {
                if(Integer.parseInt(soLuongNhapKho) <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                if(Float.parseFloat(giaNhap) <= 0) {
                    JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ!1",
                            "Thông báo",JOptionPane.OK_OPTION);
                        return;
                }
                if(Float.parseFloat(giaBan) <= 0) {
                    JOptionPane.showMessageDialog(null, "Giá bán không hợp lệ!1",
                            "Thông báo",JOptionPane.OK_OPTION);
                        return;
                }
                 // xử lý trùng mã sản phẩm trong các sản phẩm nhập vào
                 int current_row = 0;
                 while (current_row < jTable1.getRowCount()) {
                     if(maSP.equalsIgnoreCase((String) jTable1.getValueAt(current_row, 0))
                             && !maSP.equalsIgnoreCase(current_MaSP))
                     {
                         JOptionPane.showMessageDialog(null, "Mã sản phẩm "+maSP+" đã tồn tại "
                         + "trong đơn hàng nhập vào kho!","Thông báo",JOptionPane.OK_OPTION);
                         return;
                     }
                     current_row++;
                 }
                 donGia = Float.parseFloat(giaNhap) * Integer.parseInt(soLuongNhapKho);        
                 jTable1.setValueAt(maSP, row, 0);
                 jTable1.setValueAt(tenSP, row, 1);
                 jTable1.setValueAt(loaiSP, row, 2);
                 jTable1.setValueAt(Integer.parseInt(soLuongNhapKho), row, 3);
                 jTable1.setValueAt(dvTinh, row, 4);
                 jTable1.setValueAt(Float.parseFloat(giaNhap), row, 5);
                 jTable1.setValueAt(Float.parseFloat(giaBan), row, 6);
                 jTable1.setValueAt(donGia, row, 7);
                 JOptionPane.showMessageDialog(null, "Sửa thành công!"
                         ,"Thông báo",JOptionPane.OK_OPTION);
                 float tongTien = 0;
                 current_row = 0;
                 while (current_row < jTable1.getRowCount()) {
                     tongTien+= Float.parseFloat(jTable1.getValueAt(current_row, 7).toString());
                     current_row++;
                 }
                 jTextField16.setText(Float.toString(tongTien));
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTextField6.setText(jTable1.getValueAt(row, 0).toString());
        jTextField7.setText(jTable1.getValueAt(row, 1).toString());
        jComboBox5.setSelectedItem(jTable1.getValueAt(row, 2).toString());
        jTextField5.setText(jTable1.getValueAt(row, 3).toString());
        jTextField9.setText(jTable1.getValueAt(row, 4).toString());
        jTextField10.setText(jTable1.getValueAt(row, 5).toString());
        jTextField11.setText(jTable1.getValueAt(row, 6).toString());
        current_MaSP = jTable1.getValueAt(row, 0).toString();
        current_TenSP = jTable1.getValueAt(row, 1).toString();
        current_LoaiSP = jTable1.getValueAt(row, 2).toString();
        current_soLuongNhapKho = Integer.parseInt(jTable1.getValueAt(row, 3).toString());
        current_DvTinh = jTable1.getValueAt(row, 4).toString();
        current_GiaNhap = Float.parseFloat(jTable1.getValueAt(row, 5).toString());
        current_GiaBan = Float.parseFloat(jTable1.getValueAt(row, 6).toString());
        current_DonGia = Float.parseFloat(jTable1.getValueAt(row, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(product_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new phieuNhap_GUI().setVisible(true);
            }
        });
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JTable jTable2;
    private JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
