package GUI;

import BUS.ChitiethdBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.product_BUS;
import DTO.ChiTietHD;
import DTO.HoaDon;
import DTO.KhachHangDTO;
import DTO.product_DTO;
import GUI.Component.Variable;
import GUI.Helper;
import GUI.MainMenu;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class showhdGUI extends JPanel {
    private JPanel pnlThongTinKH;
    private JPanel pnlThongTinSP;
    private JPanel pnlThongTinHD;
    private JPanel pnlThongTinChitiet;
    private product_BUS productBus;
    private TableRowSorter<TableModel> tblSP_sort;
    private JComboBox<String> cbTTSP;
    private JComboBox<String> cbTTKH;
    private TableRowSorter<TableModel> tblKH_sort;
    private custom_table_model modelSP;
    private String[] tblHD_col = new String[]{
            "ID",
            "Tên sản phẩm",
            "Đơn giá",
            "Số lượng",
            "Thành tiền"
    };
    private DefaultTableModel modelKH;

    private custom_table_model modelHD;

    private JTextArea lbTenSP;
    private JLabel lbDVTinh;
    private JLabel lbDonGia;
    private JLabel lbTonKho;
    //        private JLabel lbSoLuong;
    private JTextField tfSoLuong;
    private String[] tblKH_col = new String[]{
            "ID",
            "Tên khách hàng",
            "Giới tính",
            "Số điện thoại"
    };
    private String[] tblSP_col = new String[]{
            "ID",
            "Tên sản phẩm",
            "Đơn vị tính",
            "Đơn giá",
            "Tồn kho"
    };

    private KhachHangBUS khachHangBUS;
    private ChitiethdBUS chitiethdBUS;

    private KhachHangDTO selectedKH;
    private List<product_DTO> selectedSP = new ArrayList<>();
    private product_DTO selectingSP;
    private JLabel lbTongHD;
    private HoaDon addingHd;
    private JLabel lbKH;
    private JLabel lbDate;
    private float tongHD;
    private HoaDonBUS bus;
    private JTable tblSP;
    private JTable tblHD;
    private JTable tblKH;

    public showhdGUI(){
        setLayout(new GridBagLayout());
        pnlThongTinHD = new JPanel();
        pnlThongTinKH = new JPanel();
        pnlThongTinSP = new JPanel();
        pnlThongTinChitiet = new JPanel();
        productBus = new product_BUS();
        khachHangBUS = new KhachHangBUS();
        bus = new HoaDonBUS();
        chitiethdBUS = new ChitiethdBUS();

//            pnlThongTinSP.setBackground(Color.BLACK);
//            pnlThongTinKH.setBackground(Color.red);
//            pnlThongTinHD.setBackground(Color.blue);
        pnlThongTinKH.setMinimumSize(new Dimension(460, 340));
        pnlThongTinChitiet.setMinimumSize(new Dimension(400, 340));
        pnlThongTinHD.setMinimumSize(new Dimension(500, 710));
        pnlThongTinSP.setMinimumSize(new Dimension(870, 355));
        pnlThongTinKH.setMaximumSize(pnlThongTinKH.getMinimumSize());
        pnlThongTinChitiet.setMaximumSize(pnlThongTinChitiet.getMinimumSize());
        pnlThongTinHD.setMaximumSize(pnlThongTinHD.getMinimumSize());
        pnlThongTinKH.setMaximumSize(pnlThongTinKH.getMinimumSize());
//            pnlThongTinKH.setMinimumSize(pnlThongTinKH.getPreferredSize());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
//            gbc.fill = GridBagConstraints.BOTH;
        add(pnlThongTinKH, gbc);

//            gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx++;
        add(pnlThongTinChitiet, gbc);

        gbc.gridx++;
        gbc.gridheight = 2;
//            gbc.fill = GridBagConstraints.BOTH;
        add(pnlThongTinHD, gbc);

        gbc.gridy ++;
        gbc.gridx = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(pnlThongTinSP, gbc);



        thongtinkh_init();
        thongtinsp_init();
        thongtinchitiet_init();
        thongtinhd_init();


    }

    void thongtinhd_init(){
        pnlThongTinHD.setBorder(getTitleBorder("Thông tin hoá đơn"));
        pnlThongTinHD.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lbTitle = new JLabel("HÓA ĐƠN");
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(15, 10, 10, 10);
        pnlThongTinHD.add(lbTitle, gbc);

//            JLabel lbMaHD = new JLabel("Mã hóa đơn");
        lbKH = new JLabel("Tên khách hàng:...");
        JLabel lbTenNV = new JLabel("Nhân viên bán:...");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//            lbDate = new JLabel("Ngày lập: " + formatter.format(date));
//            lbTenKH

//            gbc.gridy++;
        gbc.insets = new Insets(5,10,5, 10);
//            pnlThongTinHD.add(lbMaHD, gbc);

        gbc.gridy++;
        pnlThongTinHD.add(lbKH, gbc);

        gbc.gridy++;
        pnlThongTinHD.add(lbTenNV, gbc);

//            gbc.gridy++;
//            pnlThongTinHD.add(lbDate, gbc);

        modelHD = new custom_table_model(new Object[][]{},
                tblHD_col);

        tblHD = new JTable(modelHD);
        JScrollPane tmp = new JScrollPane(tblHD);
        tmp.setBackground(Color.WHITE);
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        pnlThongTinHD.add(tmp, gbc);

        tblHD.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modelHD.setEditable(tblHD.getSelectedColumn() == 3);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                modelHD.setEditable(tblHD.getSelectedColumn() == 3);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                modelHD.setEditable(tblHD.getSelectedColumn() == 3);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                modelHD.setEditable(tblHD.getSelectedColumn() == 3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                modelHD.setEditable(tblHD.getSelectedColumn() == 3);

            }
        });

        modelHD.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                int row = tblHD.getSelectedRow();
                if (e.getType() == TableModelEvent.UPDATE && !((row == -1 || e.getColumn() != 3))){
                    int soluong = Integer.parseInt((String) tblHD.getValueAt(row, 3));
                    if (soluong == 0){
                        selectedSP.remove(row);
                        modelHD.removeRow(row);
                    }else {
                        if (Integer.parseInt((String) tblHD.getValueAt(row, 3)) > selectedSP.get(row).getSoLuong()){
                            soluong = selectedSP.get(row).getSoLuong();
                            tblHD.setValueAt(String.valueOf(soluong), row, 3);
                        }
                        tblHD.setValueAt(String.valueOf(soluong * selectedSP.get(row).getGiaBan()), row, 4);
                    }
                }
                float tong = 0;
                for (int i = 0; i < selectedSP.size(); i++){
                    tong += selectedSP.get(i).getGiaBan() * Integer.parseInt((String) tblHD.getValueAt(i, 3));
                }
                lbTongHD.setText("Tổng: " + Helper.formatMoney(tong) + "đ");
                tongHD = tong;
            }
        });

        lbTongHD = new JLabel("Tổng: ");
        lbTongHD.setFont(new Font(Variable.primaryFont.getFontName(), Font.BOLD, 17));
        lbTongHD.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton btnAddHD = new JButton("LẬP HÓA ĐƠN");
        btnAddHD.setBackground(Variable.primaryColor);
        btnAddHD.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 25));
        btnAddHD.setForeground(Color.white);
//            btnAddHD.setPreferredSize(new Dimension(10, 30));

        btnAddHD.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedSP.size() == 0) {
                    JOptionPane.showMessageDialog(MainMenu.currentFrame,"Chưa chọn mặt hàng", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (selectedKH == null) {
                    JOptionPane.showMessageDialog(MainMenu.currentFrame,"Vui lòng chọn khách hàng", "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                HoaDon hd = new HoaDon();
                hd.setStatus(1);
                hd.setMAHD(bus.createID());
                hd.setMANV("NV1");
                hd.setMAKH(selectedKH.getMaKH());
                hd.setNgayLap(new java.sql.Date(new Date().getTime()));
                hd.setTongTien(tongHD);
                for (int i = 0; i < selectedSP.size(); i++){
                    ChiTietHD chiTietHD = new ChiTietHD();
                    chiTietHD.setMAHD(hd.getMAHD());
                    chiTietHD.setDonGia(selectedSP.get(i).getGiaBan());
                    chiTietHD.setStatus(true);
                    chiTietHD.setSoLuong(Integer.parseInt( (String) tblHD.getValueAt(i, 3)));
                    chitiethdBUS.addHD(chiTietHD);
                }
                bus.addHD(hd);
                updateAfterAdd();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlThongTinHD.add(lbTongHD, gbc);

        gbc.gridy++;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlThongTinHD.add(btnAddHD, gbc);

    }

    void thongtinchitiet_init(){
        pnlThongTinChitiet.setBorder(getTitleBorder("Thông tin chi tiết sản phẩm"));
//            pnlThongTinChitiet.setMaximumSize(new Dimension(100, 100));
        pnlThongTinChitiet.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
//            gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5,0, 5, 0);
//            pnlThongTinChitiet.setAlignmentX(1.5f);
//            pnlThongTinChitiet.setBackground(Color.WHITE);

        JLabel img_sp = new JLabel(Helper.resizeImg(new ImageIcon("img/no-image.png"), 70));
        img_sp.setPreferredSize(new Dimension(100,100));

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 2;
        pnlThongTinChitiet.add(img_sp, gbc);

        lbTenSP = new JTextArea("Tên sản phẩm: ");
        lbTenSP.setEditable(false);
        lbTenSP.setBorder(new EmptyBorder(0,0,0,0));
        lbDVTinh = new JLabel("Đơn vị tính: ");
        lbDonGia = new JLabel("Đơn giá: ");
        lbTonKho = new JLabel("Tồn kho: ");

        lbTenSP.setLineWrap(true);
        lbTenSP.setWrapStyleWord(true);
        lbTenSP.setMaximumSize(new Dimension(310, 35));
        lbTenSP.setPreferredSize(lbTenSP.getMaximumSize());

        JLabel lbSoLuongHD = new JLabel("Số lượng thêm hóa đơn: ");
        tfSoLuong= new JTextField();
        tfSoLuong.setPreferredSize(new Dimension(50,30));
        tfSoLuong.setMaximumSize(tfSoLuong.getPreferredSize());
        tfSoLuong.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                String old_txt = tfSoLuong.getText();
                System.out.println(old_txt);
                if (!(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && !(ke.getKeyCode() == 8)){
                    tfSoLuong.setText(old_txt);
                    tfSoLuong.setEditable(false);
                }else{
                    tfSoLuong.setEditable(true);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (tfSoLuong.getText().trim().equals("") || selectingSP == null)
                    return;
                int soluong = Integer.parseInt(tfSoLuong.getText());
                if (soluong > selectingSP.getSoLuong())
                    tfSoLuong.setText(String.valueOf(selectingSP.getSoLuong()));
            }
        });

        JButton btnAddToHD = new JButton("Thêm vào hóa đơn");
        btnAddToHD.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectingSP == null)
                    return;
                if (!selectedSP.contains(selectingSP)){
                    int soluong = Integer.parseInt(tfSoLuong.getText());
                    float gia = selectingSP.getGiaBan();
                    selectedSP.add(selectingSP);
                    modelHD.addRow(new String[]{
                            selectingSP.getMaSP(),
                            selectingSP.getTenSP(),
                            String.valueOf(selectingSP.getGiaBan()),
                            tfSoLuong.getText(),
                            String.valueOf(soluong * gia),
                    });
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        pnlThongTinChitiet.add(lbTenSP, gbc);

        gbc.gridy++;
        pnlThongTinChitiet.add(lbDVTinh, gbc);

        gbc.gridy++;
        pnlThongTinChitiet.add(lbDonGia, gbc);

        gbc.gridy++;
        pnlThongTinChitiet.add(lbTonKho, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        pnlThongTinChitiet.add(lbSoLuongHD, gbc);

        gbc.gridx++;
        pnlThongTinChitiet.add(tfSoLuong, gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,0,0,0);
        pnlThongTinChitiet.add(btnAddToHD, gbc);

        pnlThongTinChitiet.setMaximumSize(new Dimension(100,100));

    }

    public CompoundBorder getTitleBorder(String title){
        TitledBorder titledBorder = new TitledBorder(title);
        titledBorder.setTitleFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 17));
        titledBorder.setTitleColor(Variable.primaryColor);
        CompoundBorder border = new CompoundBorder(titledBorder, null);
        return border;
    }

    void thongtinkh_init(){
        pnlThongTinKH.setLayout(new GridBagLayout());
        pnlThongTinKH.setBorder(getTitleBorder("Thông tin khách hàng"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbInput = new JLabel("Nhập thông tin khách hàng để tìm kiếm");
        lbInput.setFont(new Font(Variable.primaryFont.getName(), Font.PLAIN, 13));
        JTextField inputThongTinKH = new JTextField();
        inputThongTinKH_init(inputThongTinKH);

        cbTTKH = new JComboBox<>(tblKH_col);
        cbTTKH.setMaximumSize(new Dimension(100,30));

        gbc.gridwidth = 2;
        pnlThongTinKH.add(lbInput, gbc);


        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.ipadx = 200;
        gbc.insets = new Insets(0, 10, 10, 10);
        pnlThongTinKH.add(cbTTKH, gbc);

        gbc.gridx++;
//            gbc.gridy++;
//            gbc.gridheight = 2;
//            gbc.gridy = 1;
        pnlThongTinKH.add(inputThongTinKH, gbc);

        modelKH = new custom_table_model(new String[][]{},
                tblKH_col);
        tblKH_sort = new TableRowSorter<>(modelKH);
        tblKH = new JTable(modelKH);
        tblKH.setRowSorter(tblKH_sort);
        updateDataKH();
        tblKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblKH.getSelectedRow();
                if (row == -1)
                    return;
                for (KhachHangDTO kh: new KhachHangBUS().getALL()){
                    if (kh.getMaKH().equals(tblKH.getValueAt(row, 0))){
                        lbKH.setText("Tên khách hàng: " + kh.getMaKH() + " - " + kh.getTenKH());
                        selectedKH = kh;
                    }
                }
            }
        });



        JScrollPane tableView = new JScrollPane(tblKH);
        gbc.gridy ++;
        gbc.gridx --;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        pnlThongTinKH.add(tableView, gbc);

    }

    void updateDataKH(){
        modelKH.setRowCount(0);
        for (KhachHangDTO kh: khachHangBUS.getALL()){
            modelKH.insertRow(modelKH.getRowCount(), new String[]{
                            kh.getMaKH(),
                            kh.getTenKH(),
                            kh.isGioiTinh() ? "Nam" : "Nữ",
                            kh.getSoDienThoai()
                    }
            );
        }
    }

    void inputThongTinKH_init(JTextField input){
//            input.setText("Nhập thông tin khách hàng để tìm kiếm");

        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDataTableSP();
                String key = input.getText().trim();
                tblKH_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTKH.getSelectedIndex()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDataTableSP();
                String key = input.getText().trim();
                tblKH_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTKH.getSelectedIndex()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    void inputThongTinSP_init(JTextField input){
//            input.setText("");
        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDataTableSP();
                String key = input.getText().trim();
                tblSP_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTSP.getSelectedIndex()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDataTableSP();
                String key = input.getText().trim();
                tblSP_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTSP.getSelectedIndex()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
//                    String key = input.getText().trim();
//                    tblSP_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTSP.getSelectedIndex()));
            }
        });
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    void thongtinsp_init(){
        pnlThongTinSP.setLayout(new GridBagLayout());
        pnlThongTinSP.setBorder(getTitleBorder("Thông tin sản phẩm"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cbTTSP = new JComboBox<>();
        cbTTSP.setMaximumSize(new Dimension(30,30));
        JLabel lbInput = new JLabel("Nhập thông tin sản phẩm để tìm kiếm");

        tfSoLuong = new JTextField();

        inputThongTinSP_init(tfSoLuong);

        pnlThongTinSP.add(lbInput, gbc);

        gbc.gridy++;
        gbc.weightx = 0.3;
        pnlThongTinSP.add(cbTTSP, gbc);

//            gbc.weightx = 2;
        gbc.weightx = 1.7;
        gbc.gridx++;
        pnlThongTinSP.add(tfSoLuong, gbc);


        modelSP = new custom_table_model(new String[][]{}, tblSP_col);


        updateDataTableSP();

        cbTTSP.setModel(new DefaultComboBoxModel<>(tblSP_col));
        tblSP = new JTable(new String[][]{}, tblSP_col);
        tblSP_sort = new TableRowSorter<>(modelSP);
        tblSP.setModel(modelSP);
        tblSP.setRowSorter(tblSP_sort);
        modelSP.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
//                    System.out.println("tesst");
//                    if (tblSP.getRowCount() == 0) return;
//                    if (tblSP.getSelectedRow() == -1)
//                        tblSP.getSelectionModel().setSelectionInterval(1,1);
            }
        });
        tblSP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblSP.getSelectedRow();
                if (row == -1) return;
                selectingSP = productBus.getProduct((String) tblSP.getValueAt(row, 0));
                if (selectingSP == null)
                    return;
                lbTenSP.setText("Tên sản phẩm: "  + (String) tblSP.getValueAt(row, 1));
                lbDVTinh.setText("Đơn vị tính: " + (String) tblSP.getValueAt(row, 2));
                lbDonGia.setText("Đơn giá: " + (String) tblSP.getValueAt(row, 3) + "đ");
                lbTonKho.setText("Tồn kho: " + (String) tblSP.getValueAt(row, 4));
                tfSoLuong.setText("1");

            }
        });
//            tableData.ta
        JScrollPane tableView = new JScrollPane(tblSP);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        pnlThongTinSP.add(tableView, gbc);

        ListSelectionModel celModel = tblSP.getSelectionModel();
        celModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//            tblSP.setDefaultEditor(Object.class, null);





    }

    void updateDataTableSP(){
        modelSP.setRowCount(0);
        List<product_DTO> tmp = productBus.getAllProducts();
        for (product_DTO productDto : tmp) {
            String[] data = new String[]{
                    productDto.getMaSP(),
                    productDto.getTenSP(),
                    productDto.getDvTinh(),
                    String.valueOf(productDto.getGiaBan()),
                    String.valueOf(productDto.getSoLuong())
            };
            modelSP.insertRow(modelSP.getRowCount(), data);
        }
    }

    class custom_table_model extends DefaultTableModel {
        private boolean editable;
//            public custom_table_model(){
//            }

        public custom_table_model(Object[][] data, Object[] header){
            super(data, header);
            editable = false;
        }

        public void setEditable(boolean editable){
            this.editable = editable;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return this.editable;
        }
    }

//        public void searchTableContents(String searchString, JTable table, DefaultTableModel model) {
//            DefaultTableModel currtableModel = (DefaultTableModel) table.getModel();
//            //To empty the table before search
//            currtableModel.setRowCount(0);
//            //To search for contents from original table content
//            for (Object rows : model.getDataVector()) {
//                Vecto r rowVector = (Vector) rows;
//                for (Object column : rowVector) {
//                    if (column.toString().contains(searchString)) {
//                        //content found so adding to table
//                        currtableModel.addRow(rowVector);
//                        break;
//                    }
//                }
//
//            }
//        }

    public void updateAfterAdd(){
        selectedSP = new ArrayList<>();
        selectingSP = null;
        updateDataKH();
        updateDataTableSP();
        modelHD.setRowCount(0);
    }

}