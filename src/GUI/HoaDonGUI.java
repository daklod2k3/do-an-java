package GUI;

import javax.swing.*;
import java.awt.*;

public class HoaDonGUI extends JPanel {
//    private JPanel panelMain;
    private JTextArea txtTitle;
    private JPanel panelFieldOption;
    private JCheckBox cbAll;
    private JCheckBox cbWaitForPay;
    private JTable tblResult;
    public HoaDonGUI(){
        componentInit();
        initGUI();
    }

    void componentInit(){
        txtTitle = new JTextArea();

        panelFieldOption = new JPanel();

        cbAll = new JCheckBox();

        cbWaitForPay = new JCheckBox();

        tblResult = new JTable();
    }
    void initGUI(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(txtTitle);
        add(panelFieldOption);
        panelFieldOption.add(cbAll);
        panelFieldOption.add(cbWaitForPay);
        add(tblResult);


    }
}
