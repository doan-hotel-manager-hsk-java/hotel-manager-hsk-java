/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Device;
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
public class DeviceDAO {

    //tuan
    private final String MA_TTB = "MATTB";
    private final String TEN_TTB = "TENTTB";
    private final String SOLUONGTON = "SOLUONGTON";
    private final String DONVI = "DONVI";
    private final String GIA = "GIA";
    private final String TRANGTHAI = "TRANGTHAI";
    private final String MANHANVIEN = "MANV";

    private final String SELECT_ALL_DEVICE = "SELECT * FROM TRANGTHIETBI";

    private StaffDAO staffDAO = new StaffDAO();
    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();

        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_DEVICE)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                 while(rs.next()) {
                     String maTTB = rs.getString(MA_TTB);
                     String tenTTB = rs.getString(TEN_TTB);
                     int soLuongTon = rs.getInt(SOLUONGTON);
                     String donVi = rs.getString(DONVI);
                     Double gia = rs.getDouble(GIA);
                     int trangThai = rs.getInt(TRANGTHAI);
                     Staff nhanVien = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));
                     
                     Device device = new Device(maTTB, tenTTB, soLuongTon, donVi, 0, TRANGTHAI, nhanVien);
                     devices.add(device);
                 }
                 
                 return devices;
            } catch (Exception e) {
                System.err.println("getAllDevices(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllDevices(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
