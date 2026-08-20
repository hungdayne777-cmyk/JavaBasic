/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import model.Khoa;
import util.DBConection;

/**
 *
 * @author MSI
 */
public class KhoaDao {

    public List<Khoa> findAll() {
        List<Khoa> ds = new ArrayList<>();
        String sql = "SELECT * FROM KHOA";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String maKH = rs.getString("MaKhoa");
                String tenKH = rs.getString("TenKhoa");

                ds.add(new Khoa(maKH, tenKH));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc dữ liệu: " + e.getMessage());
        }
        return ds;
    }

    public Khoa findById(String maKH) {
        String sql = "SELECT * FROM KHOA WHERE MaKhoa=?";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maKH);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Khoa(
                            rs.getString("MaKhoa"),
                            rs.getString("TenKhoa")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
        return null;
    }

    public boolean delete(String maKH) {
        String sql = "DELETE FROM KHOA WHERE MaKhoa=?";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maKH);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
        return false;
    }

    public boolean insert(Khoa kh) {
        String sql = "INSERT INTO KHOA VALUES (?, ?)";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getMaKhoa());
            ps.setString(2, kh.getTenKhoa());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println("Lỗi khi thêm dữ liệu: " + e.getMessage());
        }
        return false;
    }

    public boolean update(Khoa kh) {
        String sql = "UPDATE KHOA SET TenKhoa = ? WHERE MaKhoa = ?";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getTenKhoa());

            ps.setString(2, kh.getMaKhoa());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật dữ liệu: " + e.getMessage());
        }
        return false;
    }
    public List<Khoa> findByName(String name) {
        List<Khoa> ds = new ArrayList<>();
        String sql = "SELECT * FROM KHOA WHERE TenKhoa LIKE ? OR MaKhoa LIKE ?";
        
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + name + "%");
             ps.setString(2, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String maKH = rs.getString("MaKhoa");
                    String tenKH = rs.getString("TenKhoa");
                
                    
                    ds.add(new Khoa(maKH, tenKH));
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm theo tên: " + e.getMessage());
        }
        return ds;
    }
}
