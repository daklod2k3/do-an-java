package GUI;

import BUS.HoaDonBUS;
import BUS.product_BUS;
import DAO.KhachHangDAO;
import DTO.*;

import javax.swing.*;

import java.awt.*;

public class HoaDonGUI extends JPanel {


    private JTabbedPane pnlTabbed;

    private product_BUS productBus;
//    private product_DAO productDao;
    private KhachHangDAO khachHangDAO;
//    private
    private NhanVienDTO loginedUser;
    private HoaDonBUS bus;

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
        pnlTabbed.addTab("Danh sách hoá đơn", Helper.resizeImg(new ImageIcon("img/list.png"), 40), new JPanel());
        add(pnlTabbed, gbc);
    }


}
