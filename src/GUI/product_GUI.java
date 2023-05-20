
package GUI;

import BUS.product_BUS;
import DAO.product_DAO;
import DTO.category_DTO;
import DTO.product_DTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import GUI.phieuNhap_GUI;
import assets.Classes.ProductImportStorage;
import assets.Classes.Validate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.formdev.flatlaf.FlatLightLaf;

public class product_GUI extends JPanel {
    product_BUS p = new product_BUS();
    DefaultTableModel model;
    private String current_maSP;
    ArrayList<product_DTO> arr = new ArrayList<>();
    public product_GUI() {
        initComponents();
//        jTable1.getSel
        model = (DefaultTableModel)jTable1.getModel();
        loadAll();
    }
    public void loadAll() {
        loadProductList();
        loadCategory(); //load những danh mục trang thái = 1
        loaddvTinh();
    }
    public void loadProductList() {
            model.setRowCount(0);
            arr = p.getAllProducts();
            for(int i=0;i<arr.size();i++) {
                String maSP = arr.get(i).getMaSP();
                String tenSP = arr.get(i).getTenSP();
                String loaiSP = arr.get(i).getLoaiSP();
                int soLuong = arr.get(i).getSoLuong();
                String dvTinh = arr.get(i).getDvTinh();
                Float giaNhap = arr.get(i).getGiaNhap();
                Float giaBan = arr.get(i).getGiaBan();
                Boolean trangThai = arr.get(i).isTrangThai();
                Object[] row = {maSP,tenSP,loaiSP,soLuong,dvTinh,giaNhap,giaBan,trangThai};
                model.addRow(row);
            }
            jTable1.setModel(model);
    }
    public void filterProduct() {
        model.setRowCount(0);
        arr = p.getAllProducts();
        filterCategory();
        filterDvTinh();
        filterPrice();
        filterStatus();
        filterSearch();
        if(arr.size() !=0) {
            for(int i=0;i<arr.size();i++) {
                String maSP = arr.get(i).getMaSP();
                String tenSP = arr.get(i).getTenSP();
                String loaiSP = arr.get(i).getLoaiSP();
                int soLuong = arr.get(i).getSoLuong();
                String dvTinh = arr.get(i).getDvTinh();
                Float giaNhap = arr.get(i).getGiaNhap();
                Float giaBan = arr.get(i).getGiaBan();
                Boolean trangThai = arr.get(i).isTrangThai();
                Object[] row = {maSP,tenSP,loaiSP,soLuong,dvTinh,giaNhap,giaBan,trangThai};
                model.addRow(row);
            }
        }
        jTable1.setModel(model);
    }
    public void filterCategory() {
        if(jComboBox1.getSelectedIndex() == 0) {
            
        } else {
            String loaiSP = jComboBox1.getSelectedItem().toString();
            int i=0;
            while(i<arr.size()) {
                if(!loaiSP.equalsIgnoreCase(arr.get(i).getLoaiSP()))
                {
                    arr.remove(arr.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void filterDvTinh() {
        if(jComboBox2.getSelectedIndex() == 0) {
            
        } else {
            if(jComboBox2.getSelectedIndex() != -1) {
                String dvTinh = jComboBox2.getSelectedItem().toString();
                int i=0;
                while(i<arr.size()) {
                    if(!dvTinh.equalsIgnoreCase(arr.get(i).getDvTinh()))
                    {
                        arr.remove(arr.get(i));
                    } else {
                        i++;
                    }
                }
            }

        }
    }
    public void filterStatus() {
        if(jComboBox3.getSelectedIndex() == 0) {
            
        } else {
            String tmp = jComboBox3.getSelectedItem().toString();
            boolean trangThai = false;
            if(tmp.equalsIgnoreCase("Hiện")) {
                trangThai = true;
            }
            int i=0;
            while(i<arr.size()) {
                if(arr.get(i).isTrangThai() != trangThai)
                {
                    arr.remove(arr.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public void filterPrice() {
        if(jComboBox4.getSelectedIndex() == 0) {
            
        } else {
            String mucGia = jComboBox4.getSelectedItem().toString();
            if(jComboBox4.getSelectedIndex() == 1) {
                int i=0;
                while(i<arr.size()) {
                    if(Float.compare(arr.get(i).getGiaBan(), 10000) < 0 
                            || Float.compare(arr.get(i).getGiaBan(), 100000) > 0)
                    {
                        arr.remove(arr.get(i));
                        
                    } else {
                        i++;
                    }
                }
                return;
            }
            if(jComboBox4.getSelectedIndex() == 2) {
                int i=0;
                while(i<arr.size()) {
                    if(Float.compare(arr.get(i).getGiaBan(), 100000) < 0 ||
                            Float.compare(arr.get(i).getGiaBan(), 500000) > 0)
                    {
                        arr.remove(arr.get(i));
                    } else {
                        i++;
                    }
                }
                return;
            }
            if(jComboBox4.getSelectedIndex() == 3) {
                int i=0;
                while(i<arr.size()) {
                    if(Float.compare(arr.get(i).getGiaBan(), 500000) < 0 ||
                            Float.compare(arr.get(i).getGiaBan(), 1000000) > 0)
                    {
                        arr.remove(arr.get(i));
                    } else {
                        i++;
                    }
                }
                return;
            }
            if(jComboBox4.getSelectedIndex() == 4) {
                int i=0;
                while(i<arr.size()) {
                    if(Float.compare(arr.get(i).getGiaBan(), 1000000) < 0)
                    {
                        arr.remove(arr.get(i));
                    } else {
                        i++;
                    }
                }
                return;
            }

        }
    }
    public void filterSearch(){
        String search = jTextField1.getText();
        if(search.trim().equalsIgnoreCase("")) {
            
        } else {
            int i=0;
            while(i<arr.size()) {
                String str = "";
                if(!arr.get(i).getMaSP().toLowerCase().contains(search.toLowerCase()) && 
                        !arr.get(i).getTenSP().toLowerCase().contains(search.toLowerCase()))
                {
                    arr.remove(arr.get(i));
                } else {
                    i++;
                }
            }
        }
    }
    public boolean validateProduct(String maSP,String tenSP,String soLuong,String dvTinh,String giaNhap,String giaBan) {
        //Validate
        try {
            if(!Validate.ValidateMaSP(maSP)){
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không hợp lệ! Vui lòng nhập đúng định dạng (SPxx)",
                    "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }
        if(p.isExist(maSP)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại!",
                    "Thông báo",JOptionPane.OK_OPTION);
                return false;
        }
        if(!Validate.ValidateName(tenSP)) {
            JOptionPane.showMessageDialog(null, "Tên sản phẩm không hợp lệ!",
                    "Thông báo",JOptionPane.OK_OPTION); 
            return false;
        }
        if(!Validate.ValidateNumber(soLuong)) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không hợp lệ!",
                    "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }
        if(!Validate.ValidateName(dvTinh)) {
            JOptionPane.showMessageDialog(null, "Đơn vị tính không hợp lệ!",
                    "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }
        if(!Float.isFinite(Float.valueOf(giaNhap))) {
            JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ!",
                    "Thông báo",JOptionPane.OK_OPTION);
            return false;
        }
        if(!Float.isFinite(Float.valueOf(giaBan))) {
            JOptionPane.showMessageDialog(null, "Giá bán không hợp lệ!",
                    "Thông báo",JOptionPane.OK_OPTION); 
            return false;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    // phieunhap dùng phương thức này
    // nhận vào một mảng các product từ 1 phieunhap
    public static boolean addProduct(ArrayList<product_DTO> productList) {
        product_BUS p = new product_BUS();
        return p.addProduct(productList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jComboBox2 = new JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jComboBox6 = new JComboBox<>();
        jComboBox5 = new JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1382, 770));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel5.setForeground(new java.awt.Color(153, 153, 153));

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/printer.png"))); // NOI18N
        jButton1.setText("Xuất Excel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/plus.png"))); // NOI18N
        jButton3.setText("Nhập hàng");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/service.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/remove.png"))); // NOI18N
        jButton5.setText("Ẩn");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator4);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/refresh.png"))); // NOI18N
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator5);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/options.png"))); // NOI18N
        jButton8.setText("Danh mục");
        jButton8.setToolTipText("");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Đơn vị tính");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, 0, 116, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTextField1.setToolTipText("nhập mã hoặc tên sản phẩm...");
        jTextField1.setActionCommand("");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.setName(""); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/search.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Trạng thái");
        jLabel4.setToolTipText("");

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "Hiện", "Ẩn" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Loại sản phẩm");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, 0, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Giá");
        jLabel5.setToolTipText("");

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "1x.000đ - 100.000đ", "1xx.000đ - 500.000đ", "5xx.000đ - 1.000.000đ", "Trên 1.000.000đ" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setForeground(new java.awt.Color(153, 153, 153));

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn vị tính", "Giá nhập", "Giá bán", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, Integer.class, String.class, Float.class, Float.class, Boolean.class
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));
        jPanel10.setForeground(new java.awt.Color(153, 153, 153));

        jLabel6.setText("Mã sản phẩm");

        jLabel7.setText("Tên sản phẩm");

        jLabel8.setText("Số lượng bán");

        jLabel9.setText("Đơn vị tính");

        jLabel10.setText("Giá nhập");

        jLabel11.setText("Giá bán");

        jLabel12.setText("Loại sản phẩm");

        jLabel13.setText("Trạng thái");

        jTextField3.setToolTipText("");

        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField8.setEnabled(false);

        jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "hiện", "ẩn" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { " " }));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/refresh.png"))); // NOI18N
        jButton6.setText("Làm mới");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/plus.png"))); // NOI18N
        jButton9.setText("Nhập thêm");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(25, 25, 25)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

//        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        filterProduct();
    }//GEN-LAST:event_jComboBox3ActionPerformed
    // loadCategory cho mục loại sản phẩm của thông tin sản phẩm
    // và select vào category của sản phẩm đó
    public void loadCategory(String str) {
        ArrayList<category_DTO> cateList = new ArrayList<>();
        category_GUI cate = new category_GUI();
        cateList = cate.getAllCategorys();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(int i=0;i<cateList.size();i++) {
            model.addElement(cateList.get(i).getTenLoai());
        }
        jComboBox5.setModel(model);
        jComboBox5.setSelectedItem(str);
    }
    // loadCategory cho mục loại sản phẩm để lọc
    public void loadCategory() {
        ArrayList<category_DTO> cateList = new ArrayList<>();
        category_GUI cate = new category_GUI();
        cateList = cate.getAllCategorys();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Tất cả");
        for(int i=0;i<cateList.size();i++) {
            model.addElement(cateList.get(i).getTenLoai());
        }
        jComboBox1.setModel(model);
        jComboBox1.setSelectedIndex(0);
    }
    // loadDvTinh để lọc: không trùng
    public void loaddvTinh() {
        int row = 0;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> arr = new ArrayList<>();
        while(row < jTable1.getRowCount()) {
            if(checkdvTinh(arr,(String)jTable1.getValueAt(row, 4))) {
                arr.add((String)jTable1.getValueAt(row, 4));
            }
            row++;
        }
        model.addElement("Tất cả");
        for(int i=0;i<arr.size();i++) {
            model.addElement(arr.get(i));
        }
        jComboBox2.setModel(model);
    }
    public boolean checkdvTinh(ArrayList<String> arr,String item) {
        if(arr.size() != 0) {
            for(int i=0;i<arr.size();i++) {
            if(arr.get(i).equalsIgnoreCase(item))
                return false;
            }
        }
        return true;
    }
    public void setStatus(boolean b) {
        if(b) {
            jComboBox6.setSelectedItem("hiện");
        } else {
            jComboBox6.setSelectedItem("ẩn");
        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTextField2.setText((String) jTable1.getValueAt(row,0));
        jTextField3.setText((String) jTable1.getValueAt(row,1));
        loadCategory((String)jTable1.getValueAt(row, 2));
        jTextField5.setText(jTable1.getValueAt(row, 3).toString());
        jTextField7.setText((String) jTable1.getValueAt(row, 4));
        jTextField8.setText(jTable1.getValueAt(row, 5).toString());
        jTextField9.setText(jTable1.getValueAt(row, 6).toString());
        setStatus((boolean) jTable1.getValueAt(row, 7));
        current_maSP = (String) jTable1.getValueAt(row, 0);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTextField2.setText((String) jTable1.getValueAt(row,0));
        jTextField3.setText((String) jTable1.getValueAt(row,1));
        loadCategory((String)jTable1.getValueAt(row, 2));
        jTextField5.setText(jTable1.getValueAt(row, 3).toString());
        jTextField7.setText((String) jTable1.getValueAt(row, 4));
        jTextField8.setText(jTable1.getValueAt(row, 5).toString());
        jTextField9.setText(jTable1.getValueAt(row, 6).toString());
        setStatus((boolean) jTable1.getValueAt(row, 7));
        current_maSP = (String) jTable1.getValueAt(row, 0);
    }//GEN-LAST:event_jTable1KeyReleased

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox5.setSelectedIndex(0);
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jComboBox6.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        phieuNhap_GUI a = new phieuNhap_GUI();
        a.setVisible(true);
//        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadAll();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        category_GUI cate = new category_GUI();
        cate.setVisible(true);
        cate.setLocationRelativeTo(null);
        cate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        filterProduct();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    // sửa thông tin sản phẩm
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) {
            String maSP = jTextField2.getText();
            String tenSP = jTextField3.getText();
            String loaiSP = (String)jComboBox5.getSelectedItem();
            String soLuong = jTextField5.getText();
            String dvTinh = jTextField7.getText();
            String giaNhap = jTextField8.getText();
            String giaBan = jTextField9.getText();
            boolean trangThai = false;
            if(jComboBox6.getSelectedIndex() == 0) trangThai = true;
            if(!Validate.ValidateMaSP(maSP)) {
                JOptionPane.showMessageDialog(null, "Mã sản phẩm không hợp lệ! Vui lòng nhập đúng định dạng (SPxx)",
                        "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            // kiểm tra mã sản phẩm có bị trùng với bất cứ sản phẩm nào khác, trừ chính nó (nếu không đổi maSP)
            int row = 0;
            while (row < jTable1.getRowCount()) {
                if(jTable1.getValueAt(row, 0).toString().equalsIgnoreCase(maSP) && 
                    !jTable1.getValueAt(row, 0).toString().equalsIgnoreCase(current_maSP)) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                row++;
            }
            try {
                if(!Validate.ValidateName(tenSP)) {
                JOptionPane.showMessageDialog(null, "Tên sản phẩm không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                return;
                }
                if(!Validate.ValidateNumber(soLuong)) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!",
                            "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }

                if(!Validate.ValidateName(dvTinh)) {
                    JOptionPane.showMessageDialog(null, "Đơn vị tính không hợp lệ!",
                            "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                if(!Float.isFinite(Float.valueOf(giaNhap))|| Float.parseFloat(giaNhap) <= 0) {
                JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                if(!Float.isFinite(Float.valueOf(giaBan)) || Float.parseFloat(giaBan) <= 0) {
                    JOptionPane.showMessageDialog(null, "Giá bán không hợp lệ!",
                            "Thông báo",JOptionPane.OK_OPTION); 
                    return;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            phieuNhap_GUI pn = new phieuNhap_GUI();
            product_DTO proDTO = new product_DTO(maSP, tenSP, pn.checkMaLoai(loaiSP), loaiSP, 
                    Integer.parseInt(soLuong),dvTinh
                    , Float.parseFloat(giaNhap), Float.parseFloat(giaBan), trangThai);
            JOptionPane.showMessageDialog(null, p.fixProduct(proDTO,current_maSP),
               "Thông báo",JOptionPane.OK_OPTION);
            loadAll();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int current_row = jTable1.getSelectedRow();
        if(current_row != -1) {
            // trạng thái hiện => danh mục hiện
            if((boolean)jTable1.getValueAt(current_row, 7)) {
                int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn ẩn sản phẩm?",
                        "Thông báo",JOptionPane.YES_NO_OPTION);
                if(a == JOptionPane.YES_OPTION) {
                    String maSP = jTable1.getValueAt(current_row, 0).toString();
                    JOptionPane.showMessageDialog(null, p.hideProduct(maSP),
                        "Thông báo",JOptionPane.OK_OPTION); 
                    loadAll();
                } else {
                    return;
                }
               
            } else { 
                JOptionPane.showMessageDialog(null, "Sản phẩm đang ẩn",
                        "Thông báo",JOptionPane.OK_OPTION); 
                return;
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if(row != -1) {
            // không nhập thêm hàng cho sản phẩm ẩn
            if(!(boolean)jTable1.getValueAt(row, 7)) {
                JOptionPane.showMessageDialog(null, "Sản phẩm đang bị ẩn",
                        "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            String maSp = (String) jTable1.getValueAt(row, 0);
            String tenSP = (String) jTable1.getValueAt(row, 1);
            String loaiSP = (String) jTable1.getValueAt(row, 2);
            String dvTinh = (String) jTable1.getValueAt(row, 4);
            float giaNhap = Float.parseFloat(jTable1.getValueAt(row, 5).toString());
            float giaBan = Float.parseFloat(jTable1.getValueAt(row, 6).toString());
            JOptionPane.showMessageDialog(null, "Sản phẩm đã được đưa vào phiếu nhập",
                    "Thông báo",JOptionPane.OK_OPTION);
            float donGia = 0;
            Object []rowData = {maSp,tenSP,loaiSP,0,dvTinh,giaNhap,giaBan,donGia};
            ProductImportStorage.arrList.add(rowData);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        filterProduct();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        filterProduct();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        filterProduct();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws = wb.createSheet("danh sách");
        XSSFRow row = ws.createRow(0);
        XSSFCell cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Danh sách sản phẩm trong kho");
        row = ws.createRow(2);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã sản phẩm");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên sản phẩm");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Loại sản phẩm");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Số lượng");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Đơn vị tính");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Giá nhập");
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Giá bán");
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Trạng thái");
        for(int i=0;i<jTable1.getRowCount();i++) {
            row = ws.createRow(i+3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(jTable1.getValueAt(i, 0).toString());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(jTable1.getValueAt(i, 1).toString());
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(jTable1.getValueAt(i, 2).toString());
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue((int)jTable1.getValueAt(i, 3));
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(jTable1.getValueAt(i, 4).toString());
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue((float)jTable1.getValueAt(i, 5));
            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue((float)jTable1.getValueAt(i, 6));
            cell = row.createCell(7, CellType.BOOLEAN);
            cell.setCellValue((boolean)jTable1.getValueAt(i, 7));
        }
        try {
            File f = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\QLKH\\src\\assets\\Excel\\quanlykho.xlsx");
            FileOutputStream file = new FileOutputStream(f);
            wb.write(file);
            file.close();
            JOptionPane.showMessageDialog(null, "Thành công!","Thông báo",JOptionPane.OK_OPTION);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(product_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(product_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(product_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product_GUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
