/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.HoaDonNhapDAO;
import model.HoaDonNhap;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ChiTietNhapHangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy kết nối database từ ServletContext
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            HoaDonNhapDAO hoaDonNhapDAO = new HoaDonNhapDAO(con);

            // Lấy id nhà cung cấp từ URL
            int supplierId = Integer.parseInt(request.getParameter("id"));

            // Lấy danh sách các lần nhập hàng từ DAO
            ArrayList<HoaDonNhap> orders = hoaDonNhapDAO.getHoaDonNhapBySupplier(supplierId);

            // Gửi dữ liệu đến JSP
            request.setAttribute("orders", orders);
            RequestDispatcher dispatcher = request.getRequestDispatcher("GDXemCacLanNhapHang315.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
