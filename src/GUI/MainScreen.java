package GUI;

import GUI.Component.HeaderBtn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel panelMain;
    private JPasswordField passwordField1;
    private JPanel panelCenter;
    private JPanel panelTop;
    private JPanel panelRight;
    private JButton btnHoaDonViewToggle;
    private JButton btnSanPhamViewToggle;
    private int DEFAULT_HEIGHT = 700,DEFALUT_WIDTH = 1400 ;

    public MainScreen(){
        initGUI();

    }

    void setProbBtnHeader(JButton btn){
        btn.setPreferredSize(new Dimension(50, 50));
//        btn.setBorder();
    }

    void setProbBtnHeader(List<JButton> list){
        for (JButton item : list) {
            setProbBtnHeader(item);
        }
    }

    public void initGUI(){

        setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - DEFALUT_WIDTH/2, dim.height/2 - DEFAULT_HEIGHT/2 );
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
//        setSize( 1800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);

        setProbBtnHeader(new ArrayList<JButton>(Arrays.asList(btnSanPhamViewToggle, btnHoaDonViewToggle)));

        add(panelCenter, BorderLayout.CENTER);
//        add(panelMain);
        add(panelRight, BorderLayout.WEST);
        add(panelTop, BorderLayout.NORTH);
//        panelCenter.add();

        //Header
        panelTop.setPreferredSize(new Dimension(DEFALUT_WIDTH, 70));
        panelTop.setBackground(new Color(255, 255, 255));
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_END;

        panelTop.add(btnHoaDonViewToggle, c);
        panelTop.add(btnSanPhamViewToggle, c);


        //Header button


        //Right panel
        ArrayList<HeaderBtn> rightItem = new ArrayList<>();
        rightItem.add(new HeaderBtn("shopping-cart", "Hoá đơn", 50, 50));

        for (HeaderBtn item: rightItem){
            panelRight.add(item);
        }
        //Frame view
        panelCenter.add(new HoaDonGUI_old());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainScreen();

    }

}
