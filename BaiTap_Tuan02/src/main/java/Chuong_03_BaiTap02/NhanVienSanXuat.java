/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chuong_03._BaiTap02;

/**
 *
 * @author MSI
 */
public class NhanVienSanXuat extends NhanVien{
    private int soSanPham;

    public NhanVienSanXuat(int soSanPham, String hoTen, double luongCoBan) {
        super(hoTen, luongCoBan);
        this.soSanPham = soSanPham;
    }

    
    public NhanVienSanXuat() {
    }
     @Override
    public double tinhLuong(){
        return luongCoBan + soSanPham * 20000;
    }
    @Override
    public void HienThiThongTin() {
      System.out.println("===Nhan Vien San Xuat===");
      super.HienThiThongTin();
       System.out.print("So San Pham: " + soSanPham);
    
}

}
