package GUI;

import GUI.Component.Variable;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame{
    private int DEFAULT_HEIGHT = 500;
    private int DEFALUT_WIDTH = 700;
    public LoginGUI(){

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - DEFALUT_WIDTH/2, dim.height/2 - DEFAULT_HEIGHT/2 );
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
//        setSize( 1800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Variable.primaryColor);

        JPanel main_pan = new JPanel(new BorderLayout());
        JPanel right_pan = new JPanel(new BorderLayout());
        right_pan.setBackground(Color.white);


        JPanel right_comp = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Sign Up");
        title.setPreferredSize(new Dimension(this.getWidth(), 70));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Segoe UI", 0, 30));
        right_comp.add(title, "North");

        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel _user = new JLabel("Username");
        _user.setFont(new Font("Segoe UI", 0, 14));
        _user.setPreferredSize(new Dimension(200, 20));
        pan.add(_user);
        JTextField user = new JTextField();
        user.setPreferredSize(new Dimension(200, 30));
        pan.add(user);

        JLabel _pass = new JLabel("Password");
        _pass.setFont(new Font("Segoe UI", 0, 14));
        _pass.setPreferredSize(new Dimension(200, 20));
        pan.add(_pass);
        JPasswordField pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(200, 30));
        pan.add(pass);

        right_comp.add(pan);

        right_pan.add(right_comp);

        JPanel pan_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pan_btn.setPreferredSize(new Dimension(this.getWidth(), 70));

        JButton login = new JButton("Login");
        login.setPreferredSize(new Dimension(120, 30));
        login.setFont(new Font("Segoe UI", 0, 17));
        login.setContentAreaFilled(false);
        login.setForeground(new Color(0, 80, 239));
        login.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        pan_btn.add(login);
        right_pan.add(pan_btn, "South");

        main_pan.add(right_pan);

        getContentPane().add(main_pan);
        setVisible(true);
    }
}
