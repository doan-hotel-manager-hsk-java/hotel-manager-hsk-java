/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.*;
import entity.Customer;
import entity.Room;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRoomDAO {

    RoomDAO roomDAO;
    CustomerDAO customerDAO;
    StaffDAO staffDAO;
    //Phương
    //Variable
    private final String MA_DDP = "maDDP";
    private final String NGAY_DAT = "ngayDat";
    private final String GIO_DAT = "gioDat";
    private final String NGAY_NHAN = "ngayNhan";
    private final String GIO_NHAN = "gioNhan";
    private final String MA_PHONG = "maPhong";
    private final String MA_KH = "maKH";
    private final String MA_NV = "maNV";

    //sql
    private final String SELECT_ALL_BOOKROOM = "SELECT * FROM DONDATPHONG";
    private final String SELECT_BOOKROM_BY_ID = "SELECT * FROM DONDATPHONG WHERE MADDP = ?";
    private final String SELECT_BOOKROM_BY_IDPHONG = "SELECT * FROM DONDATPHONG WHERE MAPHONG = ?";
    private final String SELECT_BOOKROM_BY_IDKH = "SELECT * FROM DONDATPHONG WHERE MAKH = ?";
    private final String SELECT_BOOKROM_BY_IDNV = "SELECT * FROM DONDATPHONG WHERE MANV = ?";
    private final String INSERT_BOOKROM = "INSERT INTO DONDATPHONG(maDDP,ngayDat,gioDat,ngayNhan,gioNhan,maPhong,maKH,maNV)"
            + " VALUES(?,?,?,?,?,?,?,?)";
    private final String UPDATE_BOOKROOM = "UPDATE DONDATPHONG SET maPhong = ? where MADDP = ?";

    public List<BookRoom> getAlLBookRooms() {
        customerDAO = new CustomerDAO();
        roomDAO = new RoomDAO();
        staffDAO = new StaffDAO();

        List<BookRoom> bookRooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_BOOKROOM)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maDDP = rs.getString(MA_DDP);
                    String ngayDat = rs.getString(NGAY_DAT);
                    String gioDat = rs.getString(GIO_DAT);
                    String ngayNhan = rs.getString(NGAY_NHAN);
                    String gioNhan = rs.getString(GIO_NHAN);

                    Customer customer = customerDAO.findCustomerById(rs.getString(MA_KH));
                    Room room = roomDAO.findRoomById(rs.getString(MA_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    BookRoom bookRoom = new BookRoom(maDDP, ngayDat, gioDat, ngayNhan, gioNhan, room, customer, staff);
                    bookRooms.add(bookRoom);
                }

                return bookRooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertBookRoom(BookRoom bookRoom) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(INSERT_BOOKROM)) {
            pstmt.setString(1, bookRoom.getMaDDP());
            pstmt.setString(2, bookRoom.getNgayDat());
            pstmt.setString(3, bookRoom.getGioDat());
            pstmt.setString(4, bookRoom.getNgayNhan());
            pstmt.setString(5, bookRoom.getGioNhan());
            pstmt.setString(6, bookRoom.getRoom().getMaPhong());
            pstmt.setString(7, bookRoom.getCustomer().getMaKH());
            pstmt.setString(8, bookRoom.getStaff().getMaNV());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean updateBookRoom(BookRoom bookRoom) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOKROOM)) {
            pstmt.setString(1, bookRoom.getRoom().getMaPhong());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }
}
