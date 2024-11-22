/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.NhaCungCap;

import java.sql.*;
import java.util.ArrayList;

public class NhaCungCapDAO {
    private Connection con;

    public NhaCungCapDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<NhaCungCap> getNhaCungCapTheoThoiGian(Date startDate, Date endDate) throws SQLException {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String query = "SELECT NCC.id, NCC.ten, SUM(HCT.soLuong) as totalQuantity "
                     + "FROM tblNhaCungCap315 NCC "
                     + "JOIN tblHoaDonNhap315 HN ON NCC.id = HN.tblNhaCungCapId "
                     + "JOIN tblHoaDonNhapChiTiet315 HCT ON HN.id = HCT.tblHoaDonNhapId "
                     + "WHERE HN.ngayNhap BETWEEN ? AND ? "
                     + "GROUP BY NCC.id, NCC.ten "
                     + "ORDER BY totalQuantity DESC";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDate(1, startDate);
        ps.setDate(2, endDate);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setId(rs.getInt("id"));
            ncc.setTen(rs.getString("ten"));
            ncc.setTotalQuantity(rs.getInt("totalQuantity"));
            list.add(ncc);
        }
        return list;
    }
}

