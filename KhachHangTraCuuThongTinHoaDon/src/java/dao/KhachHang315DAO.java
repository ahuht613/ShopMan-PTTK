/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KhachHang315;

public class KhachHang315DAO {
    private Connection con;

    public KhachHang315DAO(Connection con) {
        this.con = con;
    }

    // Lấy thông tin khách hàng theo mã khách hàng
    public KhachHang315 getKhachHangById(String maKH) throws SQLException {
        String query = "SELECT kh.maKH, tv.hoten AS tenKH, tv.diachi, tv.email, tv.sdt " +
                       "FROM tblKhachHang315 kh " +
                       "JOIN tblThanhvien315 tv ON kh.tblThanhvienId = tv.id " +
                       "WHERE kh.maKH = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maKH);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            KhachHang315 khachHang = new KhachHang315();
            khachHang.setMaKH(rs.getString("maKH"));
            khachHang.setTenKH(rs.getString("tenKH")); // Tên từ bảng tblThanhvien315
            khachHang.setDiaChi(rs.getString("diachi"));
            khachHang.setEmail(rs.getString("email"));
            khachHang.setSdt(rs.getString("sdt"));
            return khachHang;
        }
        return null; // Không tìm thấy khách hàng
    }
}

