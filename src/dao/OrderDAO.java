/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Order;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vomin
 */
public class OrderDAO {
    
    // FIND BY ID ORDER
    public Order getOrderById(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM HoaDon WHERE maHD = ?";
        try(
                Connection con = DatabaseConnection.opConnection();
                PreparedStatement pres = con.prepareStatement(sql);
            ) {
            
            pres.setString(1, id);
            ResultSet res = pres.executeQuery();
            
            Room room = new Room();
            
            if(res.next()) {
                Order order = new Order();
                order.setMaHD(res.getString("maHD"));
                order.setNgayVao(res.getString("ngayVao"));
                order.setGioVao(res.getString("gioVao"));
                order.setGioRa(res.getString("gioRa"));
                order.setNgayLapHD(res.getString("ngayLapHD"));
                order.setChietKhau(res.getString("chietKhau"));
                room.setMaPhong(res.getString("maPhong"));
                order.setRoom(room);
                
                return order;
            }
            return null;
        }
    }
    
}
