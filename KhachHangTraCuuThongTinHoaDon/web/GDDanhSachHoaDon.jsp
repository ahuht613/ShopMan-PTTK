<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh sách hóa đơn</title>
</head>
<body>
    <%
        // Lấy thông tin khách hàng từ request
        model.KhachHang315 khachHang = (model.KhachHang315) request.getAttribute("khachHang");
    %>
    <!-- Hiển thị thông tin khách hàng -->
    <h1>Khách hàng: <%= khachHang.getTenKH() %></h1>
    <p>Email: <%= khachHang.getEmail() %></p>
    <p>Số điện thoại: <%= khachHang.getSdt() %></p>

    <!-- Hiển thị bảng danh sách hóa đơn -->
    <h3>Danh sách hóa đơn</h3>
    <table border="1">
        <tr>
            <th>Mã hóa đơn</th>
            <th>Ngày đặt</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <%
            java.util.List<model.HoaDonBan315> hoaDons = (java.util.List<model.HoaDonBan315>) request.getAttribute("hoaDons");
            if (hoaDons != null && !hoaDons.isEmpty()) {
                for (model.HoaDonBan315 hoaDon : hoaDons) {
        %>
        <tr>
            <td><%= hoaDon.getId() %></td>
            <td><%= hoaDon.getNgayDat() %></td>
            <td><%= hoaDon.getFormattedTongTien() %></td>
            <td><%= hoaDon.getTrangThai() %></td>
            <td><a href="chiTietHoaDon?id=<%= hoaDon.getId() %>">Xem chi tiết</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Không có hóa đơn nào</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
