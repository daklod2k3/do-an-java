package GUI;

import DTO.TaiKhoanDTO;
import GUI.Component.*;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MainMenu extends JFrame{
    private JPanel panelMain;
    private JPanel panelCenter;
    private JTabbedPane panelTapped;
    private JPanel panelRight;
    private JPanel panelLeft;
    private ArrayList<JComponent> headerBtnList;
    private ArrayList<JComponent> leftBtnList;
    private int DEFAULT_HEIGHT = 900,DEFALUT_WIDTH = 1600 ;
    private JLabel lbTitle;
    final Color primaryColor = new Color(27, 158, 252);

    private RightLabel activingLb;



    private TaiKhoanDTO loginUser;

    public MainMenu(TaiKhoanDTO tai_khoan){
        loginUser = tai_khoan;
        initGUI();
    }

//    public void setProbBtnHeader(ArrayList<> list){
//
//    }

//    public ArrayList<JComponent> createHeaderBtn(String[] btnNames){
//        ArrayList<JComponent> rs;
//        for (){
//
//        }
//    }

    public void initGUI(){
        setFont(Variable.primaryFont);
        setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - DEFALUT_WIDTH/2, dim.height/2 - DEFAULT_HEIGHT/2 );
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
//        setSize( 1800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);


        //init component
        panelTapped = new JTabbedPane();

        panelRight = new JPanel();

        panelCenter = new JPanel(new CardLayout());

        panelLeft = new JPanel(new GridBagLayout());

        lbTitle = new JLabel();

        add(panelRight, BorderLayout.WEST);
//        add(panelCenter, BorderLayout.CENTER);


        // Panel bên trái
        panelRight.setPreferredSize(new Dimension(200, DEFAULT_HEIGHT));
        panelRight.setBackground(primaryColor);
        panelRight.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelRight.setBorder(new EmptyBorder(10,0,0,0));

        // panel user
        JPanel panelUser = new JPanel();
        panelUser.setBackground(primaryColor);
        panelUser.setLayout(new GridBagLayout());
        panelUser.setBorder(new EmptyBorder(0,0,10,0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

//        gbc.insets = new Insets(0, 0, 0,0 );

        JLabel lbUserImg = new JLabel();
        lbUserImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbUserImg.setPreferredSize(new Dimension(150, 150));
        lbUserImg.setIcon(Helper.resizeImg(new ImageIcon("img/emp-male.png"), 150));

        JLabel lbUserName = new JLabel("<html> <p style=\"text-align: center;\">Trần Dương Đắc Lộc</p></html>");
        lbUserName.setPreferredSize(new Dimension(170, 70));
        lbUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lbUserName.setFont(new Font(getFont().getName(), Font.BOLD, 25));
        lbUserName.setForeground(Color.WHITE);

        JLabel lbUserRole = new JLabel("Quản trị viên");
        lbUserRole.setForeground(Variable.green);
//        lbUserRole.setPreferredSize(new Dimension(170, 30));
        lbUserRole.setFont(new Font(getFont().getName(), Font.BOLD, 17));
//        lbUserRole.setForeground(Color.);
        lbUserRole.setHorizontalAlignment(SwingConstants.CENTER);

        panelUser.add(lbUserImg, gbc);
        panelUser.add(lbUserName, gbc);
        panelUser.add(lbUserRole, gbc);

        panelRight.add(panelUser);


        // label chức năng
        ArrayList<RightLabel> lbRightList = new ArrayList<>();
//        lbRightList.add(new RightLabel("cart", "Hoá đơn", new HoaDonGUI_old()));
        lbRightList.add(new RightLabel("store", "Kho hàng", new product_GUI()));
        lbRightList.add(new RightLabel("supermaket", "Nhà cung cấp", new NhaCungCapGUI()));
        lbRightList.add(new RightLabel("user", "Tài khoản", new QuanLyTaiKhoan()));


        System.out.println(HoaDonGUI_old.getClassName());

        for (RightLabel item : lbRightList){
            if (item == lbRightList.get(0)){
                activingLb = item.setActive();
                lbTitle.setText("QUẢN LÝ ");
            }
            panelCenter.add(item.getActivePanel(), item.getLbTxt());
            item.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    activingLb.setUnActive();
                    if (!item.getActive()){
                        activingLb = item.setActive();
                        CardLayout cardLayout = (CardLayout) panelCenter.getLayout();
                        cardLayout.show(panelCenter, item.getLbTxt());
                        lbTitle.setText("QUẢN LÝ " + item.getLbTxt().toUpperCase());
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
                    if (!item.getActive())
                        item.setHover();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!item.getActive())
                        item.setUnActive();
                }
            });
            panelRight.add(item);
        }


        // Panel center

        // panel left


        lbTitle.setOpaque(true);
        lbTitle.setBackground(Variable.primaryColor);
        lbTitle.setForeground(Color.white);
        lbTitle.setText("QUẢN LÝ " + lbRightList.get(0).getLbTxt().toUpperCase());
        lbTitle.setFont(new Font(Variable.primaryFont.getName(), Font.BOLD, 30));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 50;
        gbc.fill = GridBagConstraints.BOTH;
        panelLeft.add(lbTitle, gbc);

//        JLabel test = new JLabel("Test");
//        test.setBackground(Color.BLUE);
//        test.setOpaque(true);

        gbc.gridy = 1;
        gbc.ipady = 0;
        gbc.weighty = 1;
        panelLeft.add(panelCenter, gbc);

//        panelLeft.add(panelCenter, gbc);

        add(panelLeft, BorderLayout.CENTER);



        setVisible(true);
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
//        new DangNhapGUI();
        new MainMenu(null);

    }

    public JLabel getlbRightPanel(String lbTxt, String imgLink){
        JLabel lb = new JLabel(" " + lbTxt);
//        lb.setBorder(new CompoundBorder(new TitledBorder("test"), null));
        lb.setForeground(Color.WHITE);
        lb.setHorizontalAlignment(SwingConstants.CENTER);
        lb.setFont(new Font(getFont().getName(), Font.BOLD, 20));
        lb.setPreferredSize(new Dimension(200, 50));
        lb.setIcon(Helper.resizeImg(new ImageIcon("img/" + imgLink), lb.getFont().getSize() + 10));
        return lb;
    }

    public void setLbRigtActive(JLabel lb){
        lb.setForeground(primaryColor);
        lb.setOpaque(true);
        lb.setBackground(Color.white);
        String imgLink = lb.getIcon().toString();
        imgLink = imgLink.replace(".png", "-selected.png");
        System.out.println(imgLink);
        lb.setIcon(new ImageIcon(imgLink));
    }

}
