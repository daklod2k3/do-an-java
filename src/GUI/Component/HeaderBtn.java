package GUI.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HeaderBtn extends JLabel {

    private ImageIcon img;
    private String lbTxt;
    private String imgFolder = "img/";
    private int width;
    private int height;

    public HeaderBtn(String imgName, String lbTxt, int w, int h){
        this.setPreferredSize(new Dimension(w, h));
        this.width = w;
        this.height = h;
        this.img = new ImageIcon(this.imgFolder + imgName + ".png");
        this.img = resizeImg(this.img);
        this.lbTxt = lbTxt;


        this.setIcon(img);

//        this.setText(lbTxt);
//        this.setFont(new Font("Font Awesome 6 Free", 1, 18));
//        this.setBackground();
    }

    public ImageIcon resizeImg(ImageIcon img){
        int max = img.getIconWidth();
        if (max < img.getIconHeight()){
            max = img.getIconHeight();
        }
        float rate = height * 1.f / max;

        Image imgScale = img.getImage().getScaledInstance( Math.round(img.getIconWidth() * rate), Math.round(img.getIconHeight() * rate), Image.SCALE_SMOOTH);

        return new ImageIcon(imgScale);

    }

//    public ArrayList<HeaderBtn> createFromList(ArrayList<String> list){
//        ArrayList<HeaderBtn> rs;
//        for (String name : list){
//            rs.add(new HeaderBtn())
//        }
//        return rs;
//    }

}
