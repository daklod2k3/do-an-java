package GUI;

import GUI.Component.Variable;

import javax.swing.*;
import java.awt.*;

public class QuanLyTaiKhoan extends JPanel {
    public QuanLyTaiKhoan(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel lbTitle = new JLabel("QUẢN LÝ TÀI KHOẢN");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setBackground(Variable.primaryColor);
        lbTitle.setOpaque(true);
//        lbTitle.setPreferredSize(new Dimension(getWidth(), 30));
        lbTitle.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 27));
        lbTitle.setPreferredSize(new Dimension(getWidth(), 70));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JTabbedPane panel = new JTabbedPane();
        panel.addTab("Nhân viên", Helper.resizeImg(new ImageIcon("img/search.png"), 40), new KhachHangGUI());
        panel.addTab("Khách hàng", Helper.resizeImg(new ImageIcon("img/search.png"), 40), new KhachHangGUI());

        add(lbTitle, gbc);
        gbc.insets = new Insets(10,10,0,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        add(panel, gbc);

    }
}
