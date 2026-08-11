/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong_03._BaiTap02;

/**
 *
 * @author MSI
 */
public abstract class NhanVien {
    private String hoTen;
    public double luongCoBan;
    public abstract double tinhLuong();

   

    public NhanVien(String hoTen, double luongCoBan) {
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien() {
    }
    public void HienThiThongTin(){
        System.out.println("Ho Ten: " + hoTen);
        System.out.printf("Luong co ban: "+ luongCoBan);
        System.out.printf("Luong thuc nhan: "+ tinhLuong());
    }
}
