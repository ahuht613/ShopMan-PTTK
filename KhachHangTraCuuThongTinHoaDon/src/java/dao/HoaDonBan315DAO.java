/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.HoaDonBan315;

import java.sql.*;
import java.util.ArrayList;

public class HoaDonBan315DAO {
    private Connection con;

    public HoaDonBan315DAO(Connection con) {
        this.con = con;
    }

    public ArrayList<HoaDonBan315> getHoaDonByKhachHang(String maKH) throws SQLException {
        ArrayList<HoaDonBan315> hoaDonList = new ArrayList<>();
        String query = "SELECT id, ngaydat, tongTien, trangThai FROM tblHoaDonBan315 WHERE tblKhachHangId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maKH);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            HoaDonBan315 hoaDon = new HoaDonBan315();
            hoaDon.setId(rs.getInt("id"));
            hoaDon.setNgayDat(rs.getDate("ngaydat")); // Gán giá trị ngày đặt
            hoaDon.setTongTien(rs.getDouble("tongTien"));
            hoaDon.setTrangThai(rs.getString("trangThai"));
            hoaDonList.add(hoaDon);
        }
        return hoaDonList;
    }
    public String getCustomerIdByHoaDon(int hoaDonId) throws SQLException {
        String query = "SELECT tblKhachHangId FROM tblHoaDonBan315 WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, hoaDonId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("tblKhachHangId");
        }
        return null; // Nếu không tìm thấy
    }
}
