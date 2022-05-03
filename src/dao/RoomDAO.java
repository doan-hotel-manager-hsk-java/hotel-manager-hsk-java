/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class RoomDAO {
    //tuan

    private final String Ma_PHONG = "MAPHONG";
    private final String TEN_PHONG = "TENPHONG";
    private final String TANG = "TANG";
    private final String MA_LOAI_PHONG = "MALOAIPHONG";
    private final String MA_LOAT_TRANG_THAI_PHONG = "MALTTP";
    private final String MA_NV = "MANV";

    private final String SELECT_ALL_ROOM = "SELECT * FROM PHONG";
    private final String SELECT_ROOM_BY_NAME = "SELECT * FROM PHONG WHERE TENPHONG = ?";
    
    private RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
    private RoomStatusTypeDAO roomStatusTypeDAO = new RoomStatusTypeDAO();
    private StaffDAO staffDAO = new StaffDAO();
    
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
       
        try ( Connection conn = DatabaseConnection.opConnection();  
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM)) {
                try(ResultSet rs = pstmt.executeQuery()) {
                    while(rs.next()) {
                        RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                        RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                        Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));
                        
                        Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG), 
                                rs.getInt(TANG), roomType, romStatusType, staff);
                        
                        rooms.add(room);
                    }
                    
                    return rooms;
                }catch(Exception e) {
                    System.err.println("get data fail");
                    e.printStackTrace();
                }
        } catch (Exception e) {
            System.err.println("getAllRooms(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
