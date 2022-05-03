/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.OrderDetail_Room;
import entity.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bao Tran
 */
public class OrderDetail_Room_DAO {
    
    public List<OrderDetail_Room> getListServicesAdded() throws ClassNotFoundException, SQLException {
        List<OrderDetail_Room> list = new ArrayList<>();
        String sql = "SELECT p.tenPhong, dv.tenDV, cthd.soLuong, (cthd.soLuong*dv.donGia) AS TongTien FROM DichVu AS dv "
                   + "INNER JOIN ChiTietHoaDon as cthd on dv.maDV=cthd.maDV "
                   + "INNER JOIN HoaDon as hd on cthd.maHD=hd.maHD "
                   + "INNER JOIN Phong as p on hd.maPhong=p.maPhong "
                   + "GROUP BY p.tenPhong, dv.tenDV, cthd.soLuong, dv.donGia";
        try(
                Connection con = DatabaseConnection.opConnection();
                Statement state = con.createStatement();
                ResultSet res = state.executeQuery(sql);
            ) {
            while (res.next()) {
                String tenPhong = res.getString("tenPhong");
                String tenDV = res.getString("tenDV");
                Service service = new Service(tenDV);
                service.setTenDV(tenDV);
                int soLuong = Integer.parseInt(res.getString("soLuong"));
                double tongtien = Double.parseDouble(res.getString("tongTien"));
                
                OrderDetail_Room or = new OrderDetail_Room(tenPhong, service, soLuong, tongtien);
                list.add(or);
            }
            return list;
        }
    }
    
}
