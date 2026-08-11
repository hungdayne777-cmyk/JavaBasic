/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong_03._BaiTap02;

/**
 *
 * @author MSI
 */
public class NhanVienVanPhong extends NhanVien{
    private int soNgayLamViec;

    public NhanVienVanPhong(int soNgayLamViec, String hoTen, double luongCoBan) {
        super(hoTen, luongCoBan);
        this.soNgayLamViec = soNgayLamViec;
    }

    public NhanVienVanPhong(int soNgayLamViec) {
        super(" ",0);
        this.soNgayLamViec = soNgayLamViec;
    }

   
    public NhanVienVanPhong() {
    }
    @Override
    public double tinhLuong(){
        return luongCoBan + soNgayLamViec * 100000;
    }

    @Override
    public void HienThiThongTin() {
      System.out.println("===Nhan Vien Van Phong===");
      super.HienThiThongTin();
       System.out.print("So Ngay Lam Viec: " + soNgayLamViec);
    
}
}
