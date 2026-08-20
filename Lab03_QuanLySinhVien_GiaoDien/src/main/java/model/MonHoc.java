/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.*;

/**
 *
 * @author MSI
 */
public class MonHoc {
    private String MaMH;
        private String TenMH;
            private int SoTC;

    public MonHoc() {
    }

    public MonHoc(String MaMH, String TenMH, int SoTC) {
        this.MaMH = MaMH;
        this.TenMH = TenMH;
        this.SoTC = SoTC;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String TenMH) {
        this.TenMH = TenMH;
    }

    public int getSoTC() {
        return SoTC;
    }

    public void setSoTC(int SoTC) {
        this.SoTC = SoTC;
    }

    @Override
    public String toString() {
         return this.MaMH.trim()+"-"+this.TenMH ;
    }
            
    
}
