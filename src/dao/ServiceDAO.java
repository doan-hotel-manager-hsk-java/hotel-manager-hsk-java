/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Service;
import entity.ServiceType;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    // FIND BY ID SERVICE
    public Service getServiceById(String maDV) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM DichVu WHERE maDV = ?";
        try(
                Connection con = DatabaseConnection.opConnection();
                PreparedStatement pres = con.prepareStatement(sql);
            ) {
            
            pres.setString(1, maDV);
            ResultSet res = pres.executeQuery();
            
            if(res.next()) {
                Service service = new Service();
                service.setMaDV(res.getString("maDV"));
                service.setTenDV(res.getString("tenDV"));
                service.setDonGia(res.getDouble("donGia"));
                service.setTrangThai(res.getString("trangThai"));
                
                return service;
            }
            return null;
        }
    }
    
    // FIND BY NAME SERVICE
    public Service getServiceByName(String tenDV) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM DichVu WHERE tenDV = ?";
        try(
                Connection con = DatabaseConnection.opConnection();
                PreparedStatement pres = con.prepareStatement(sql);
            ) {
            
            pres.setString(1, tenDV);
            ResultSet res = pres.executeQuery();
            
            if(res.next()) {
                Service service = new Service();
                service.setMaDV(res.getString("maDV"));
                service.setTenDV(res.getString("tenDV"));
                service.setDonGia(res.getDouble("donGia"));
                service.setTrangThai(res.getString("trangThai"));
                //service.setServiceType(res.getObject(res.getString("maLDV"), ServiceType.class));
                //service.setStaff(res.getObject(res.getString("maNV"), Staff.class));
                
                return service;
            }
            return null;
        }
    }
    
}
