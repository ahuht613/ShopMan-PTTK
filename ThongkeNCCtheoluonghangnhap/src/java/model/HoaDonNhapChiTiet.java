/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class HoaDonNhapChiTiet {
    private int id;
    private String tenMatHang; // Tên mặt hàng
    private int soLuong;
    private double gia;
    private double thanhTien; // Thành tiền
    private int hoaDonNhapId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getHoaDonNhapId() {
        return hoaDonNhapId;
    }

    public void setHoaDonNhapId(int hoaDonNhapId) {
        this.hoaDonNhapId = hoaDonNhapId;
    }
}
