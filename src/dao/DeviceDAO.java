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
import java.sql.SQLException;
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

    private final String INSERT_DEVICE ="INSERT INTO TRANGTHIETBI VALUES (?, ?,?,?,?,?,?)";
    private final String SELECT_ALL_DEVICE = "SELECT * FROM TRANGTHIETBI WHERE TRANGTHAI = 1";
    private final String SELECT_DEVICES_BY_ALL_STATUS="SELECT * FROM TRANGTHIETBI";
    private final String SELECT_DEVICE_BY_ID = "SELECT * FROM TRANGTHIETBI WHERE MATTB = ?";
    private final String SELECT_DEVICE_BY_NAME = "SELECT * FROM TRANGTHIETBI WHERE TENTTB = ?";
    private final String UPDATE_DEVICE_BY_ID = "UPDATE TRANGTHIETBI SET TENTTB = ?, SOLUONGTON = ?, DONVI = ?, GIA = ?, TRANGTHAI = ? WHERE MATTB = ?";

    private StaffDAO staffDAO = new StaffDAO();

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();

        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_DEVICE)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maTTB = rs.getString(MA_TTB);
                    String tenTTB = rs.getString(TEN_TTB);
                    int soLuongTon = rs.getInt(SOLUONGTON);
                    String donVi = rs.getString(DONVI);
                    Double gia = rs.getDouble(GIA);
                    int trangThai = rs.getInt(TRANGTHAI);
                    Staff nhanVien = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));

                    Device device = new Device(maTTB, tenTTB, soLuongTon, donVi, gia, trangThai, nhanVien);
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
    public List<Device> getDevicesByAllStatus() {
        List<Device> devices = new ArrayList<>();

        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_DEVICES_BY_ALL_STATUS)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maTTB = rs.getString(MA_TTB);
                    String tenTTB = rs.getString(TEN_TTB);
                    int soLuongTon = rs.getInt(SOLUONGTON);
                    String donVi = rs.getString(DONVI);
                    Double gia = rs.getDouble(GIA);
                    int trangThai = rs.getInt(TRANGTHAI);
                    Staff nhanVien = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));

                    Device device = new Device(maTTB, tenTTB, soLuongTon, donVi, gia, trangThai, nhanVien);
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

    public Device findDeviceById(String id) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_DEVICE_BY_ID)) {
            pstmt.setString(1, id);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String maTTB = rs.getString(MA_TTB);
                    String tenTTB = rs.getString(TEN_TTB);
                    int soLuongTon = rs.getInt(SOLUONGTON);
                    String donVi = rs.getString(DONVI);
                    Double gia = rs.getDouble(GIA);
                    int trangThai = rs.getInt(TRANGTHAI);
                    Staff nhanVien = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));

                    Device device = new Device(maTTB, tenTTB, soLuongTon, donVi, gia, trangThai, nhanVien);
                    return device;
                }
            } catch (Exception e) {
                System.err.println("findDeviceById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findDeviceById(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Device findDeviceByName(String name) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_DEVICE_BY_NAME)) {
            pstmt.setString(1, name);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String maTTB = rs.getString(MA_TTB);
                    String tenTTB = rs.getString(TEN_TTB);
                    int soLuongTon = rs.getInt(SOLUONGTON);
                    String donVi = rs.getString(DONVI);
                    Double gia = rs.getDouble(GIA);
                    int trangThai = rs.getInt(TRANGTHAI);
                    Staff nhanVien = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));

                    Device device = new Device(maTTB, tenTTB, soLuongTon, donVi, gia, trangThai, nhanVien);
                    return device;
                }
            } catch (Exception e) {
                System.err.println("findDeviceById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findDeviceById(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public boolean updateDeviceById(Device device) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(UPDATE_DEVICE_BY_ID)){
            pstmt.setString(1, device.getTenTTB());
            pstmt.setInt(2, device.getSoLuongTon());
            pstmt.setString(3, device.getDonVi());
            pstmt.setDouble(4, device.getGia());
            pstmt.setInt(5, device.getTrangThai());
            pstmt.setString(6, device.getMaTTB());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("updateDeviceById(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insertDevice(Device d) {
        try(
            Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(INSERT_DEVICE);)
            {
                pstmt.setString(1, d.getMaTTB());
                pstmt.setString(2, d.getTenTTB());
                pstmt.setInt(3, d.getSoLuongTon());
                pstmt.setString(4, d.getDonVi());
                pstmt.setDouble(5, d.getGia());
                pstmt.setInt(6, d.getTrangThai());
                pstmt.setString(7, d.getStaff().getMaNV());
                
                return  pstmt.executeUpdate()>0;

            } catch (Exception e) {
            System.err.println("insertDeviceById(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }   
    
    
}
