/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets.test;

/**
 *
 * @author Admin
 */
public class test1 {
    public static void main(String[] args) {
        String num = "3000.0a";
        try {
            if(Float.isFinite(Float.valueOf(num))) {
            System.out.println("float");
            } else {
                System.out.println(" not float");
            }
        } catch (Exception e) {
        }

    }
}
