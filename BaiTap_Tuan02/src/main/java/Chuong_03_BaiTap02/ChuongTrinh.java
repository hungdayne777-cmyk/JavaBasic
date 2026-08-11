/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong_03._BaiTap02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class ChuongTrinh {
    public static void main(String[] args) {
        ArrayList<NhanVien> ds = new ArrayList<>();
        NhapDSNhanVien(ds);
                System.out.println("--------Danh sach nhan vien---------");
        XuatDSNhanVien(ds);
    }
     public static void NhapDSNhanVien(ArrayList<NhanVien> ds) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Cho biet so luong nhan vien can nhap: ");
        int n = sc.nextInt();
 sc.nextLine();
 for(int i = 0;i<n;i++){
  System.out.println("\n---------- Nhap nhan vien thu " + (i + 1) + " ----------");
            System.out.println("1. Nhan vien van phong");
            System.out.println("2. Nhan vien san xuat");
            System.out.print("Chon loai nhan vien (1/2): ");
            int loai = Integer.parseInt(sc.nextLine());

            System.out.print("Cho biet ho ten: ");
            String hoTen = sc.nextLine();

            System.out.print("Cho biet luong co ban: ");
            double luongCB = Double.parseDouble(sc.nextLine());
           if (loai == 1)
           {
                System.out.print("Cho biet so ngay lam viec: ");
                int soNgay = Integer.parseInt(sc.nextLine());
              
                NhanVien nv = new NhanVienVanPhong(soNgay, hoTen, luongCB);
                ds.add(nv);
            } 
           else if (loai == 2) {
                System.out.print("Cho biet so san pham: ");
                int soSP = Integer.parseInt(sc.nextLine());
              
                NhanVien nv = new NhanVienSanXuat(soSP, hoTen, luongCB);
                ds.add(nv);
            } else {
                System.out.println("Loai khong hop le, bo qua nhan vien nay");
            }
        }
    }
     public static void XuatDSNhanVien(ArrayList<NhanVien> ds) {
        for (NhanVien x : ds) {
            x.HienThiThongTin();
            System.out.println("----------------------------------");
        }
    }
}
