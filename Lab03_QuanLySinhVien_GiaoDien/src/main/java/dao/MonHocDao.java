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
import java.util.List;
import util.DBConection;
import dao.MonHocDao;
import dao.MonHoc;

/**
 *
 * @author MSI
 */
public class MonHocDao {
     public List<MonHoc> findAll() {
        List<MonHoc> ds = new ArrayList<>();
        String sql = "SELECT * FROM MONHOC";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String maMH = rs.getString("MaMH");
                String tenMH = rs.getString("TenMH");
                int soTC = rs.getInt("SoTinChi");

                ds.add(new MonHoc(maMH, tenMH, soTC));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc dữ liệu: " + e.getMessage());
        }
        return ds;
    }

    public MonHoc findById(String maMH) {
        String sql = "SELECT * FROM MONHOC WHERE MaMH=?";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maMH);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new MonHoc(
                            rs.getString("MaMH"),
                            rs.getString("TenMH"),
                            rs.getInt("SoTinChi")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm: " + e.getMessage());
        }
        return null;
    }

    public boolean delete(String maMH) {
        String sql = "DELETE FROM MONHOC WHERE MaMH=?";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maMH);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
        return false;
    }

    public boolean insert(MonHoc mh) {
        String sql = "INSERT INTO MONHOC VALUES (?, ?, ?)";

        try (Connection conn = DBConection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getSoTC());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println("Lỗi khi thêm dữ liệu: " + e.getMessage());
        }
        return false;
    }

    public boolean update(MonHoc mh) {

    String sql = "UPDATE MONHOC SET TenMH = ?, SoTinChi = ? WHERE MaMH = ?";

    try (Connection conn = DBConection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, mh.getTenMH());
        ps.setInt(2, mh.getSoTC());
        ps.setString(3, mh.getMaMH());

        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception e) {
        System.out.println("Lỗi khi cập nhật dữ liệu: " + e.getMessage());
        return false;
    }
}
}
