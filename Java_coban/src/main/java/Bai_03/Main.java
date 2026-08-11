/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_03;
import Bai_02.*;
import Bai_01.SinhVien;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MSI
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

            System.out.println("=====DANH SACH TAT CA SINH VIEN DOC TU TAP TIN SINHVIEN.TXT=====");
            for (SinhVien sv : dsSinhVien) {
                System.out.println(sv);
            }

            System.out.println("=====DANH SACH SINH VIEN DIEM TB>=8 =====");
            for (SinhVien sv : dsSinhVien) {
                if (sv.getDiemTB() >= 8) {
                    System.out.println(sv);
                }
            }

        } catch (Exception ex) {
            System.out.println("Doc file that bai");
            System.out.println("Loi:" + ex.toString());
        }
    }
    }

