/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.HoaDonNhapChiTietDAO;
import dao.HoaDonNhapDAO;
import model.HoaDonNhapChiTiet;
import model.HoaDonNhap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ChiTietHoaDonNhapServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            HoaDonNhapChiTietDAO hoaDonNhapChiTietDAO = new HoaDonNhapChiTietDAO(con);
            HoaDonNhapDAO hoaDonNhapDAO = new HoaDonNhapDAO(con);

            int hoaDonNhapId = Integer.parseInt(request.getParameter("id"));

            ArrayList<HoaDonNhapChiTiet> details = hoaDonNhapChiTietDAO.getChiTietByHoaDonNhapId(hoaDonNhapId);
            double tongTien = hoaDonNhapChiTietDAO.getTongTienByHoaDonNhapId(hoaDonNhapId);

            HoaDonNhap hoaDonNhap = hoaDonNhapDAO.getHoaDonNhapById(hoaDonNhapId); // Lấy thông tin hóa đơn

            request.setAttribute("details", details);
            request.setAttribute("tongTien", tongTien);
            request.setAttribute("hoaDonNhap", hoaDonNhap);
            RequestDispatcher dispatcher = request.getRequestDispatcher("GDChiTietHoaDonNhap315.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}