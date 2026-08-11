/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Chuong_03_BaiTap01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author MSI
 */
public class ChuongTrinh {

    public static void main(String[] args) {
        ArrayList<SanPham> ds = new ArrayList<>();
        NhapDSSanPham(ds);
        System.out.println("Danh sach ban đau");
        XuatDSSanPham(ds);
        sapXepGiaGiamDan(ds);
        System.out.println("Danh sach sau khi sap gia giam dan");
        XuatDSSanPham(ds);
         System.out.println("----------San pham co gia lon nhat---------");
        System.out.println(TimSanPhamGiaLonNhat(ds)); 
    }
    public static void NhapDSSanPham(ArrayList<SanPham> ds) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cho biet so luong san pham can nhap: ");
        int n = sc.nextInt();
 sc.nextLine();
 for(int i = 0;i<n;i++){
     System.out.println("----------Nhap san pham thu "+ (i+1) + "----------");
     System.out.println("Cho biet ma san pham");
             String ma = sc.nextLine();
              System.out.println("Cho biet ten san pham");
             String ten = sc.nextLine();
              System.out.println("Cho biet gia san pham");
             double gia = Double.parseDouble(sc.nextLine()) ;
             SanPham sp = new SanPham(ma, ten, gia);//tạo đối tượng từng sản phẩm
             ds.add(sp);
 }
    }
     public static void XuatDSSanPham(ArrayList<SanPham> ds) {
        for (SanPham x : ds){
            System.out.println(x.toString());
        }
        
    }
     public static void sapXepGiaGiamDan(ArrayList<SanPham> ds) {
        Collections.sort(ds, (sp1, sp2) -> Double.valueOf(sp2.getGia()).compareTo(Double.valueOf(sp1.getGia())));
        }
     public static SanPham TimSanPhamGiaLonNhat(ArrayList<SanPham> ds) {
         if (ds.isEmpty()) {
            return null; // Kiểm tra nếu danh sách rỗng
        }
       SanPham max = ds.get(0);
       for(int i = 1; i<ds.size(); i++){
           if(max.getGia() < ds.get(i).getGia()){
               max = ds.get(i);
           }
       }
       return max;
     }
}


