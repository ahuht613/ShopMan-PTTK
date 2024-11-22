<%-- 
    Document   : GDTKNhaCungCap315
    Created on : Nov 22, 2024, 8:00:42 AM
    Author     : Thu Ha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.NhaCungCap" %>
<html>
<head>
    <title>Thống Kê Nhà Cung Cấp</title>
</head>
<body>
    <h1>Thống Kê Nhà Cung Cấp</h1>
    <form method="post" action="ThongKeNhaCungCapServlet">
        <label for="startDate">Ngày Bắt Đầu:</label>
        <input type="date" id="startDate" name="startDate" required>
        <br>
        <label for="endDate">Ngày Kết Thúc:</label>
        <input type="date" id="endDate" name="endDate" required>
        <br>
        <button type="submit">Thống Kê</button>
    </form>

    <%
        ArrayList<NhaCungCap> suppliers = (ArrayList<NhaCungCap>) request.getAttribute("suppliers");
        if (suppliers != null && !suppliers.isEmpty()) {
    %>
        <h2>Kết Quả Thống Kê:</h2>
        <table border="1">
            <tr>
                <th>ID Nhà Cung Cấp</th>
                <th>Tên Nhà Cung Cấp</th>
                <th>Tổng Lượng Hàng Nhập</th>
            </tr>
            <%
                for (NhaCungCap ncc : suppliers) {
            %>
            <tr>
                <td><%= ncc.getId() %></td>
                <td><a href="ChiTietNhapHangServlet?id=<%= ncc.getId() %>"><%= ncc.getTen() %></a></td>
                <td><%= ncc.getTotalQuantity() %></td>
            </tr>
            <% } %>
        </table>
    <% } else if (suppliers != null) { %>
        <p>Không có dữ liệu thống kê trong khoảng thời gian đã chọn.</p>
    <% } %>
</body>
</html>
