/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Date;

/**
 *
 * @author MSI
 */
public class DangKy {
    private String MaSVDK;
     private String MaMHDK;
      private Date NgayDK;
       private int DiemQT;
       private int DiemThi;
       private int DiemTK;

    public DangKy() {
    }

    public DangKy(String MaSVDK, String MaMHDK, Date NgayDK, int DiemQT, int DiemThi, int DiemTK) {
        this.MaSVDK = MaSVDK;
        this.MaMHDK = MaMHDK;
        this.NgayDK = NgayDK;
        this.DiemQT = DiemQT;
        this.DiemThi = DiemThi;
        this.DiemTK = DiemTK;
    }

    public String getMaSVDK() {
        return MaSVDK;
    }

    public void setMaSVDK(String MaSVDK) {
        this.MaSVDK = MaSVDK;
    }

    public String getMaMHDK() {
        return MaMHDK;
    }

    public void setMaMHDK(String MaMHDK) {
        this.MaMHDK = MaMHDK;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

    public int getDiemQT() {
        return DiemQT;
    }

    public void setDiemQT(int DiemQT) {
        this.DiemQT = DiemQT;
    }

    public int getDiemThi() {
        return DiemThi;
    }

    public void setDiemThi(int DiemThi) {
        this.DiemThi = DiemThi;
    }

    public int getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(int DiemTK) {
        this.DiemTK = DiemTK;
    }

    @Override
    public String toString() {
        return "DangKy{" + "MaSVDK=" + MaSVDK + ", MaMHDK=" + MaMHDK + ", NgayDK=" + NgayDK + ", DiemQT=" + DiemQT + ", DiemThi=" + DiemThi + ", DiemTK=" + DiemTK + '}';
    }
       
}
