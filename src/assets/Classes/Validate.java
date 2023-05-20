/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets.Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Validate {
    public static boolean ValidateName(String name) {
        String regex = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean ValidateNumber(String num) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    public static boolean ValidateAdress(String address) {
        String regex = "\\d+\\s+[a-zA-Z0-9\\s,]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    public static boolean ValidateMaSP(String maSP) {
        String regex = "SP\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maSP);
        return matcher.matches();
    }

    public static boolean ValidateMaPN(String maPN) {
        String regex = "PN\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maPN);
        return matcher.matches(); 
    }

    public static boolean ValidateMaLoai(String maLoai) {
        String regex = "L\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maLoai);
        return matcher.matches(); 
    }

}
