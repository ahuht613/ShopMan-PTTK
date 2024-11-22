/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.HoaDonNhapChiTiet;

import java.sql.*;
import java.util.ArrayList;

public class HoaDonNhapChiTietDAO {
    private Connection con;

    public HoaDonNhapChiTietDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<HoaDonNhapChiTiet> getChiTietByHoaDonNhapId(int hoaDonNhapId) throws SQLException {
        ArrayList<HoaDonNhapChiTiet> list = new ArrayList<>();
        String query = "SELECT HCT.id, MH.ten AS tenMatHang, HCT.soLuong, HCT.gia, (HCT.soLuong * HCT.gia) AS thanhTien " +
                       "FROM tblHoaDonNhapChiTiet315 HCT " +
                       "JOIN tblMatHang315 MH ON HCT.tblMatHangId = MH.id " +
                       "WHERE HCT.tblHoaDonNhapId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, hoaDonNhapId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            HoaDonNhapChiTiet detail = new HoaDonNhapChiTiet();
            detail.setId(rs.getInt("id"));
            detail.setTenMatHang(rs.getString("tenMatHang")); // Thêm tên mặt hàng
            detail.setSoLuong(rs.getInt("soLuong"));
            detail.setGia(rs.getDouble("gia"));
            detail.setThanhTien(rs.getDouble("thanhTien")); // Thêm thành tiền
            list.add(detail);
        }
        return list;
    }

    public double getTongTienByHoaDonNhapId(int hoaDonNhapId) throws SQLException {
        String query = "SELECT SUM(soLuong * gia) AS tongTien " +
                       "FROM tblHoaDonNhapChiTiet315 WHERE tblHoaDonNhapId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, hoaDonNhapId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getDouble("tongTien");
        }
        return 0;
    }
}
