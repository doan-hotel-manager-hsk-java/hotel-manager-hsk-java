/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.RoomType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class RoomTypeDAO {
    //tuan
    private final String MA_LP = "MALOAIPHONG";
    private final String TEN_LP = "TenLOAIPHONG";
    private final String DONGIA = "DONGIA";
    
    private final String SELECT_ALL_ROOMTYPE = "SELECT * FROM LOAIPHONG";
    private final String SELECT_ALL_ROOMTYPE_BY_ID = "SELECT * FROM LOAIPHONG WHERE MALOAIPHONG = ?";
    private final String SELECT_ROOMTYPE_BY_NAME = "SELECT * FROM LOAIPHONG WHERE TENLOAIPHONG  = ?";
    
    public List<RoomType> getAllRoomTypes() {
        List<RoomType> roomTypeList = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOMTYPE)) {
            try(ResultSet rs = pstmt.executeQuery();) {
                while(rs.next()) {
                    String maLP = rs.getString(MA_LP);
                    String tenLP = rs.getString(TEN_LP);
                    Double donGia = rs.getDouble(DONGIA);
                    
                    RoomType roomType = new RoomType(maLP, tenLP, donGia);
                    roomTypeList.add(roomType);
                }
                
                return roomTypeList;
            }
        }catch(Exception e) {
             System.err.println("getAllRoomType(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public RoomType findRoomTypeById(String id) {
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOMTYPE_BY_ID) ) {
            pstmt.setString(1, id);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String maLP = rs.getString(MA_LP);
                    String tenLP = rs.getString(TEN_LP);
                    Double donGia = rs.getDouble(DONGIA);
                    
                    RoomType roomType = new RoomType(maLP, tenLP, donGia);
                    return roomType;
                }
            }
        }catch(Exception e) {
             System.err.println("findRoomTypeById(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
     public RoomType findRoomTypeByName(String name) {
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOMTYPE_BY_NAME) ) {
            pstmt.setString(1, name);
            System.err.println(name);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String maLP = rs.getString(MA_LP);
                    String tenLP = rs.getString(TEN_LP);
                    Double donGia = rs.getDouble(DONGIA);
                    
                    RoomType roomType = new RoomType(maLP, tenLP, donGia);
                    return roomType;
                }
            }
        }catch(Exception e) {
             System.err.println("findRoomTypeByName(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
