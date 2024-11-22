/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class HoaDonBan315 {
    private int id;
    private Date ngayDat; // Thuộc tính ngày đặt
    private double tongTien;
    private String trangThai;
    private String formattedTongTien; // Thuộc tính định dạng tổng tiền

    // Getter và Setter cho id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho ngayDat
    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    // Getter và Setter cho tongTien
    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    // Getter và Setter cho trangThai
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Getter và Setter cho formattedTongTien
    public String getFormattedTongTien() {
        return formattedTongTien;
    }

    public void setFormattedTongTien(String formattedTongTien) {
        this.formattedTongTien = formattedTongTien;
    }
}
