/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.NhaCungCapDAO;
import model.NhaCungCap;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public class ThongKeNhaCungCapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(con);

            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));

            ArrayList<NhaCungCap> suppliers = nhaCungCapDAO.getNhaCungCapTheoThoiGian(startDate, endDate);

            request.setAttribute("suppliers", suppliers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("GDTKNhaCungCap315.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}