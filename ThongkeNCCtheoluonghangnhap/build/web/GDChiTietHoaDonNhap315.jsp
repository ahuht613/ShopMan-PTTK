<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.HoaDonNhapChiTiet" %>
<%@ page import="model.HoaDonNhap" %>
<html>
<head>
    <title>Chi Tiết Hóa Đơn Nhập</title>
</head>
<body>
    <%
        HoaDonNhap hoaDonNhap = (HoaDonNhap) request.getAttribute("hoaDonNhap");
        double tongTien = (double) request.getAttribute("tongTien");
        ArrayList<HoaDonNhapChiTiet> details = (ArrayList<HoaDonNhapChiTiet>) request.getAttribute("details");
    %>

    <h1>Chi Tiết Hóa Đơn Nhập</h1>
    <p><strong>Mã hóa đơn:</strong> <%= hoaDonNhap.getId() %></p>
    <p><strong>Ngày nhập:</strong> <%= hoaDonNhap.getNgayNhap() %></p>

    <table border="1">
        <tr>
            <th>TT</th>
            <th>Tên hàng hóa</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        <%
            int stt = 1;
            for (HoaDonNhapChiTiet detail : details) {
        %>
        <tr>
            <td><%= stt++ %></td>
            <td><%= detail.getTenMatHang() %></td>
            <td><%= detail.getGia() %></td>
            <td><%= detail.getSoLuong() %></td>
            <td><%= detail.getThanhTien() %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="4"><strong>Tổng tiền</strong></td>
            <td><%= tongTien %></td>
        </tr>
    </table>
</body>
</html>
