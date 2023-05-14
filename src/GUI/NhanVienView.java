/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Component;
import java.awt.List;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultRowSorter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import DTO.NhanVienDTO;
import DAO.NhanVienDAO;
import javax.swing.RowFilter;

/**
 *
 * @author defaultuser0
 */
public class NhanVienView extends javax.swing.JFrame {
    NhanVienDAO dao = new NhanVienDAO();
    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    
    
  
    public NhanVienView() {
        initComponents();
        setLocationRelativeTo(this);
       
        searchField.addCaretListener(new CaretListener() {
    @Override
    public void caretUpdate(CaretEvent e) {
        String keyword = searchField.getText();

        // Lặp qua các bảng và thiết lập bộ lọc dữ liệu
        for (Component component : jTabbedPane2.getComponents()) {
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                JTable table = (JTable) scrollPane.getViewport().getView();
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword,1));
                table.setRowSorter(rowSorter);
            }
        }
    }
});
        
        
        
        
        
      
        
                  jTabbedPane2.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
       //    System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
        
        // Lấy bảng được chọn trong tab mới
        JScrollPane selectedScrollPane = (JScrollPane) sourceTabbedPane.getSelectedComponent();
        JTable selectedTable = (JTable) selectedScrollPane.getViewport().getView();
        
        
        
      
       
        
    }
}); 
             DefaultTableModel model1 = (DefaultTableModel)tbl_ToanBo.getModel();
             DefaultTableModel model2 = (DefaultTableModel)tbl_danglamviec.getModel();
             DefaultTableModel model3 = (DefaultTableModel)tbl_nghilam.getModel();
              TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<>(model1);
        tbl_ToanBo.setRowSorter(sorter1);
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(model2);
        tbl_danglamviec.setRowSorter(sorter2);
        TableRowSorter<DefaultTableModel> sorter3 = new TableRowSorter<>(model3);
        tbl_nghilam.setRowSorter(sorter3);
        
        cb_gioiTinh.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String gioiTinh = cb_gioiTinh.getSelectedItem().toString();
        String chucVu = cb_chucVu.getSelectedItem().toString();
        TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(model1);
        TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(model2);
        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(model3);
        if (gioiTinh.equals("Tất cả") && chucVu.equals("Tất cả")) {
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        } else if (gioiTinh.equals("Tất cả") && !chucVu.equals("Tất cả")) {
            sorter2.setRowFilter(RowFilter.regexFilter(chucVu, 7));
            sorter3.setRowFilter(RowFilter.regexFilter(chucVu, 7));
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
            tbl_ToanBo.setRowSorter(sorter1);
        } else if (!gioiTinh.equals("Tất cả") && chucVu.equals("Tất cả")) {
            sorter1.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            sorter2.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            sorter3.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        } else {
            sorter1.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            sorter2.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            sorter3.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        }
    }
});
           cb_chucVu.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String gioiTinh = cb_gioiTinh.getSelectedItem().toString();
        String chucVu = cb_chucVu.getSelectedItem().toString();
        TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(model1);
        TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(model2);
        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(model3);
        if (gioiTinh.equals("Tất cả") && chucVu.equals("Tất cả")) {
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        } else if (gioiTinh.equals("Tất cả") && !chucVu.equals("Tất cả")) {
            sorter2.setRowFilter(RowFilter.regexFilter(chucVu, 7));
            sorter3.setRowFilter(RowFilter.regexFilter(chucVu, 7));
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
            tbl_ToanBo.setRowSorter(sorter1);
        } else if (!gioiTinh.equals("Tất cả") && chucVu.equals("Tất cả")) {
            sorter1.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            sorter2.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            sorter3.setRowFilter(RowFilter.regexFilter(gioiTinh, 4));
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        } else {
            sorter1.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            sorter2.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            sorter3.setRowFilter(RowFilter.andFilter(Arrays.asList(
                    RowFilter.regexFilter(gioiTinh, 4),
                    RowFilter.regexFilter(chucVu, 7))));
            tbl_ToanBo.setRowSorter(sorter1);
            tbl_danglamviec.setRowSorter(sorter2);
            tbl_nghilam.setRowSorter(sorter3);
        }
    }
});
           int index = jTabbedPane2.indexOfTab("Nghỉ việc"); // Lấy vị trí của tab "Nghỉ việc"
Component component = jTabbedPane2.getComponentAt(index); // Lấy component của tab "Nghỉ việc"
String title = jTabbedPane2.getTitleAt(index); // Lấy tiêu đề của tab "Nghỉ việc"
jTabbedPane2.removeTabAt(index); // Xóa tab "Nghỉ việc" khỏi JTabbedPane
jTabbedPane2.addTab(title, component); // Thêm lại tab "Nghỉ việc" vào JTabbedPane, sẽ nằm ở cuối cùng
    /*  */
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
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tenNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rd_quanly = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        rd_nhanvien = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Luong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnHienThi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cb_chucVu = new javax.swing.JComboBox<>();
        cb_gioiTinh = new javax.swing.JComboBox<>();
        jTabbedPane2 = new JTabbedPane();
        jScrollPane5 = new JScrollPane();
        tbl_nghilam = new JTable();
        jScrollPane1 = new JScrollPane();
        tbl_ToanBo = new JTable();
        jScrollPane4 = new JScrollPane();
        tbl_danglamviec = new JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jLabel1.setText("Tìm theo tên ");

        searchField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent evt) {
                searchFieldCaretUpdate(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setText("Tên nhân viên");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setText("Số điện thoại ");

        txt_diaChi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txt_diaChiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setText("Lương");

        buttonGroup3.add(rd_quanly);
        rd_quanly.setText("Quản lý");

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup3.add(rd_nhanvien);
        rd_nhanvien.setSelected(true);
        rd_nhanvien.setText("Nhân viên");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setText("Chức vụ");

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel11.setText("Giới tính");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Plus.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tools.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/show.png"))); // NOI18N
        btnHienThi.setText("Hiển thị");
        btnHienThi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setText("Địa chỉ");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setText("Lọc theo chức vụ");

        jLabel13.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel13.setText("Lọc theo giới tính");

        cb_chucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nhân viên", "Quản lý" }));

        cb_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cb_gioiTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_gioiTinhMouseClicked(evt);
            }
        });
        cb_gioiTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cb_gioiTinhActionPerformed(evt);
            }
        });

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        tbl_nghilam.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "SDT", "Địa chỉ", "Giới tính", "Ngày sinh", "Lương", "Chức vụ", "Trạng thái"
            }
        ));
        tbl_nghilam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nghilamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_nghilam);

        jTabbedPane2.addTab("Nghỉ việc", jScrollPane5);

        tbl_ToanBo.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "SDT", "Địa chỉ", "Giới tính", "Ngày sinh", "Lương", "Chức vụ", "Trạng thái"
            }
        ));
        tbl_ToanBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ToanBoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ToanBo);

        jTabbedPane2.addTab("Toàn bộ", jScrollPane1);

        tbl_danglamviec.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "SDT", "Địa chỉ", "Giới tính", "Ngày sinh", "Lương", "Chức vụ", "Trạng thái"
            }
        ));
        tbl_danglamviec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danglamviecMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_danglamviec);

        jTabbedPane2.addTab("Đang làm việc", jScrollPane4);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_nhanvien)
                            .addComponent(rdNam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdNu)
                            .addComponent(rd_quanly))
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txt_diaChi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txt_Luong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ngaySinh)))
                        .addGap(21, 21, 21)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHienThi)
                                .addGap(5, 5, 5))))
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHienThi)
                            .addComponent(btnLamMoi))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnXoa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(rd_nhanvien)
                                        .addComponent(rd_quanly))
                                    .addComponent(jLabel8))))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(rdNam)
                            .addComponent(rdNu)
                            .addComponent(jLabel10)
                            .addComponent(txt_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txt_maNV.setEnabled(true);
        resetForm();
        txt_maNV.setEditable(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       if(validateForm()){
          
           NhanVienDTO nv;
           try {
               nv = getModel();
               if(dao.add(nv)>0)
           {
               JOptionPane.showMessageDialog(this, "Add thanh cong");
               fillTable();
           }
           } catch (ParseException ex) {
               Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }else{
           JOptionPane.showMessageDialog(this, "Chưa hợp lệ hoặc chưa đầy đủ");
       }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHienThiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
       fillTable();
       fillTableDangLamViec();
       fillTableNghiViec();
       jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btnHienThiActionPerformed

    private void btnXoaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maNV = txt_maNV.getText();
        if(dao.delete(maNV)>0){
        JOptionPane.showMessageDialog(this, "xoa thanh cong");
            fillTable();
            fillTableDangLamViec();
            fillTableNghiViec();
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       NhanVienDTO nv = null;
        try {
            nv = getModelUpdate();
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(dao.update(nv)>0){
           JOptionPane.showMessageDialog(this, "Sửa thành công");
           fillTable();
       }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại ");
        }
       

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbl_ToanBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ToanBoMouseClicked
         int id = tbl_ToanBo.rowAtPoint(evt.getPoint());
        String maNV = tbl_ToanBo.getValueAt(id, 0).toString();
        NhanVienDTO nv = dao.find(maNV);
        setModel(nv);
        txt_maNV.setEditable(false);
    }//GEN-LAST:event_tbl_ToanBoMouseClicked

    private void cb_gioiTinhActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cb_gioiTinhActionPerformed
      
       
    }//GEN-LAST:event_cb_gioiTinhActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
       
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void cb_gioiTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_gioiTinhMouseClicked
    
    }//GEN-LAST:event_cb_gioiTinhMouseClicked

    private void searchFieldCaretUpdate(CaretEvent evt) {//GEN-FIRST:event_searchFieldCaretUpdate
        
    }//GEN-LAST:event_searchFieldCaretUpdate

    private void tbl_danglamviecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danglamviecMouseClicked
        int id = tbl_danglamviec.rowAtPoint(evt.getPoint());
        String maNV = tbl_danglamviec.getValueAt(id, 0).toString();
        NhanVienDTO nv = dao.find(maNV);
        setModel(nv);
        txt_maNV.setEditable(false);
    }//GEN-LAST:event_tbl_danglamviecMouseClicked

    private void tbl_nghilamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nghilamMouseClicked
        int id = tbl_nghilam.rowAtPoint(evt.getPoint());
        String maNV = tbl_nghilam.getValueAt(id, 0).toString();
        NhanVienDTO nv = dao.find(maNV);
        setModel(nv);   
        txt_maNV.setEditable(false);
    }//GEN-LAST:event_tbl_nghilamMouseClicked

    private void txt_diaChiActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diaChiActionPerformed

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
            Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NhanVienView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThi;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cb_chucVu;
    public javax.swing.JComboBox<String> cb_gioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rd_nhanvien;
    private javax.swing.JRadioButton rd_quanly;
    private javax.swing.JTextField searchField;
    private JTable tbl_ToanBo;
    private JTable tbl_danglamviec;
    private JTable tbl_nghilam;
    private javax.swing.JTextField txt_Luong;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_tenNV;
    // End of variables declaration//GEN-END:variables
    public void resetForm(){
        
        txt_maNV.setText("");
        txt_tenNV.setText("");
        txt_SDT.setText("");
        txt_diaChi.setText("");
        rdNam.setSelected(true);
        txt_ngaySinh.setText("");
        txt_Luong.setText("");
        
       
    }
    public boolean validateForm(){
       
        if(txt_maNV.getText().isEmpty() ||txt_tenNV.getText().isEmpty() || txt_SDT.getText().isEmpty() ||
              txt_diaChi.getText().isEmpty() || txt_ngaySinh.getText().isEmpty() || txt_Luong.getText().isEmpty()
                
                )
            return false;
          try {
        int maNV = Integer.parseInt(txt_maNV.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Mã nhân viên phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng chữ cho trường tên NV
    if (!txt_tenNV.getText().matches("^[a-zA-Z ]*$")) {
        JOptionPane.showMessageDialog(this, "Tên nhân viên chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng số cho trường SDT
    if (!txt_SDT.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Số điện thoại phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng số cho trường lương
    try {
        double luong = Double.parseDouble(txt_Luong.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Lương phải là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    // Kiểm tra định dạng ngày tháng năm sinh
    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date ngaySinh = date_format.parse(txt_ngaySinh.getText().trim());
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Định dạng ngày sinh phải là dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        return true;
    }
    public NhanVienDTO getModel() throws ParseException{
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV("NV"+txt_maNV.getText());
        nv.setTenNV(txt_tenNV.getText());
        nv.setPhone(txt_SDT.getText());
        nv.setDiaChi(txt_diaChi.getText());
        boolean gt = false;
        if(rdNam.isSelected())
            gt = true;
        nv.setGioiTinh(gt);
        nv.setNgaySinh(date_format.parse(txt_ngaySinh.getText()));
        nv.setLuong(Double.parseDouble(txt_Luong.getText()));
        boolean chucVu=false;
        if(rd_nhanvien.isSelected())
        {
            chucVu = true;
        } 
        nv.setChucVu(chucVu);
        nv.setTrangThai(true);
        return nv;
    }
    public NhanVienDTO getModelUpdate() throws ParseException{
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(txt_maNV.getText());
        nv.setTenNV(txt_tenNV.getText());
        nv.setPhone(txt_SDT.getText());
        nv.setDiaChi(txt_diaChi.getText());
        boolean gt = false;
        if(rdNam.isSelected())
            gt = true;
        nv.setGioiTinh(gt);
        nv.setNgaySinh(date_format.parse(txt_ngaySinh.getText()));
        nv.setLuong(Double.parseDouble(txt_Luong.getText()));
        boolean chucVu=false;
        if(rd_nhanvien.isSelected())
        {
            chucVu = true;
        } 
        nv.setChucVu(chucVu);
        nv.setTrangThai(true);
        return nv;
    }
    public void fillTable(){
        DefaultTableModel tblModel = (DefaultTableModel)tbl_ToanBo.getModel();
        tblModel.setRowCount(0);
        for(NhanVienDTO nv : dao.getall()){
            Object data[] = new Object[9];
            data[0]=nv.getMaNV();
            data[1] = nv.getTenNV();
            data[2]=nv.getPhone();
            data[3]=nv.getDiaChi();
            data[4]=nv.isGioiTinh()?"Nam":"Nữ";
            data[5]=date_format.format(nv.getNgaySinh());
            data[6]=nv.getLuong();
            if(nv.isChucVu()){
                data[7]="Nhân viên";
            }else{
                data[7]="Quản lý";
            }
            if(nv.isTrangThai()){
                data[8]="Đang làm việc";
            }else{
                data[8]="Nghỉ việc";
            }
            tblModel.addRow(data);
        }
    }
   
    public void setModel(NhanVienDTO nv){
        txt_maNV.setText(nv.getMaNV());
        txt_tenNV.setText(nv.getTenNV());
        txt_SDT.setText(nv.getPhone());
        txt_diaChi.setText(nv.getDiaChi());
        if(nv.isGioiTinh()){
            rdNam.setSelected(true);
        }else rdNu.setSelected(true);
        txt_ngaySinh.setText(date_format.format(nv.getNgaySinh()));
        txt_Luong.setText(String.valueOf(nv.getLuong()));
       
        if(nv.isChucVu()){
            
                rd_nhanvien.setSelected(true); 
            }else 
            rd_quanly.setSelected(true);
        
       
    }
 
    
     public void fillTableDangLamViec(){
        DefaultTableModel tblModel = (DefaultTableModel)tbl_danglamviec.getModel();
        tblModel.setRowCount(0);
        for(NhanVienDTO nv : dao.getall()){
            if(nv.isTrangThai()){
            Object data[] = new Object[9];
            data[0]=nv.getMaNV();
            data[1] = nv.getTenNV();
            data[2]=nv.getPhone();
            data[3]=nv.getDiaChi();
            data[4]=nv.isGioiTinh()?"Nam":"Nữ";
            data[5]=date_format.format(nv.getNgaySinh());
            data[6]=nv.getLuong();
            if(nv.isChucVu()){
                data[7]="Nhân viên";
            }else{
                data[7]="Quản lý";
            }
            
                data[8]="Đang làm việc";
            
            tblModel.addRow(data);
        }
        }
    }
      public void fillTableNghiViec(){
        
        DefaultTableModel tblModel = (DefaultTableModel)tbl_nghilam.getModel();
        tblModel.setRowCount(0);
        for(NhanVienDTO nv : dao.getall()){
            if(!nv.isTrangThai()){
            Object data[] = new Object[9];
            data[0]=nv.getMaNV();
            data[1] = nv.getTenNV();
            data[2]=nv.getPhone();
            data[3]=nv.getDiaChi();
            data[4]=nv.isGioiTinh()?"Nam":"Nữ";
            data[5]=date_format.format(nv.getNgaySinh());
            data[6]=nv.getLuong();
            if(nv.isChucVu()){
                data[7]="Nhân viên";
            }else{
                data[7]="Quản lý";
            }
           
                data[8]="Nghỉ việc";
            
            tblModel.addRow(data);
        }
        }
    }
     public ArrayList duyetTable(DefaultTableModel model){
        
         ArrayList<NhanVienDTO> ds = new ArrayList<>();
         int rowCount = model.getRowCount();
         for (int row = 0; row < rowCount; row++){
             String maNV = (String) model.getValueAt(row, 0);    
            NhanVienDTO nv =  dao.find(maNV);
             ds.add(nv);
         }
         return ds;
     }
      public ArrayList locGioiTinh(ArrayList<NhanVienDTO> ls, boolean gt){
          ArrayList<NhanVienDTO> ds = new ArrayList<>();
          for(NhanVienDTO nv : ls){
              if(nv.isGioiTinh()==gt){
                  ds.add(nv);
              }
          }
          return ds;                                                                                                                                                                                                                                                                                                                
      }                             
   public ArrayList locChucVu(ArrayList<NhanVienDTO> ls, boolean gt){
          ArrayList<NhanVienDTO> ds = new ArrayList<>();
          for(NhanVienDTO nv : ls){
              if(nv.isChucVu()==gt){
                  ds.add(nv);
              }
          }
          return ds;                                                                                                                                                                                                                                                                                                                
      } 
  
}
