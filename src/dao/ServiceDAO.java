/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class ServiceDAO {
    
    // LOAD DATA TO LIST SERVICE
    public List<Service> getServices() throws ClassNotFoundException, SQLException {
        List<Service> listService = new ArrayList<>();
        String sql = "SELECT * FROM DichVu";
        try(
                Connection con = DatabaseConnection.opConnection();
                Statement state = con.createStatement();
                ResultSet res = state.executeQuery(sql);
            ) {
            while (res.next()) {
                String tenDV = res.getString("tenDV");
                double donGia = Double.parseDouble(res.getString("donGia"));
                String trangThai = res.getString("trangThai");
                
                Service service = new Service(tenDV, donGia, trangThai);
                listService.add(service);
            }
            return listService;
        }
    }
    
}
