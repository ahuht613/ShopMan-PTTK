/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ThanhVien315 {
    private int id;
    private String username;
    private String password;
    private String hoten;
    private String ngaysinh;
    private String diachi;
    private String email;
    private String sdt;

    public ThanhVien315(int id, String username, String password, String hoten, String ngaysinh, String diachi, String email, String sdt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.sdt = sdt;
    }

    // Getter và Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }

    public String getNgaysinh() { return ngaysinh; }
    public void setNgaysinh(String ngaysinh) { this.ngaysinh = ngaysinh; }

    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
}

