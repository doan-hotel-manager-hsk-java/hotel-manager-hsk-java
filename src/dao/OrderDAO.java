/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Customer;
import entity.Order;
import entity.Room;
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
public class OrderDAO {

    //tuan
    private final String MAHD = "MAHD";
    private final String NGAYVAO = "NGAYVAO";
    private final String GIOVAO = "GIOVAO";
    private final String NGAYRA = "NGAYRA";
    private final String GIORA = "GIORA";
    private final String NGAYLAPHOADON = "NGAYLAPHD";
    private final String CHIETKHAU = "CHIETKHAU";
    private final String MAKHACHHANG = "MAKH";
    private final String MAPHONG = "MAPHONG";
    private final String MANHANVIEN = "MANV";

    private final String SELECT_ALL_ORDER_TODAY = "SELECT * FROM HOADON WHERE NGAYLAPHD LIKE CAST(GETDATE() AS DATE)";
    private final String SELECT_ALL_ORDER_MONTH = "SELECT * FROM HOADON WHERE MONTH(NGAYLAPHD) LIKE MONTH(GETDATE())";
    private final String SELECT_ALL_ORDER_YEAR = "SELECT * FROM HOADON WHERE YEAR(NGAYLAPHD) LIKE YEAR(GETDATE())";

    private final CustomerDAO customerDAO = new CustomerDAO();
    private final RoomDAO roomDAO = new RoomDAO();
    private final StaffDAO staffDAO = new StaffDAO();

    public List<Order> getAllOrderToDay() {
        List<Order> orders = new ArrayList<>();
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_TODAY)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);

                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff);
                    orders.add(order);
                }
                
                return orders;
            } catch (Exception e) {
                System.err.println("getAllOrderToDay(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllOrderToDay(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<Order> getAllOrderToMonth() {
        List<Order> orders = new ArrayList<>();
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_MONTH)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);

                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff);
                    orders.add(order);
                }
                
                return orders;
            } catch (Exception e) {
                System.err.println("getAllOrderToMonth(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllOrderToMonth(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public List<Order> getAllOrderToYear() {
        List<Order> orders = new ArrayList<>();
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_YEAR)) {
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);

                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff);
                    orders.add(order);
                }
                
                return orders;
            } catch (Exception e) {
                System.err.println("getAllOrderToYear(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllOrderToYear(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
