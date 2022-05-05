/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.RoomStatusType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class RoomStatusTypeDAO {
    //tuan
    private final String MA_LTTP = "MALTTP";
    private final String TEN_LTTP = "TENLOAI";
    
    private final String SELECT_ALL_ROOM_STATUS_TYPE = "SELECT * FROM LOAITRANGTHAIPHONG";
    private final String SELECT_ALL_ROOM_STATUS_TYPE_BY_ID = "SELECT * FROM LOAITRANGTHAIPHONG WHERE MALTTP = ?";
    
    public List<RoomStatusType> getAllRoomStatusTypes() {
        List<RoomStatusType> roomStatusTypes = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM_STATUS_TYPE)) {
            try(ResultSet rs = pstmt.executeQuery();) {
                while(rs.next()) {
                    String maLTTP = rs.getString(MA_LTTP);
                    String tenLTTP = rs.getString(TEN_LTTP);
                    
                    RoomStatusType roomStatusType = new RoomStatusType(maLTTP, tenLTTP);
                    roomStatusTypes.add(roomStatusType);
                }
                
                return roomStatusTypes;
            }
        }catch(Exception e) {
             System.err.println("getAllRoomStatusTypes(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public RoomStatusType finRoomStatusTypeById(String id) {
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM_STATUS_TYPE_BY_ID) ) {
            pstmt.setString(1, id);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String maLTTP = rs.getString(MA_LTTP);
                    String tenLTTP = rs.getString(TEN_LTTP);
                    
                    RoomStatusType roomStatusType = new RoomStatusType(maLTTP, tenLTTP);
                    return roomStatusType;
                }
            } catch(Exception e) {
             System.err.println("error result set fin room status type");
            e.printStackTrace();
        }
        }catch(Exception e) {
             System.err.println("finRoomStatusTypeById(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
