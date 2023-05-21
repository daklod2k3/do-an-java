package GUI.Component;

import GUI.Helper;

import javax.swing.*;
import java.awt.*;

public class RightLabel extends JLabel {
    private String lbTxt, imgLink;
    private Color hover = new Color(0,0,0);
    private Color normal = Variable.primaryColor;
    private boolean active = false;
    private String name, img, imgActive, imgHover;
    private JPanel activePanel;

    public RightLabel(String imgLink, String lbTxt, JPanel activePanel){
        this.activePanel = activePanel;
        this.lbTxt = lbTxt;
        setText("  " + lbTxt);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font(getFont().getName(), Font.BOLD, 20));
        setPreferredSize(new Dimension(200, 70));

        setImgLink(imgLink);
        setUnActive();
    }

    public String getLbTxt() {
        return lbTxt;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
        ImageIcon img = Helper.resizeImg(new ImageIcon("img/" + imgLink + ".png"), getFont().getSize() + 10);
        super.setIcon(img);
    }

    public RightLabel setActive(){
        this.active = true;
        setForeground(Variable.primaryColor);
        setOpaque(true);
        setBackground(Color.white);
        setImgLink(imgLink + "-selected");
//        JOptionPane.
        return this;
    }

    public void setUnActive(){
        this.active = false;
        setForeground(Color.WHITE);
        setBackground(Variable.primaryColor);
        setImgLink(imgLink.replace("-selected", ""));
    }

    public void setHover(){
        setBackground(Variable.darkColor);
        setOpaque(true);
    }



    public void clicked(){

    }

    public boolean getActive(){
        return active;
    }

    public JPanel getActivePanel(){
        return activePanel;
    }
}
