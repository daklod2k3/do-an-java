package GUI;

import BUS.product_BUS;
import DTO.product_DTO;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static String formatMoney(String value){
        try {
            return formatMoney(Float.parseFloat(value));
        } catch (NumberFormatException e){
            return "";
        }
    }

    public static String formatMoney(Float value){
        String str = String.valueOf(value);
        int indexOfDecimal = str.indexOf(".");
        int number = Integer.parseInt(str.substring(0, indexOfDecimal));
        int numberAfterDot = Integer.parseInt(str.substring(indexOfDecimal + 1));
        String rs = "";
        for (int i = indexOfDecimal; i > 0; i-=3){
            str = str.substring(0, i) + "." + str.substring(i, str.length() - 1);
        }
//        rs += String.valueOf(number);
        return str.substring(0, str.length() - 1);
    }

    public static Date getDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sqlDate;
        try {
            java.util.Date utilDate = dateFormat.parse(dateString);
            sqlDate = new Date(utilDate.getTime());
            return sqlDate;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




}
