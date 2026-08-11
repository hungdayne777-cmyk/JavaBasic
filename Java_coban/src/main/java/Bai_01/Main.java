/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_01;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
/**
 *
 * @author MSI
 */
public class Main {
    public static void main(String[] args) {
         ArrayList<SinhVien> dsSinhVien = new ArrayList();
    dsSinhVien.add(new SinhVien("SV01", "Nguyễn Thái Hưng", 8.5));
    dsSinhVien.add(new SinhVien("SV02", "Lê Thị Phương", 7.5));
    dsSinhVien.add(new SinhVien("SV03", "Nguyễn Văn Cường", 8.0));
    dsSinhVien.add(new SinhVien("SV04", "Trần Văn An", 9.5));
    dsSinhVien.add(new SinhVien("SV05", "Nguyễn Văn Mạnh", 4.5));
    dsSinhVien.add(new SinhVien("SV06", "Trần Thị Tâm", 6.5));
    
    //xuất danh sách sinh viên ra màn hình
    System.out.println("=====DANH SACH SINH VIEN=====");
    for(SinhVien sv : dsSinhVien){
        System.out.println(sv.getMaSV()+ ";" + sv.getHoTen()+ ";"+ sv.getDiemTB());
    }
    //xuất ra tập tin sinh viên
        try {
            FileWriter fw = new FileWriter("SinhVien.txt");
            for(SinhVien sv : dsSinhVien){
             fw.write(sv.getMaSV()+ ";" + sv.getHoTen()+ ";"+ sv.getDiemTB()+ "\n");  
   }
            fw.close();
            System.out.println("Đã ghi danh sách sinh viên vào tập tin SinhVien.txt thành công");
        } catch (Exception ex) {
            System.out.println("Ghi danh sách thất bại");
            System.out.println("Loi:" + ex.toString());
        }
    }
                 
            
            
   
            
            
}
