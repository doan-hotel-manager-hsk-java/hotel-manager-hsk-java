/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Device;
import entity.Room;
import entity.Room_Device;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class RoomDeviceDAO {

    private final String SOLUONG = "SOLUONG";
    private final String MA_TTB = "MATTB";
    private final String MA_PHONG = "MAPHONG";

    private final String SELECT_ALL_DEVICE_TO_ROOM_BY_ID_ROOM = "SELECT * FROM PHONG_TRANGTHIETBI WHERE MAPHONG = ?";
    private final String SELECT_DEVICE_TO_ROOM_BY_ID_ROOM_DEVICE = "SELECT * FROM PHONG_TRANGTHIETBI WHERE MATTB = ? and MAPHONG = ?";
    private final String INSERT_DEVICE_TO_ROOM = "INSERT INTO PHONG_TRANGTHIETBI VALUES(?, ?, ?)";
    private final String UPDATE_NUMBER_DEVICE_TO_ROOM = "UPDATE PHONG_TRANGTHIETBI SET SOLUONG = ? WHERE MATTB = ? and MAPHONG = ?";
    private final String DELTE_DEVICE_TO_ROOM = "DELETE FROM PHONG_TRANGTHIETBI WHERE MATTB = ? and MAPHONG = ?";

    private final RoomDAO roomDAO = new RoomDAO();
    private final DeviceDAO deviceDAO = new DeviceDAO();

    public List<Room_Device> getAllRoomDevicesById(String idRoom) {
        List<Room_Device> room_Devices = new ArrayList<>();

        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_DEVICE_TO_ROOM_BY_ID_ROOM)) {
            pstmt.setString(1, idRoom);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int soLuong = rs.getInt(SOLUONG);
                    Room room = roomDAO.findRoomById(rs.getString(MA_PHONG));
                    Device device = deviceDAO.findDeviceById(rs.getString(MA_TTB));

                    Room_Device room_Device = new Room_Device(soLuong, device, room);
                    room_Devices.add(room_Device);
                }

                return room_Devices;
            } catch (Exception e) {
                System.err.println("getAllRoomDevices(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllRoomDevices(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public Room_Device findDeviceByIdRoomIdDevice(String idDevice, String idRoom) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_DEVICE_TO_ROOM_BY_ID_ROOM_DEVICE)) {
            pstmt.setString(1, idDevice);
            pstmt.setString(2, idRoom);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    int soLuong = rs.getInt(SOLUONG);
                    Room room = roomDAO.findRoomById(rs.getString(MA_PHONG));
                    Device device = deviceDAO.findDeviceById(rs.getString(MA_TTB));

                    Room_Device room_Device = new Room_Device(soLuong, device, room);
                    
                    return room_Device;
                }
            } catch (Exception e) {
            System.err.println("findDeviceByIdRoomIdDevice(): get data fail");
            e.printStackTrace();
        }
        } catch (Exception e) {
            System.err.println("findDeviceByIdRoomIdDevice(): connect db fail");
            e.printStackTrace();
        }
        
        return null;

    }

    public boolean insertDeviceToRoom(Room_Device device) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(INSERT_DEVICE_TO_ROOM)) {
            pstmt.setInt(1, device.getSoLuong());
            pstmt.setString(2, device.getDevice().getMaTTB());
            pstmt.setString(3, device.getRoom().getMaPhong());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("insertDeviceToRoom(): connect db fail");
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateDeviceToRoom(Room_Device device) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(UPDATE_NUMBER_DEVICE_TO_ROOM)) {
            pstmt.setInt(1, device.getSoLuong());
            pstmt.setString(2, device.getDevice().getMaTTB());
            pstmt.setString(3, device.getRoom().getMaPhong());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("updateDeviceToRoom(): connect db fail");
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean deleteDeviceToRoom(Room_Device device) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(DELTE_DEVICE_TO_ROOM)) {
            pstmt.setString(1, device.getDevice().getMaTTB());
            pstmt.setString(2, device.getRoom().getMaPhong());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("updateDeviceToRoom(): connect db fail");
            e.printStackTrace();
        }

        return false;
    }
}
