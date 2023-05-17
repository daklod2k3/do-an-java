package GUI;

import GUI.Component.Variable;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class HoaDonGUI extends JPanel {


    private JTabbedPane pnlTabbed;
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
        public AddHoaDonGUI(){
            setLayout(new GridBagLayout());
            pnlThongTinHD = new JPanel();
            pnlThongTinKH = new JPanel();
            pnlThongTinSP = new JPanel();

//            pnlThongTinSP.setBackground(Color.BLACK);
//            pnlThongTinKH.setBackground(Color.red);
//            pnlThongTinHD.setBackground(Color.blue);


            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(5, 10, 10, 10);
            gbc.fill = GridBagConstraints.BOTH;
            add(pnlThongTinKH, gbc);

            gbc.gridx++;
            gbc.gridheight = 2;
            gbc.weightx = 0.5;
            add(pnlThongTinHD, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridheight = 1;
            add(pnlThongTinSP, gbc);



            thongtinkh_init();
            thongtinsp_init();
            pnlThongTinHD.setBorder(getTitleBorder("Thông tin hoá đơn"));


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

            pnlThongTinKH.add(lbInput, gbc);

            gbc.insets = new Insets(0, 10, 10, 10);
            gbc.gridy = 1;
            pnlThongTinKH.add(inputThongTinKH, gbc);

            JTable tableData = new JTable(
                    new String[][] {},
                    new String[]{
                            "ID",
                            "Tên khách hàng",
                            "Giới tính",
                            "Số điện thoại"
                    });
            JScrollPane tableView = new JScrollPane(tableData);
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1;
            pnlThongTinKH.add(tableView, gbc);

        }

        void inputThongTinKH_init(JTextField input){
            input.setText("Nhập thông tin khách hàng để tìm kiếm");

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

        void thongtinsp_init(){
            pnlThongTinSP.setLayout(new GridBagLayout());
            pnlThongTinSP.setBorder(getTitleBorder("Thông tin sản phẩm"));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.insets = new Insets(0, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel lbInput = new JLabel("Nhập thông tin sản phẩm để tìm kiếm");
            JTextField inputThongTinKH = new JTextField();
            inputThongTinKH_init(inputThongTinKH);

            pnlThongTinSP.add(lbInput, gbc);

            gbc.gridy = 1;
            pnlThongTinSP.add(inputThongTinKH, gbc);

            JTable tableData = new JTable(
                    new Object[][]{
                            new Object[]{
                                    new ImageIcon("img/coca.png"),
                                    "",
                                    "",
                                    "",
                                    ""
                            }
                    },
                    new String[]{
                            "ID",
                            "",
                            "Tên sản phẩm",
                            "Đơn giá",
                            "Số lượng"
                    });
//            tableData.ta
            JScrollPane tableView = new JScrollPane(tableData);
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1;
            pnlThongTinSP.add(tableView, gbc);

        }
    }

}
