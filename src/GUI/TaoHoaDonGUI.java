package GUI;

import GUI.Component.Variable;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TaoHoaDonGUI extends JPanel {

    public TaoHoaDonGUI(){
        initGUI();
    }
    void initGUI(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel thong_tin_khach_hang = new JPanel();
        JPanel thong_tin_bo_sung = new JPanel();
        JPanel thong_tin_san_pham = new JPanel();

        gbc.fill = GridBagConstraints.BOTH;

        gbc.insets = new Insets(10,7,7,7);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        add(new thong_tin_khach_hang_panel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        add(thong_tin_bo_sung, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        add(thong_tin_san_pham, gbc);

        thong_tin_bo_sung.setBorder(new CompoundBorder(new TitledBorder("Thông tin bổ sung"), new EmptyBorder(4,4,4,4)));
        thong_tin_san_pham.setBorder(new CompoundBorder(new TitledBorder("Thông tin sản phẩm"), new EmptyBorder(4,4,4,4)));

        thong_tin_san_pham.setLayout(new GridBagLayout());
    }

    class thong_tin_khach_hang_panel extends JPanel{

        public thong_tin_khach_hang_panel(){
            TitledBorder titledBorder = new TitledBorder("Thông tin khách hàng");
            titledBorder.setTitleFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 17));
            titledBorder.setTitleColor(Variable.primaryColor);
            setBorder(titledBorder);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel lbKhachHang = new JLabel("Nhập id hoặc tên để tìm kiếm:");
            lbKhachHang.setFont(new Font(Variable.primaryFont.getName(), Font.PLAIN, 13));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.insets = new Insets((30 - lbKhachHang.getHeight()) / 2,5,10,5);
            add(lbKhachHang, gbc);




            JTextField thongtinkhachhangTxtFld = new JTextField();
            thongtinkhachhangTxtFld.setPreferredSize(new Dimension(100, 30));
            thongtinkhachhangTxtFld.setText("Nhập thông tin khách hàng để tìm kiếm");
            thongtinkhachhangTxtFld.addKeyListener(new KeyListener() {
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

            thongtinkhachhangTxtFld.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    thongtinkhachhangTxtFld.setText("");
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

            ArrayList<String> keyword = new ArrayList<>();
            keyword.add("abc");
            keyword.add("loc");
            keyword.add("toan");
            keyword.add("test");

            JTable khachHangJtbl = new JTable();
//            khachHangJtbl.setColumnModel("");



            gbc.gridx ++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10,5,10,5);

            add(thongtinkhachhangTxtFld, gbc);

            JButton btnSearch = new JButton("Tìm kiếm");
            btnSearch.setPreferredSize(new Dimension(100, 30));
            gbc.insets = new Insets(10, 5, 10, 5);
            gbc.gridx++;
            gbc.weightx = 0;
            add(btnSearch, gbc);

            JTable tblKhachHang = new JTable(
                    new String[][]{},
                    new String[]{
                        "ID",
                        "Tên khách hàng",
                        "Giới tính",
                        "Số điện thoại"
            });
            JScrollPane scrollPane = new JScrollPane(tblKhachHang);


            gbc.gridx = 0;
            gbc.gridy++;
            gbc.weighty = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

        }

    }

}
