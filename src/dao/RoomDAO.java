package dao;

import connection.DatabaseConnection;
import entity.BookRoom;
import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    //tuan
    //variable
    private final String Ma_PHONG = "MAPHONG";
    private final String TEN_PHONG = "TENPHONG";
    private final String TANG = "TANG";
    private final String MA_LOAI_PHONG = "MALOAIPHONG";
    private final String MA_LOAT_TRANG_THAI_PHONG = "MALTTP";
    private final String MA_NV = "MANV";

    //sql sever
    private final String SELECT_ALL_ROOM = "SELECT * FROM PHONG";
    private final String SELECT_ROOM_BY_NAME = "SELECT * FROM PHONG WHERE TENPHONG = ?";
    private final String SELECT_ROOM_BY_ID = "SELECT * FROM PHONG WHERE MAPHONG = ?";
    private final String SELECT_ROOM_BY_ID_LOAI = "SELECT * FROM PHONG WHERE MALOAIPHONG = ?";
    private final String SELECT_ROOM_BY_ID_LOAI_TTP = "SELECT * FROM PHONG WHERE MALTTP = ?";
    
    private final String UPDATE_ROOM = "UPDATE PHONG SET TENPHONG =?,TANG=?,MALOAIPHONG=?,MALTTP=?,MANV=? WHERE MAPHONG = ?";
    private final String DELETE_ROOM_BYID = "UPDATE PHONG SET MALTTP = ?, MANV = ? where MAPHONG = ?";
    private final String UPDATE_ROOM_BYID = "UPDATE PHONG SET TENPHONG = ?, TANG = ?, MANV = ? where MAPHONG = ?";
    private final String ADD_ROOM_BYID = "INSERT into PHONG  values (?,?,?,?,?,?)";
    // entity
    private final RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
    private final RoomStatusTypeDAO roomStatusTypeDAO = new RoomStatusTypeDAO();
    private final StaffDAO staffDAO = new StaffDAO();

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG),
                            rs.getInt(TANG), roomType, romStatusType, staff);

                    rooms.add(room);
                }

                return rooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllRooms(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    //tuan
    public Room findRoomById(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_ID)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG),
                            rs.getInt(TANG), roomType, romStatusType, staff);

                    return room;
                }
            } catch (Exception e) {
                System.err.println("findRoomById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findRoomById(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public Room findRoomByNameRoom(String name) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_NAME)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG),
                            rs.getInt(TANG), roomType, romStatusType, staff);

                    return room;
                }
            } catch (Exception e) {
                System.err.println("findRoomById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findRoomById(): connect db fail");
        }
        return null;
    }

    public List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong) {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_ID_LOAI)) {
            pstmt.setString(1, IDLoaiPhong);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG),
                            rs.getInt(TANG), roomType, romStatusType, staff);

                    rooms.add(room);
                }

                return rooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllRooms(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }

    public List<Room> findRoomByIDTTP(String IDTTP) {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_BY_ID_LOAI_TTP)) {
            pstmt.setString(1, IDTTP);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString(MA_LOAI_PHONG));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString(MA_LOAT_TRANG_THAI_PHONG));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MA_NV));

                    Room room = new Room(rs.getString(Ma_PHONG), rs.getString(TEN_PHONG),
                            rs.getInt(TANG), roomType, romStatusType, staff);

                    rooms.add(room);
                }

                return rooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllRooms(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }
    
      public boolean updateBookRoom(Room room) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_ROOM)) {
            pstmt.setString(1, room.getTenPhong());
            pstmt.setInt(2, room.getTang());
            pstmt.setString(3, room.getRoomType().getMaLoaiPhong());
            pstmt.setString(4, room.getRoomStatusType().getMaLoaiTTP());
            pstmt.setString(5, room.getStaff().getMaNV());
             pstmt.setString(6, room.getMaPhong());
            return pstmt.executeUpdate() > 0;
            
        } catch (Exception e) {
            System.err.println("connect db fail");
        }
        return false;
      }
      
    public boolean deleteRoom(Room room) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_ROOM_BYID)) {
            pstmt.setString(1, room.getRoomStatusType().getMaLoaiTTP());
            pstmt.setString(2, room.getStaff().getMaNV());
            pstmt.setString(3, room.getMaPhong());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateRoom(Room room) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_ROOM_BYID)) {
            pstmt.setString(1, room.getTenPhong());
            pstmt.setDouble(2, room.getTang());
            pstmt.setString(3, room.getStaff().getMaNV());
            pstmt.setString(4, room.getMaPhong());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRoom(Room room) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(ADD_ROOM_BYID)) {
            pstmt.setString(1, room.getMaPhong());
            pstmt.setString(2, room.getTenPhong());
            pstmt.setDouble(3, room.getTang());
            pstmt.setString(4, room.getRoomType().getMaLoaiPhong());
            pstmt.setString(5, room.getRoomStatusType().getMaLoaiTTP());
            pstmt.setString(6, room.getStaff().getMaNV());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
