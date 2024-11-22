/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO315 {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Đảm bảo tên DB, username, password đúng
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/QuanLyBanHang315", // Tên database
                "root", // Username MySQL
                "Ha060103" // Password MySQL
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

