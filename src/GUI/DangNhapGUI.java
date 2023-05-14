package GUI;

import DAO.TaiKhoanDAO;
import GUI.Component.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DangNhapGUI extends JFrame {
    private int DEFAULT_HEIGHT = 400;
    private int DEFALUT_WIDTH = 600;
    public DangNhapGUI(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - DEFALUT_WIDTH/2, dim.height/2 - DEFAULT_HEIGHT/2 );
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
//        setSize( 1800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Variable.primaryColor);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lbTitle = new JLabel("ĐĂNG NHẬP");
        lbTitle.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 40));
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lbTaiKhoan = new JLabel("Tài khoản");
        lbTaiKhoan.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));
        lbTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
        lbTaiKhoan.setForeground(Color.WHITE);
        JLabel lbMatKhau = new JLabel("Mật khẩu");
        lbMatKhau.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 20));
        lbMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
        lbMatKhau.setForeground(Color.WHITE);


        JTextField txtFldTaiKhoan = new JTextField();
        txtFldTaiKhoan.setPreferredSize(new Dimension(100, 35));
        JTextField txtFldMatKhau = new JTextField();
        txtFldMatKhau.setPreferredSize(new Dimension(100, 35));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
//        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,30,0);
        add(lbTitle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.30;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,30, 30, 0);
        add(lbTaiKhoan, gbc);

        gbc.gridy = 2;
        add(lbMatKhau, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.7;
        gbc.insets = new Insets(0,0, 30, 30);
        add(txtFldTaiKhoan, gbc);

        gbc.gridy = 2;
        add(txtFldMatKhau, gbc);

        JButton btLogin = new JButton("Đăng nhập");
        btLogin.setForeground(Variable.primaryColor);
//        btLogin.setBackground(Color.WHITE);
//        btLogin.setOpaque(true);
        btLogin.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 35));
        btLogin.setPreferredSize(new Dimension(250,70));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 2;
        add(btLogin, gbc);

        JLabel lbLoginMess = new JLabel();

        btLogin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String tai_khoan = txtFldTaiKhoan.getText();
                String mat_khau = txtFldMatKhau.getText();
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                switch (taiKhoanDAO.checkLogin(tai_khoan, mat_khau)){
                    case -1:
                        lbLoginMess.setText("Lỗi kết nối database!");
                        break;
                    case 0:
                        lbLoginMess.setText("Tài khoản hoặc mật khẩu không tồn tại");
                        break;
                    case 1:
                        new MainMenu(taiKhoanDAO.find(tai_khoan));
                        break;
                };
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

        lbLoginMess.setForeground(new Color(237,67,55));
        lbLoginMess.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10,0,0,0);
        add(lbLoginMess, gbc);

        setResizable(false);
        setVisible(true);
    }
}
