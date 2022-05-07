/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.ServiceType;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vomin
 */
public class ServiceTypeDAO {
    private final String MALDV = "MALDV";
    private final String TENLDV = "TENLDV";
    
    private final String SELECT_ALL_SERVICETYPE= "SELECT * FROM LOAIDICHVU";
    private final String SELECT_SERVICETYPE_BYID = "SELECT * FROM LOAIDICHVU WHERE MALDV = ?";
    private final String SELECT_SERVICETYPE_BYNAME = "SELECT * FROM LOAIDICHVU WHERE TENLDV  = ?";
    
    public List<ServiceType> getAllServiceType()  {
        List<ServiceType> ServiceTypes = new ArrayList<>();
        try( Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SERVICETYPE)){
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    String tenLDV = rs.getString("TENLDV");
                    String maLDV = rs.getString("MALDV");
                    ServiceType serviceType = new ServiceType(maLDV, tenLDV);
                    ServiceTypes.add(serviceType);
                }
                return ServiceTypes;
            }
            
        } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
        }
        return null;
    }
    public ServiceType findServiceTypeById(String id) {
        try(Connection conn = DatabaseConnection.opConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_SERVICETYPE_BYID) ){
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    String maLDV =rs.getString(MALDV);
                    String tenLDV = rs.getString(TENLDV);
                    
                    ServiceType serviceType = new ServiceType(maLDV, tenLDV);
                    return serviceType;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ServiceType findServiceTypeByName(String name) {
        try(Connection conn = DatabaseConnection.opConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_SERVICETYPE_BYNAME) ){
            pstmt.setString(1, name);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    String maLDV =rs.getString(MALDV);
                    String tenLDV = rs.getString(TENLDV);
                    
                    ServiceType serviceType = new ServiceType(maLDV, tenLDV);
                    return serviceType;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
