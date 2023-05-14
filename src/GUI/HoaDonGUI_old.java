package GUI;

import GUI.Component.Variable;

import javax.swing.*;
import java.awt.*;

public class HoaDonGUI_old extends JPanel {


    public HoaDonGUI_old(){
        initGUI();
    }
    void initGUI(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel lbTitle = new JLabel("QUẢN LÝ HOÁ ĐƠN");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setBackground(Variable.primaryColor);
        lbTitle.setOpaque(true);
//        lbTitle.setPreferredSize(new Dimension(getWidth(), 30));
        lbTitle.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 27));
        lbTitle.setPreferredSize(new Dimension(getWidth(), 70));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JTabbedPane panel = new JTabbedPane();
        panel.addTab("Tạo hoá đơn", Helper.resizeImg(new ImageIcon("img/plus.png"), 40), new TaoHoaDonGUI());
        panel.addTab("Danh sách hoá đơn", Helper.resizeImg(new ImageIcon("img/list.png"), 40), new TaoHoaDonGUI());

        add(lbTitle, gbc);
        gbc.insets = new Insets(10,10,0,10);
        gbc.fill = GridBagConstraints.BOTH;
    gbc.weighty = 1;
        add(panel, gbc);
    }

    static public String getClassName(){
        HoaDonGUI_old tmp = new HoaDonGUI_old();
        return tmp.getClass().getCanonicalName();
    }

}
