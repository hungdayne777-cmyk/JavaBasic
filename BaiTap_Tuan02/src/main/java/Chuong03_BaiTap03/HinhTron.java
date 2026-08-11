/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong03_BaiTap03;

/**
 *
 * @author MSI
 */
public class HinhTron implements HinhHoc{
    public double banKinh;

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    public HinhTron() {
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * banKinh*banKinh;
    }

    @Override
    public double tinhChuVi() {
     return 2*Math.PI * banKinh;
     
            }

    @Override
    public void HienThiThongTin() {
        System.out.println("----------HINH TRON----------");
        System.out.println("Dien tich hinh tron: " +tinhDienTich() );
         System.out.println("Chu vi hinh tron: " +tinhChuVi());
        }
   
}
