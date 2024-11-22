/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import model.HoaDonBanChiTiet315;
import model.MatHang315;
import java.text.NumberFormat;
import java.util.Locale;
public class HoaDonBanChiTiet315DAO {
    private Connection con;

    public HoaDonBanChiTiet315DAO(Connection con) {
        this.con = con;
    }

   public ArrayList<HoaDonBanChiTiet315> getChiTietHoaDon(int hoaDonBanId) throws SQLException {
    ArrayList<HoaDonBanChiTiet315> chiTietList = new ArrayList<>();
    String query = "SELECT c.soLuong, c.gia, m.ten " +
                   "FROM tblHoaDonBanChiTiet315 c " +
                   "JOIN tblMatHang315 m ON c.tblMatHangId = m.id " +
                   "WHERE c.tblHoaDonBanId = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, hoaDonBanId);
    ResultSet rs = ps.executeQuery();

    NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

    while (rs.next()) {
        HoaDonBanChiTiet315 chiTiet = new HoaDonBanChiTiet315();
        chiTiet.setSoLuong(rs.getInt("soLuong"));
        chiTiet.setGia(rs.getDouble("gia"));

        MatHang315 matHang = new MatHang315();
        matHang.setTen(rs.getString("ten"));
        chiTiet.setMatHang(matHang);

        // Định dạng giá trị gia
        chiTiet.setFormattedGia(currencyFormat.format(rs.getDouble("gia")));

        chiTietList.add(chiTiet);
    }
    return chiTietList;
}



}

