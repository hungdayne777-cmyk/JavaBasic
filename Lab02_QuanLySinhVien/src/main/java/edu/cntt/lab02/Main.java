/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cntt.lab02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author PC_33
 */
public class Main {
// Chuỗi kết nối SQL Server

    private static final String URL
            = "jdbc:sqlserver://PC-34\\SQLEXPRESS01:1433;" //DESKTOP-1V4LFQF\MSSQLSERVER01:1433; (server dùng ở nhà) ,//PC-34\\SQLEXPRESS01:1433;(server dùng trên lớp)
            + "databaseName=QLGiaoVu;"
            + "encrypt=true;"
            + "trustServerCertificate=true";
// Tài khoản đăng nhập SQL Server
    private static final String USER = "sa";
// Mật khẩu SQL Server
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Hiển thị danh sách sinh viên");
                    hienThiDanhSach();
                    break;

                case 2:
                    themSinhVien();

                    break;
                case 3:
                    capNhatSinhVien();
                    break;
                case 4:
                    xoaSinhVien();
                    break;
                case 5:
                    timSinhVienTheoMa();
                    break;
                case 6:
                    timSinhVienTheoTen();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối SQL Server thành công.");
        } catch (SQLException e) {
            System.out.println("Không thể kết nối SQL Server!");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void menu() {
        System.out.println();
        System.out.println("=========================================");
        System.out.println(" QUẢN LÝ SINH VIÊN");
        System.out.println("=========================================");
        System.out.println("1. Hiển thị danh sách sinh viên");

        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm theo mã");
        System.out.println("6. Tìm theo tên");
        System.out.println("0. Thoát");
        System.out.println("=========================================");
        System.out.print("Nhập lựa chọn: ");
    }

    //hiển thị danh sách
    public static void hienThiDanhSach() {
        String sql = "SELECT * FROM SINHVIEN";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            System.out.println();
            System.out.println("DANH SÁCH SINH VIÊN");
            System.out.println("----------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                    "Mã SV", "Họ tên", "Ngày sinh", "GT", "Địa chỉ", "Khoa");
            System.out.println("----------------------------------------------------------------------------");
            while (rs.next()) {
                String maSV = rs.getString("MaSV");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                String diaChi = rs.getString("DiaChi");
                String maKhoa = rs.getString("MaKhoa");
                System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                        maSV, hoTen, ngaySinh, gioiTinh ? "Nam" : "Nữ", diaChi, maKhoa);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc dữ liệu!");
            System.out.println(e.getMessage());
        }
    }

    //thêm sinh viên
    public static void themSinhVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTHÊM SINH VIÊN");
        System.out.print("Mã sinh viên: ");
        String maSV = sc.nextLine();
        System.out.print("Họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Ngày sinh (yyyy-MM-dd): ");
        String ngaySinh = sc.nextLine();
        System.out.print("Giới tính (1-Nam, 0-Nữ): ");
        boolean gioiTinh = sc.nextInt() == 1;
        sc.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = sc.nextLine();
        System.out.print("Mã khoa: ");
        String maKhoa = sc.nextLine();
        String sql = "INSERT INTO SINHVIEN VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, maSV);
            ps.setString(2, hoTen);
            ps.setDate(3, java.sql.Date.valueOf(ngaySinh));
            ps.setBoolean(4, gioiTinh);
            ps.setString(5, diaChi);
            ps.setString(6, maKhoa);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("\nThêm sinh viên thành công.");
            } else {
                System.out.println("\nKhông thể thêm sinh viên.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    //cập nhật sinh viên
    public static void capNhatSinhVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String maSV = sc.nextLine();
        String sqlFind = "SELECT * FROM SINHVIEN WHERE MaSV = ?";
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement psFind = conn.prepareStatement(sqlFind);) {
            psFind.setString(1, maSV);
            ResultSet rs = psFind.executeQuery();
            if (!rs.next()) {
                System.out.println("Không tìm thấy sinh viên.");
                return;
            }
            System.out.println("\nThông tin hiện tại");
            System.out.println("Họ tên : " + rs.getString("HoTen"));
            System.out.println("Ngày sinh : " + rs.getDate("NgaySinh"));
            System.out.println("Giới tính : " + (rs.getBoolean("GioiTinh") ? "Nam" : "Nữ"));
            System.out.println("Địa chỉ : " + rs.getString("DiaChi"));
            System.out.println("Mã khoa : " + rs.getString("MaKhoa"));
            System.out.println("\nNhập thông tin mới");
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Ngày sinh (yyyy-MM-dd): ");
            String ngaySinh = sc.nextLine();
            System.out.print("Giới tính (1-Nam, 0-Nữ): ");
            boolean gioiTinh = sc.nextInt() == 1;
            sc.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();

            System.out.print("Mã khoa: ");
            String maKhoa = sc.nextLine();
            String sqlUpdate = """
UPDATE SINHVIEN
SET HoTen = ?,
NgaySinh = ?,
GioiTinh = ?,
DiaChi = ?,
MaKhoa = ?
WHERE MaSV = ?
""";
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setString(1, hoTen);
                psUpdate.setDate(2, java.sql.Date.valueOf(ngaySinh));
                psUpdate.setBoolean(3, gioiTinh);
                psUpdate.setString(4, diaChi);
                psUpdate.setString(5, maKhoa);
                psUpdate.setString(6, maSV);
                int rows = psUpdate.executeUpdate();
                if (rows > 0) {
                    System.out.println("\nCập nhật thành công.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //xóa sinh viên
    public static void xoaSinhVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String maSV = sc.nextLine();
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);) {
//==========================
// Kiểm tra sinh viên tồn tại
//==========================
            String sqlFind
                    = "SELECT * FROM SINHVIEN WHERE MaSV=?";
            PreparedStatement psFind
                    = conn.prepareStatement(sqlFind);
            psFind.setString(1, maSV);
            ResultSet rs = psFind.executeQuery();
            if (!rs.next()) {
                System.out.println("Không tìm thấy sinh viên.");
                return;
            }
            System.out.println();
            System.out.println("Thông tin sinh viên");
            System.out.println("------------------------------");
            System.out.println("Mã SV : " + rs.getString("MaSV"));
            System.out.println("Họ tên : " + rs.getString("HoTen"));
            System.out.println("Địa chỉ : " + rs.getString("DiaChi"));
            System.out.println("------------------------------");
            System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
            String answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("Y")) {
                System.out.println("Đã hủy thao tác.");
                return;
            }
//==========================
// Xóa sinh viên

//==========================
            String sqlDelete
                    = "DELETE FROM SINHVIEN WHERE MaSV=?";
            PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
            psDelete.setString(1, maSV);
            int rows = psDelete.executeUpdate();
            if (rows > 0) {
                System.out.println();
                System.out.println("Xóa sinh viên thành công.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void timSinhVienTheoTen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====TÌM SINH VIÊN THEO TÊN=====");
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String timSV = sc.nextLine();
        String sql = "SELECT * FROM SINHVIEN WHERE HoTen LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + timSV + "%");

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println();
                System.out.println("DANH SÁCH SINH VIÊN TÌM THẤY");
                System.out.println("----------------------------------------------------------------------------");
                System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                        "Mã SV", "Họ tên", "Ngày sinh", "GT", "Địa chỉ", "Khoa");
                System.out.println("----------------------------------------------------------------------------");

                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    String maSV = rs.getString("MaSV");
                    String hoTen = rs.getString("HoTen");
                    Date ngaySinh = rs.getDate("NgaySinh");
                    boolean gioiTinh = rs.getBoolean("GioiTinh");
                    String diaChi = rs.getString("DiaChi");
                    String maKhoa = rs.getString("MaKhoa");
                    System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                            maSV, hoTen, ngaySinh, gioiTinh ? "Nam" : "Nữ", diaChi, maKhoa);
                }

                if (!hasData) {
                    System.out.println("Không tìm thấy sinh viên nào phù hợp!");
                    System.out.println("----------------------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc dữ liệu!");
            System.out.println(e.getMessage());
        }
    }

    public static void timSinhVienTheoMa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====TÌM SINH VIÊN THEO MÃ=====");
        System.out.println("Nhập mã sinh viên cần tìm: ");
        String timSV = sc.nextLine();
        String sql = "SELECT * FROM SINHVIEN WHERE MaSV = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, timSV);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println();
                System.out.println("DANH SÁCH SINH VIÊN TÌM THẤY");
                System.out.println("----------------------------------------------------------------------------");
                System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                        "Mã SV", "Họ tên", "Ngày sinh", "GT", "Địa chỉ", "Khoa");
                System.out.println("----------------------------------------------------------------------------");

                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    String maSV = rs.getString("MaSV");
                    String hoTen = rs.getString("HoTen");
                    Date ngaySinh = rs.getDate("NgaySinh");
                    boolean gioiTinh = rs.getBoolean("GioiTinh");
                    String diaChi = rs.getString("DiaChi");
                    String maKhoa = rs.getString("MaKhoa");
                    System.out.printf("%-10s %-20s %-12s %-6s %-20s %-10s%n",
                            maSV, hoTen, ngaySinh, gioiTinh ? "Nam" : "Nữ", diaChi, maKhoa);
                }

                if (!hasData) {
                    System.out.println("Không tìm thấy mã sinh viên này!");
                    System.out.println("----------------------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đọc dữ liệu!");
            System.out.println(e.getMessage());
        }
    }
}
