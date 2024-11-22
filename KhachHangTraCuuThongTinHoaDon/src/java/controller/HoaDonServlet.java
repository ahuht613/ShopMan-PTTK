package controller;

import dao.HoaDonBan315DAO;
import dao.KhachHang315DAO; // Import DAO để lấy thông tin khách hàng
import model.HoaDonBan315;
import model.KhachHang315; // Import lớp model khách hàng
import java.text.NumberFormat;
import java.util.Locale;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

 // Định nghĩa đường dẫn servlet
public class HoaDonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");

        if (con == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database connection is not available.");
            return;
        }

        try {
            String customerId = "KH001"; 

            // Lấy thông tin khách hàng
            KhachHang315DAO khachHangDAO = new KhachHang315DAO(con);
            KhachHang315 khachHang = khachHangDAO.getKhachHangById(customerId);

            if (khachHang == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer not found.");
                return;
            }

            // Lấy danh sách hóa đơn của khách hàng
            HoaDonBan315DAO hoaDonDAO = new HoaDonBan315DAO(con);
            ArrayList<HoaDonBan315> hoaDons = hoaDonDAO.getHoaDonByKhachHang(customerId);

            // Định dạng giá trị tổng tiền
            NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
            for (HoaDonBan315 hoaDon : hoaDons) {
                String formattedPrice = currencyFormat.format(hoaDon.getTongTien());
                hoaDon.setFormattedTongTien(formattedPrice);
            }

            // Truyền thông tin khách hàng và danh sách hóa đơn sang JSP
            request.setAttribute("khachHang", khachHang); // Tên khách hàng
            request.setAttribute("hoaDons", hoaDons); // Danh sách hóa đơn

            // Chuyển hướng tới giao diện JSP
            request.getRequestDispatcher("GDDanhSachHoaDon.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
        }
    }
}