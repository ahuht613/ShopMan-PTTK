/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.HoaDonNhap;

import java.sql.*;
import java.util.ArrayList;

public class HoaDonNhapDAO {
    private Connection con;

    public HoaDonNhapDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<HoaDonNhap> getHoaDonNhapBySupplier(int supplierId) throws SQLException {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        String query = "SELECT id, ngayNhap, tongTien FROM tblHoaDonNhap315 WHERE tblNhaCungCapId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, supplierId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            HoaDonNhap hd = new HoaDonNhap();
            hd.setId(rs.getInt("id"));
            hd.setNgayNhap(rs.getDate("ngayNhap"));
            hd.setTongTien(rs.getDouble("tongTien"));
            list.add(hd);
        }
        return list;
    }
    
    public HoaDonNhap getHoaDonNhapById(int hoaDonNhapId) throws SQLException {
    String query = "SELECT id, ngayNhap FROM tblHoaDonNhap315 WHERE id = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1, hoaDonNhapId);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        hoaDonNhap.setId(rs.getInt("id"));
        hoaDonNhap.setNgayNhap(rs.getDate("ngayNhap"));
        return hoaDonNhap;
    }
    return null;
}

}
