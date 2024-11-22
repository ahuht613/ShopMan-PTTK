<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Chi tiết hóa đơn</title>
</head>
<body>
    <%
        // Lấy thông tin khách hàng và mã hóa đơn từ request
        model.KhachHang315 khachHang = (model.KhachHang315) request.getAttribute("khachHang");
        int hoaDonId = (Integer) request.getAttribute("hoaDonId"); // Chỉ giữ lại khai báo này

        // Lấy thông tin từ request
        java.util.List<model.HoaDonBanChiTiet315> chiTietList = (java.util.List<model.HoaDonBanChiTiet315>) request.getAttribute("chiTietList");
        String tongTien = (String) request.getAttribute("tongTien");
    %>
    <!-- Hiển thị thông tin khách hàng -->
    <h1>Khách hàng: <%= khachHang.getTenKH() %></h1>
    <p>Email: <%= khachHang.getEmail() %></p>
    <p>Số điện thoại: <%= khachHang.getSdt() %></p>
    <h2>Mã hóa đơn: <%= hoaDonId %></h2>

    <!-- Hiển thị bảng chi tiết hóa đơn -->
    <h3>Chi tiết hóa đơn</h3>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên hàng hóa</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
        </tr>
        <%
            if (chiTietList != null && !chiTietList.isEmpty()) {
                int stt = 1;
                for (model.HoaDonBanChiTiet315 chiTiet : chiTietList) {
                    double thanhTien = chiTiet.getGia() * chiTiet.getSoLuong();
                    String formattedThanhTien = java.text.NumberFormat.getInstance(new java.util.Locale("vi", "VN")).format(thanhTien);
        %>
        <tr>
            <td><%= stt++ %></td>
            <td><%= chiTiet.getMatHang().getTen() %></td>
            <td><%= chiTiet.getFormattedGia() %></td>
            <td><%= chiTiet.getSoLuong() %></td>
            <td><%= formattedThanhTien %></td>
        </tr>
        <%
                }
        %>
        <!-- Thêm hàng tổng tiền -->
        <tr>
            <td colspan="4" style="text-align: right;"><strong>Tổng tiền</strong></td>
            <td><strong><%= tongTien %></strong></td>
        </tr>
        <%
            } else {
        %>
        <tr>
            <td colspan="5">Không có chi tiết hóa đơn nào</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
