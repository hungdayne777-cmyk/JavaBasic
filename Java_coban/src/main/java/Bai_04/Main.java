/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_04;
import Bai_03.*;
import Bai_02.*;
import Bai_01.SinhVien;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author PC_33
 */
public class Main {
    public static void main(String[] args) {
            List<SinhVien> dsSinhVien = new ArrayList<>();

        try {
            FileReader fr = new FileReader("sinhvien.txt");
            List<String> data = fr.readAllLines();
            for (String line : data) {
                String[] arr = line.split(";");
                dsSinhVien.add(new SinhVien(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
            fr.close();

            // Sắp xếp danh sách sinh viên giảm dần theo dtb
            Collections.sort(dsSinhVien, (sv1, sv2) -> Double.compare(sv2.getDiemTB(), sv1.getDiemTB()));

            // Ghi ra tập tin sinhvien_sorted.txt
            try {
                FileWriter fw = new FileWriter("sinhvien_sorted.txt");
                for (SinhVien sv : dsSinhVien) {
                    fw.write(sv.getMaSV() + ";" + sv.getHoTen() + ";" + sv.getDiemTB() + "\n");
                }
                fw.close();
                System.out.println("Ghi danh sach sinh vien sau khi ra tap tin sinhvien_sorted.txt thanh cong");
            } catch (Exception ex) {
                System.out.println("Ghi sinh vien that bai");
                System.out.println("Loi:" + ex.toString());
            }

        } catch (Exception ex) {
            System.out.println("Doc file that bai");
            System.out.println("Loi:" + ex.toString());
        }
    }
}
