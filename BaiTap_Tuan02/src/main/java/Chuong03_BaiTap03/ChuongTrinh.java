/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong03_BaiTap03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class ChuongTrinh {
    public static void main(String[] args) {
         ArrayList<HinhHoc> ds = new ArrayList<>();
        NhapDSHinhHoc(ds);
                System.out.println("--------Danh sach hinh hoc---------");
        XuatDSHinhHoc(ds);
    }
     public static void NhapDSHinhHoc(ArrayList<HinhHoc> ds) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Cho biet so luong hinh can nhap: ");
        int n = sc.nextInt();
 sc.nextLine();
 for(int i = 0;i<n;i++){
  System.out.println("\n---------- Nhap Hinh thu " + (i + 1) + " ----------");
            System.out.println("1. Hinh Tron");
            System.out.println("2. Hinh Chu Nhat");
            System.out.print("Chon loai Hinh Hoc (1/2): ");
            int loai = Integer.parseInt(sc.nextLine());

           
           if (loai == 1)
           {
                System.out.print("Cho biet ban kinh: ");
                double banKinh = Double.parseDouble(sc.nextLine());
              
                HinhHoc hh = new HinhTron (banKinh);
                ds.add(hh);
            } 
           else if (loai == 2) {
                System.out.print("Cho biet chieu dai ");
                double chieuDai = Double.parseDouble(sc.nextLine());
               double chieuRong = Double.parseDouble(sc.nextLine());
                HinhHoc hh = new HinhChuNhat(chieuDai,chieuRong);
                ds.add(hh);
            } else {
                System.out.println("Loai HINH HOC khong hop le");
            }
        }
    }
     public static void XuatDSHinhHoc(ArrayList<HinhHoc> ds) {
        for (HinhHoc x : ds) {
            x.HienThiThongTin();
            System.out.println("----------------------------------");
        }
     }
}
