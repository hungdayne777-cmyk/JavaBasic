/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong03_BaiTap03;

/**
 *
 * @author MSI
 */
public class HinhChuNhat implements HinhHoc{
    public double chieuDai;
       public double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public HinhChuNhat() {
    }
     public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }


    @Override
    public double tinhDienTich() {
    return chieuDai * chieuRong;
    }

   
    @Override
    public double tinhChuVi() {
      return (chieuDai+chieuRong)*2;
    }

    @Override
    public void HienThiThongTin() {
        System.out.println("----------HINH CHU NHAT----------");
         System.out.println("Dien tich hinh chu nhat: " +tinhDienTich());
         System.out.println("Chu vi hinh chu nhat: " +tinhChuVi());
    }
}
