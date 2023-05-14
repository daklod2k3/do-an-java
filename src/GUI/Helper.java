package GUI;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static ImageIcon resizeImg(ImageIcon img, int height){
        int max = img.getIconWidth();
        if (max < img.getIconHeight()){
            max = img.getIconHeight();
        }
        float rate = height * 1.f / max;

        Image imgScale = img.getImage().getScaledInstance( Math.round(img.getIconWidth() * rate), Math.round(img.getIconHeight() * rate), Image.SCALE_SMOOTH);

        return new ImageIcon(imgScale);

    }

    public static String removeAccents(String str) {
        String[] AccentsMap = {
                "aàảãáạăằẳẵắặâầẩẫấậ",
                "AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬ",
                "dđ", "DĐ",
                "eèẻẽéẹêềểễếệ",
                "EÈẺẼÉẸÊỀỂỄẾỆ",
                "iìỉĩíị",
                "IÌỈĨÍỊ",
                "oòỏõóọôồổỗốộơờởỡớợ",
                "OÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢ",
                "uùủũúụưừửữứự",
                "UÙỦŨÚỤƯỪỬỮỨỰ",
                "yỳỷỹýỵ",
                "YỲỶỸÝỴ"
        };
        for (int i = 0; i < AccentsMap.length; i++) {
            str = str.replaceAll('[' + AccentsMap[i].substring(1) + ']', Character.toString(AccentsMap[i].charAt(0)));
        }
        return str;
    }

}
