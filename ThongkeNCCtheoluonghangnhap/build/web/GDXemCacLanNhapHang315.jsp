<%-- 
    Document   : GDXemCacLanNhapHang315
    Created on : Nov 22, 2024, 8:01:01 AM
    Author     : Thu Ha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.HoaDonNhap" %>
<html>
<head>
    <title>Các Lần Nhập Hàng</title>
</head>
<body>
    <h1>Danh Sách Các Lần Nhập Hàng</h1>
    <%
        ArrayList<HoaDonNhap> orders = (ArrayList<HoaDonNhap>) request.getAttribute("orders");
        if (orders != null && !orders.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>ID Hóa Đơn</th>
                <th>Ngày Nhập</th>
                <th>Tổng Tiền</th>
            </tr>
            <%
                for (HoaDonNhap order : orders) {
            %>
            <tr>
                <td><a href="ChiTietHoaDonNhapServlet?id=<%= order.getId() %>"><%= order.getId() %></a></td>
                <td><%= order.getNgayNhap() %></td>
                <td><%= order.getTongTien() %></td>
            </tr>
            <% } %>
        </table>
    <% } else { %>
        <p>Không có lần nhập hàng nào được ghi nhận.</p>
    <% } %>
</body>
</html>
