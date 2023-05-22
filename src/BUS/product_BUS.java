/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.product_DAO;
import DTO.product_DTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class product_BUS {
    product_DAO p;
    public product_BUS(){
        p = new product_DAO();
    }
    public ArrayList<product_DTO> getAllProducts() {
        return p.getAllProducts();
    }
    public boolean isExist(String maSP) {
        p = new product_DAO();
        return p.hasProductID(maSP);
    }
    public boolean addProduct(ArrayList<product_DTO> productList) {
        p = new product_DAO();
        ArrayList<product_DTO> newProductList = new ArrayList<>();
        ArrayList<product_DTO> oldProductList = new ArrayList<>();
        for(int i=0;i<productList.size();i++) {
            if(isExist(productList.get(i).getMaSP()))
                oldProductList.add(productList.get(i));
            else
                newProductList.add(productList.get(i));
        }
        return p.addNewProduct(newProductList) && p.addOldProduct(oldProductList);
    }
    public String fixProduct(product_DTO proDTO, String current_maSP) {
        p = new product_DAO();
        if(p.fixProduct(proDTO,current_maSP))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public String hideProduct(String maSP) {
        p = new product_DAO();
        if(p.hideProduct(maSP))
            return "Ẩn thành công";
        return "Ẩn thất bại";
    }

    public product_DTO getProduct(String id){
        if (p.hasProductID(id)){
            List<product_DTO> list = getAllProducts();
            for (product_DTO item: list){
                if (id.trim().equals(item.getMaSP()))
                    return item;
            }
        }
        return null;
    }
}