/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class HoaDonNhap {
    private int id;
    private Date ngayNhap;
    private double tongTien;
    private int nhaCungCapId;
    private int nvQuanLyId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getNhaCungCapId() {
        return nhaCungCapId;
    }

    public void setNhaCungCapId(int nhaCungCapId) {
        this.nhaCungCapId = nhaCungCapId;
    }

    public int getNvQuanLyId() {
        return nvQuanLyId;
    }

    public void setNvQuanLyId(int nvQuanLyId) {
        this.nvQuanLyId = nvQuanLyId;
    }
    
}
