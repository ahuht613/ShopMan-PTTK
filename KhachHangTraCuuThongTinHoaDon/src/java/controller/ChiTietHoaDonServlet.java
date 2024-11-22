/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDonBan315DAO;
import dao.HoaDonBanChiTiet315DAO;
import dao.KhachHang315DAO;
import model.HoaDonBanChiTiet315;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import model.KhachHang315;



public class ChiTietHoaDonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        if (con == null) {
            response.getWriter().println("Database connection is not available.");
            return;
        }

        try {
            // Lấy mã hóa đơn từ URL
            int hoaDonId = Integer.parseInt(request.getParameter("id"));
            System.out.println("ID hóa đơn nhận được từ URL: " + hoaDonId);

            // Lấy thông tin chi tiết hóa đơn
            HoaDonBanChiTiet315DAO chiTietDAO = new HoaDonBanChiTiet315DAO(con);
            ArrayList<HoaDonBanChiTiet315> chiTietList = chiTietDAO.getChiTietHoaDon(hoaDonId);
            double tongTien = 0;
            for (HoaDonBanChiTiet315 chiTiet : chiTietList) {
                tongTien += chiTiet.getGia() * chiTiet.getSoLuong();
            }

            // Định dạng tổng tiền
            String formattedTongTien = java.text.NumberFormat.getInstance(new java.util.Locale("vi", "VN")).format(tongTien);
            // Lấy thông tin khách hàng liên quan đến hóa đơn
            HoaDonBan315DAO hoaDonDAO = new HoaDonBan315DAO(con);
            String customerId = hoaDonDAO.getCustomerIdByHoaDon(hoaDonId);

            KhachHang315DAO khachHangDAO = new KhachHang315DAO(con);
            KhachHang315 khachHang = khachHangDAO.getKhachHangById(customerId);

            if (khachHang == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer not found for this invoice.");
                return;
            }

            // Truyền dữ liệu sang JSP
            request.setAttribute("chiTietList", chiTietList);
            request.setAttribute("khachHang", khachHang); // Thông tin khách hàng
            request.setAttribute("hoaDonId", hoaDonId); // Mã hóa đơn
            request.setAttribute("tongTien", formattedTongTien);
            System.out.println("Truyền danh sách chi tiết hóa đơn và thông tin khách hàng sang JSP thành công.");
            request.getRequestDispatcher("chiTietHoaDon.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
        }
    }
}
