/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_02;
import Bai_01.SinhVien;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
/**
 * @author PC_MSI
 */
public class Main {
    public static void main(String[] args) {
        // khai bao danh sach sinh vien
        List<SinhVien> dsSinhVien = new ArrayList<>();

        try {
            // doc file sinhvien.txt
            FileReader fr = new FileReader("sinhvien.txt");
            List<String> data = fr.readAllLines();
            for (String line : data) {
                String[] arr = line.split(";"); // ==> arr[0-2]
                dsSinhVien.add(new SinhVien(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
            fr.close();

            System.out.println("=====DANH SACH SINH VIEN DOC TU TAP TIN=====");
            for (SinhVien sv : dsSinhVien) {
                System.out.println(sv);
            }

        } catch (Exception ex) {
            System.out.println("Doc file that bai");
            System.out.println("Loi:" + ex.toString());
        }
    }
    }


