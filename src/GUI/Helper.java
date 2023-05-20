package GUI;

import BUS.product_BUS;
import DTO.product_DTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<product_DTO> findSPbyKey(String str){
        product_BUS bus = new product_BUS();
        List<product_DTO> rs = new ArrayList<>();
        List<product_DTO> products = bus.getAllProducts();
        String[] search_keys = str.trim().split("\\s*,\\s*");

        List<product_DTO> search_list = bus.getAllProducts();
        for (product_DTO item : products){
            int count = 0;
            for (String key: search_keys){
                if (item.getMaSP().contains(key) || item.getTenSP().contains(key)){
                    count ++;
                }
            }
            if (count == search_keys.length)
                rs.add(item);
        }

            System.out.println(rs.size());
        return rs;
    }
}
