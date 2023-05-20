package GUI;

import BUS.product_BUS;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.product_DAO;
import DTO.HoaDon;
import DTO.SanPham;
import DTO.product_DTO;
import GUI.Component.Variable;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonGUI extends JPanel {


    private JTabbedPane pnlTabbed;
    private JTable tblSP;
    private JTable tblHD;
    private JTable tblKH;
    private product_BUS productBus;
//    private product_DAO productDao;
    private KhachHangDAO khachHangDAO;
//    private

    public HoaDonGUI(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(10, 10,10,10);

//        init component
        pnlTabbed = new JTabbedPane();
        pnlTabbed.addTab("Tạo hoá đơn", Helper.resizeImg(new ImageIcon("img/plus.png"), 40), new AddHoaDonGUI());
        pnlTabbed.addTab("Danh sách hoá đơn", Helper.resizeImg(new ImageIcon("img/list.png"), 40), new TaoHoaDonGUI());


        add(pnlTabbed, gbc);
    }

    class AddHoaDonGUI extends JPanel {
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
                "Số lượng",
                "Đơn giá",
                "Thành tiền"
        };
        private DefaultTableModel modelKH;

        private custom_table_model modelHD;

        private JLabel lbTenSP;
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

        public AddHoaDonGUI(){
            setLayout(new GridBagLayout());
            pnlThongTinHD = new JPanel();
            pnlThongTinKH = new JPanel();
            pnlThongTinSP = new JPanel();
            pnlThongTinChitiet = new JPanel();
            productBus = new product_BUS();


//            pnlThongTinSP.setBackground(Color.BLACK);
//            pnlThongTinKH.setBackground(Color.red);
//            pnlThongTinHD.setBackground(Color.blue);


            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(5, 10, 10, 10);
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(pnlThongTinKH, gbc);

            gbc.gridx = 1;
            gbc.ipady = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            add(pnlThongTinChitiet, gbc);

            gbc.ipady = 0;
            gbc.gridx++;
            gbc.gridheight = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.2;
            add(pnlThongTinHD, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            add(pnlThongTinSP, gbc);



            thongtinkh_init();
            thongtinsp_init();
            thongtinchiteit_init();
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

            JLabel lbMaHD = new JLabel("Mã hóa đơn");
            JLabel lbTenKH = new JLabel("Tên khách hàng:...");
            JLabel lbTenNV = new JLabel("Nhân viên bán:...");
            JLabel lbThoiGian = new JLabel("Ngày lập:...");
//            lbTenKH

            gbc.gridy++;
            gbc.insets = new Insets(5,10,5, 10);
            pnlThongTinHD.add(lbMaHD, gbc);

            gbc.gridy++;
            pnlThongTinHD.add(lbTenKH, gbc);

            gbc.gridy++;
            pnlThongTinHD.add(lbTenNV, gbc);

            gbc.gridy++;
            pnlThongTinHD.add(lbThoiGian, gbc);

            modelHD = new custom_table_model(new Object[][]{},
            tblHD_col);

            tblHD = new JTable(modelHD);
            JScrollPane tmp = new JScrollPane(tblHD);
            tmp.setBackground(Color.WHITE);
            gbc.gridy++;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            pnlThongTinHD.add(tmp, gbc);

            JLabel lbTongTien = new JLabel("Tổng: ");
            lbTongTien.setFont(new Font(Variable.primaryFont.getFontName(), Font.BOLD, 17));
            lbTongTien.setHorizontalAlignment(SwingConstants.RIGHT);

            JButton btnAddHD = new JButton("LẬP HÓA ĐƠN");
            btnAddHD.setBackground(Variable.primaryColor);
            btnAddHD.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 25));
            btnAddHD.setForeground(Color.white);
//            btnAddHD.setPreferredSize(new Dimension(10, 30));


            gbc.gridy++;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            pnlThongTinHD.add(lbTongTien, gbc);

            gbc.gridy++;
            gbc.ipady = 20;
            gbc.ipadx = 20;
            gbc.fill = GridBagConstraints.VERTICAL;
            pnlThongTinHD.add(btnAddHD, gbc);

        }

        void thongtinchiteit_init(){
            pnlThongTinChitiet.setBorder(getTitleBorder("Thông tin chi tiết sản phẩm"));
//            pnlThongTinChitiet.setMaximumSize(new Dimension(100, 100));
            pnlThongTinChitiet.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
//            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.insets = new Insets(5,0, 5, 0);
//            pnlThongTinChitiet.setAlignmentX(1.5f);
            pnlThongTinChitiet.setBackground(Color.WHITE);

            JLabel img_sp = new JLabel(Helper.resizeImg(new ImageIcon("img/no-image.png"), 100));
            img_sp.setPreferredSize(new Dimension(100,100));

            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.ipadx = 0;
            gbc.ipady = 0;
            gbc.gridwidth = 2;
            pnlThongTinChitiet.add(img_sp, gbc);

            lbTenSP = new JLabel("Tên sản phẩm: ");
            lbDVTinh = new JLabel("Đơn vị tính: ");
            lbDonGia = new JLabel("Đơn giá: ");
            lbTonKho = new JLabel("Tồn kho: ");

            JLabel lbSoLuongHD = new JLabel("Số lượng thêm hóa đơn: ");
            tfSoLuong= new JTextField();
            tfSoLuong.setPreferredSize(new Dimension(50,30));
            tfSoLuong.setMaximumSize(tfSoLuong.getPreferredSize());

            JButton btnAddToHD = new JButton("Thêm vào hóa đơn");
            btnAddToHD.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String[] tmp = lbTenSP.getText().replace("Tên sản phẩm: ", "").split("-");
                    modelHD.addRow(new String[]{
                            tmp[0].trim(),
                            tmp[1].trim(),
                            lbDonGia.getText().replace("Đơn giá: ", "").replace("đ", ""),
                            tfSoLuong.getText().replace("Tồn kho: ", ""),
                            String.valueOf(Float.parseFloat(lbDonGia.getText().replace("Đơn giá: ", "").replace("đ", ""))
                                    * Integer.parseInt(tfSoLuong.getText().replace("Tồn kho: ", "")))
                    });
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
            lbInput.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 13));
            JTextField inputThongTinKH = new JTextField();
            inputThongTinKH_init(inputThongTinKH);

            cbTTKH = new JComboBox<>(tblKH_col);
            cbTTKH.setMaximumSize(new Dimension(100,30));


            pnlThongTinKH.add(lbInput, gbc);


            gbc.gridy++;
            gbc.ipadx = 200;
            gbc.insets = new Insets(0, 10, 10, 10);
            pnlThongTinKH.add(cbTTKH, gbc);

            gbc.gridx++;
//            gbc.gridy++;
//            gbc.gridheight = 2;
//            gbc.gridy = 1;
            pnlThongTinKH.add(inputThongTinKH, gbc);

            tblKH = new JTable(
                    new String[][] {},
                    new String[]{
                            "ID",
                            "Tên khách hàng",
                            "Giới tính",
                            "Số điện thoại"
                    });
            JScrollPane tableView = new JScrollPane(tblKH);
            gbc.gridy ++;
            gbc.gridx --;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1;
            pnlThongTinKH.add(tableView, gbc);

        }

        void inputThongTinKH_init(JTextField input){
//            input.setText("Nhập thông tin khách hàng để tìm kiếm");

            input.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
//                    if (input.getText().trim().equals(""))
//                        input.setText("Nhập thông tin khách hàng để tìm kiếm");
////                    if (input.getText().trim())
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }

        void inputThongTinSP_init(JTextField input){
//            input.setText("");
            input.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String key = input.getText().trim();
                    tblSP_sort.setRowFilter(RowFilter.regexFilter("(?i)"+ key, cbTTSP.getSelectedIndex()));
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
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
            pnlThongTinSP.setMinimumSize(new Dimension(100, 300));
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

            cbTTSP.setModel(new DefaultComboBoxModel<>(tblSP_col));
            tblSP = new JTable(new String[][]{}, tblSP_col);
            tblSP_sort = new TableRowSorter<>(modelSP);
            tblSP.setModel(modelSP);
            tblSP.setRowSorter(tblSP_sort);
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
            tblSP.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tblSP.getSelectedRow();
                    lbTenSP.setText("Tên sản phẩm: " + (String) tblSP.getValueAt(row, 0) + " - " + (String) tblSP.getValueAt(row, 1));
                    lbDVTinh.setText("Đơn vị tính: " + (String) tblSP.getValueAt(row, 2));
                    lbDonGia.setText("Đơn giá: " + (String) tblSP.getValueAt(row, 3) + "đ");
                    lbTonKho.setText("Tồn kho: " + (String) tblSP.getValueAt(row, 4));
                    tfSoLuong.setText("1");
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

    }

}
