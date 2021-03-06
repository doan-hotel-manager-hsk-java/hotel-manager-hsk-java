/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.BookRoom;
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
    private final String TONGTIEN = "TONGTIEN";

    private final String SELECT_ALL_ORDER = "SELECT * FROM ORDER";
    private final String SELECT_ORDER_BY_IDROOM = "SELECT * FROM HOADON WHERE MAPHONG = ?";
    private final String SELECT_ALL_ORDER_BYMONTHYEAR = "SELECT * FROM HOADON WHERE YEAR(NGAYLAPHD) = ? and MONTH(NGAYLAPHD) = ?";
    private final String SELECT_ALL_ORDER_TODAY = "SELECT * FROM HOADON WHERE NGAYLAPHD LIKE CAST(GETDATE() AS DATE)";
    private final String SELECT_ALL_ORDER_MONTH = "SELECT * FROM HOADON WHERE MONTH(NGAYLAPHD) LIKE MONTH(GETDATE())";
    private final String SELECT_ALL_ORDER_YEAR = "SELECT * FROM HOADON WHERE YEAR(NGAYLAPHD) LIKE YEAR(GETDATE())";
    private final String INSERT_ODER = "INSERT INTO HOADON VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_ODER = "UPDATE HOADON SET NGAYVAO = ?, GIOVAO=?,NGAYRA=?,GIORA=?,NGAYLAPHD=?,"
            + "CHIETKHAU=?,MAKH=?,MAPHONG=?,MANV=?,TONGTIEN=? where MAHD = ?";

    private final CustomerDAO customerDAO = new CustomerDAO();
    private final RoomDAO roomDAO = new RoomDAO();
    private final StaffDAO staffDAO = new StaffDAO();

    public List<Order> getAllOrders() {

        List<Order> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_TODAY)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien = rs.getDouble(TONGTIEN);
                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff, tongTien);
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

    public Order findRoomByIDRoom(String idRoom) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ORDER_BY_IDROOM)) {
            pstmt.setString(1, idRoom);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLapHD = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien = rs.getDouble(TONGTIEN);

                    Room room = roomDAO.findRoomById(rs.getString(MAPHONG));
                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Staff staff = staffDAO.findStaffById(rs.getString(MANHANVIEN));

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLapHD, chietKhau, customer, room, staff, tongTien);
                    return order;
                }
            } catch (Exception e) {
                System.err.println("findCustomerById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findCustomerById(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getAllOrderToDay() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_TODAY)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien = rs.getDouble(TONGTIEN);
                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff, tongTien);
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

    // FIND BY ID ORDER
    public Order getOrderById(String id) {
        String sql = "SELECT * FROM HoaDon WHERE maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, id);
            ResultSet res = pres.executeQuery();

            Room room = new Room();
            Customer customer = new Customer();

            if (res.next()) {
                Order order = new Order();
                order.setMaHD(res.getString("maHD"));
                order.setNgayVao(res.getString("ngayVao"));
                order.setGioVao(res.getString("gioVao"));
                order.setNgayRa(res.getString("ngayRa"));
                order.setGioRa(res.getString("gioRa"));
                order.setNgayLapHD(res.getString("ngayLapHD"));
                order.setChietKhau(res.getInt("chietKhau"));
                room.setMaPhong(res.getString("maPhong"));
                order.setRoom(room);
                customer.setMaKH(res.getString("maKH"));
                order.setCustomer(customer);
                order.setTongTien(res.getDouble("tongTien"));

                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // GET Day Use From Order
    public int getDayUseFromOrder(String maHD) {
        String sql = "select datediff(day, ngayVao, ngayRa) as SoNgay from HoaDon where maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, maHD);
            try (
                     ResultSet res = pres.executeQuery();) {
                if (res.next()) {
                    int day = res.getInt("SoNgay");

                    return day;
                }
            } catch (Exception ex) {
                System.out.println("dao.OrderDAO.getHourUseFromOrder()");
                ex.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // GET Hour Use From Order
    public int getHourUseFromOrder(String maHD) {
        String sql = "select datediff(hour,gioVao, gioRa) as SoGio from HoaDon where maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, maHD);
            try ( ResultSet res = pres.executeQuery();) {
                if (res.next()) {
                    int hour = res.getInt("SoGio");

                    if (hour < 0) {
                        hour = Math.abs(hour);
                    }
                    System.out.println("hour");
                    return hour;
                }

            } catch (Exception ex) {
                System.out.println("dao.OrderDAO.getHourUseFromOrder()");
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
        }
        return -1;
    }

    // GET Order Id By Room Id
    public String getOrderIdByRoomId(String maPhong) {
        String sql = "select maHD from Phong as p \n"
                   + "join HoaDon as hd on p.maPhong=hd.maPhong\n"
                   + "where p.maPhong = ? and hd.tongTien is null";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, maPhong);
            
            try ( ResultSet res = pres.executeQuery();) {
                if (res.next()) {
                    String id = res.getString("maHD");
                    
                    return id;
                }

            } catch (Exception ex) {
                System.out.println("dao.OrderDAO.getHourUseFromOrder()");
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
        }
        return null;
    }

    // UPDATE ORDER
    public boolean updateServiceInOrder(Order od) {
        String sql = "UPDATE HoaDon SET gioRa = ?, ngayRa = ? "
                + "WHERE maHD = ? AND maPhong = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, od.getGioRa());
            pres.setString(2, od.getNgayRa());
            pres.setString(3, od.getMaHD());
            pres.setString(4, od.getRoom().getMaPhong());

            return pres.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // UPDATE SUM TOTAL PAY IN ORDER
    public boolean updateSumTotalPayInOrder(Order od) {
        String sql = "UPDATE HoaDon SET gioRa = ?, ngayRa = ?, tongTien = ? "
                + "WHERE maHD = ? AND maPhong = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, od.getGioRa());
            pres.setString(2, od.getNgayRa());
            pres.setDouble(3, od.getTongTien());
            pres.setString(4, od.getMaHD());
            pres.setString(5, od.getRoom().getMaPhong());

            return pres.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Order> getAllOrderToMonth() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_MONTH)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien = rs.getDouble(TONGTIEN);
                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff, tongTien);
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
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_YEAR)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien  = rs.getDouble(TONGTIEN);
                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(MAPHONG);
                    Staff staff = staffDAO.getEmployeeBYID(MANHANVIEN);

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff,tongTien);
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

    public boolean insertOrder(Order order) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(INSERT_ODER)) {
            pstmt.setString(1, order.getMaHD());
            pstmt.setString(2, order.getNgayVao());
            pstmt.setString(3, order.getGioVao());
            pstmt.setString(4, order.getNgayRa());
            pstmt.setString(5, order.getGioRa());
            pstmt.setString(6, order.getNgayLapHD());
            pstmt.setInt(7, order.getChietKhau());
            pstmt.setString(8, order.getCustomer().getMaKH());
            pstmt.setString(9, order.getRoom().getMaPhong());
            pstmt.setString(10, order.getStaff().getMaNV());
            pstmt.setDouble(11, order.getTongTien());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateRoomByID(Order order) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_ODER)) {
            pstmt.setString(1, order.getNgayVao());
            pstmt.setString(2, order.getNgayRa());
            pstmt.setString(3, order.getNgayRa());
            pstmt.setString(4, order.getGioRa());
            pstmt.setString(5, order.getNgayLapHD());
            pstmt.setInt(6, order.getChietKhau());
            pstmt.setString(7, order.getCustomer().getMaKH());
            pstmt.setString(8, order.getRoom().getMaPhong());
            pstmt.setString(9, order.getStaff().getMaNV());
            pstmt.setDouble(10, order.getTongTien());
            pstmt.setString(11, order.getMaHD());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Order> getAllOrderByMonthYear(int month, int year) {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ORDER_BYMONTHYEAR)) {
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maHD = rs.getString(MAHD);
                    String ngayVao = rs.getString(NGAYVAO);
                    String gioVao = rs.getString(GIOVAO);
                    String ngayRa = rs.getString(NGAYRA);
                    String gioRa = rs.getString(GIORA);
                    String ngayLap = rs.getString(NGAYLAPHOADON);
                    int chietKhau = rs.getInt(CHIETKHAU);
                    double tongTien = rs.getDouble(TONGTIEN);

                    Customer customer = customerDAO.findCustomerById(rs.getString(MAKHACHHANG));
                    Room room = roomDAO.findRoomById(rs.getString(MAPHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MANHANVIEN));

                    Order order = new Order(maHD, ngayVao, gioVao, ngayRa, gioRa, ngayLap, chietKhau, customer, room, staff, tongTien);
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
}
