package dao;

import connection.DatabaseConnection;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    StaffTypeDAO staffTypeDAO;

    //Phuong
    // variable
    private final String Ma_NV = "maNV";
    private final String TEN_NV = "tenNV";
    private final String GIOI_TINH = "gioiTinh";
    private final String EMAIL = "email";
    private final String CMND = "cmnd";
    private final String SDT = "sdt";
    private final String MA_LOAI_NV = "maLoaiNV";
    private final String TRANG_THAI = "trangThai";

    // sql Server
    private final String INSERT_STAFF= "INSERT INTO NHANVIEN VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE_STAFF="UPDATE NHANVIEN SET TENNV=?, GIOITINH=?, EMAIL=?, CMND=?, SDT=?,MALOAINV=?, TRANGTHAI=? WHERE MANV=?" ;
    private final String SELECT_ALL_STAFF = "SELECT * FROM NHANVIEN" ;
    private final String SELECT_ALL_STAFF_BY_STATUS="SELECT * FROM NHANVIEN WHERE (TRANGTHAI is not null and MALOAINV <> 'LNV001')";
    private final String SELECT_ALL_STAFF_BY_TYPE = "SELECT * FROM NHANVIEN WHERE (MALOAINV = ? AND TRANGTHAI IS NOT NULL)";
    private final String SELECT_STAFF_BY_CMND= "SELECT * FROM NHANVIEN WHERE CMND=?";
    private final String SELECT_STAFF_BYID = "select * from NhanVien where maNV = ?";
   
    
    // Lấy nhân viên bằng mã nhân viên
    public Staff getEmployeeBYID(String maNV) {
        staffTypeDAO = new StaffTypeDAO();
        try (Connection con = DatabaseConnection.opConnection();
                PreparedStatement ptm = con.prepareStatement(SELECT_STAFF_BYID)) {
            ptm.setString(1, maNV);
            try (ResultSet rs = ptm.executeQuery()) {               
                Staff staff = new Staff();
                if(rs.next()) {
                    StaffType staffType = staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                    staff.setMaNV(maNV);
                    staff.setTenNV(rs.getString(TEN_NV));
                    staff.setGioiTinh(rs.getInt(GIOI_TINH)==1);
                    staff.setEmail(rs.getString(EMAIL));
                    staff.setCmnd(rs.getString(CMND));
                    staff.setSdt(rs.getString(SDT));
                    staff.setStaffType(staffType);
                    staff.setTrangThai(rs.getString(TRANG_THAI));
                }
                return staff;
            } catch (Exception e) {
                System.out.println("Error");
                e.printStackTrace();               
            } 

        } catch (Exception e) {
            System.out.println("Connect fail");
            e.printStackTrace();
        }
        return null;
    }

    private final String SELECT_STAFF_BYID2 = "SELECT * FROM NHANVIEN WHERE MANV = ?";
    //Huy Tìm nhân viên theo mã
     public Staff findStaffById(String id) {
        staffTypeDAO = new StaffTypeDAO();
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_STAFF_BYID2) ){
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    StaffType staffType = staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                    Staff staff  = new Staff(rs.getString(Ma_NV), rs.getString(TEN_NV), rs.getInt(GIOI_TINH)==1, rs.getString(EMAIL), 
                            rs.getString(CMND), rs.getString(SDT),rs.getString(TRANG_THAI), staffType);
                   // System.err.println(staff.toString());
                    return staff;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
     public Staff findStaffByCMND(String maCMND) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(SELECT_STAFF_BY_CMND)) {
            pstmt.setString(1, maCMND);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()){
                String maNV = rs.getString(Ma_NV);
                String tenNV=rs.getString(TEN_NV);
                boolean gioiTinh= rs.getInt(GIOI_TINH) ==1;
                String email= rs.getString(EMAIL);
                String cmnd=rs.getString(CMND);
                String sdt=rs.getString(SDT);
                String trangThai=rs.getString(TRANG_THAI);
                staffTypeDAO=new StaffTypeDAO();
                StaffType st=staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                
                Staff staff=new Staff(maNV, tenNV, gioiTinh, email, cmnd, sdt, trangThai, st);
                return staff;
            }
            
        }catch (Exception e){
                System.err.println("getAllStaff():get data fail");
                e.printStackTrace();
        }
    }catch (Exception e){
            System.err.println("getAllStaff(): connect db fail");
            e.printStackTrace();
    }
        return null;
    }
     public List<Staff> getAllStaff()  {
        List<Staff> list = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt= conn.prepareStatement(SELECT_ALL_STAFF)){
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()){
                String maNV = rs.getString(Ma_NV);
                String tenNV=rs.getString(TEN_NV);
                boolean gioiTinh= rs.getInt(GIOI_TINH) ==1;
                String email= rs.getString(EMAIL);
                String cmnd=rs.getString(CMND);
                String sdt=rs.getString(SDT);
                String trangThai=rs.getString(TRANG_THAI);
                staffTypeDAO=new StaffTypeDAO();
                StaffType st=staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                
                Staff staff=new Staff(maNV, tenNV, gioiTinh, email, cmnd, sdt, trangThai, st);
                list.add(staff);
            }
            return list;
        }catch (Exception e){
                System.err.println("getAllStaff():get data fail");
                e.printStackTrace();
        }
        }catch (Exception e){
            System.err.println("getAllStaff(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }    
    public List<Staff> getAllStaffByStatus()  {
        List<Staff> list = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt= conn.prepareStatement(SELECT_ALL_STAFF_BY_STATUS)){
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()){
                String maNV = rs.getString(Ma_NV);
                String tenNV=rs.getString(TEN_NV);
                boolean gioiTinh= rs.getInt(GIOI_TINH) ==1;
                String email= rs.getString(EMAIL);
                String cmnd=rs.getString(CMND);
                String sdt=rs.getString(SDT);
                String trangThai=rs.getString(TRANG_THAI);
                staffTypeDAO=new StaffTypeDAO();
                StaffType st=staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                
                Staff staff=new Staff(maNV, tenNV, gioiTinh, email, cmnd, sdt, trangThai, st);
                list.add(staff);
            }
            return list;
        }catch (Exception e){
                System.err.println("getAllStaffByStatus():get data fail");
                e.printStackTrace();
        }
    }catch (Exception e){
            System.err.println("getAllStaffByStatus(): connect db fail");
            e.printStackTrace();
    }
        return null;
    }
    
    public List<Staff> getAllStaffByType(String maLNV)  {
        List<Staff> list = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt= conn.prepareStatement(SELECT_ALL_STAFF_BY_TYPE)){
            pstmt.setString(1, maLNV);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()){
                String maNV = rs.getString(Ma_NV);
                String tenNV=rs.getString(TEN_NV);
                boolean gioiTinh= rs.getInt(GIOI_TINH) ==1;
                String email= rs.getString(EMAIL);
                String cmnd=rs.getString(CMND);
                String sdt=rs.getString(SDT);
                String trangThai=rs.getString(TRANG_THAI);
                staffTypeDAO=new StaffTypeDAO();
                StaffType st=staffTypeDAO.findStaffTypeById(rs.getString(MA_LOAI_NV));
                
                Staff staff=new Staff(maNV, tenNV, gioiTinh, email, cmnd, sdt, trangThai, st);
                list.add(staff);
            }
            return list;
        }catch (Exception e){
                System.err.println("getAllStaffByType():get data fail");
                e.printStackTrace();
        }
        }catch (Exception e){
            System.err.println("getAllStaffByType(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }    
    
    

    public boolean insertStaff(Staff s) {
        try(
            Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(INSERT_STAFF);)
            {
                
                pstmt.setString(1, s.getMaNV());
                pstmt.setString(2, s.getTenNV());
                pstmt.setInt(3, s.getGioiTinh() ==true ? 1:0);
                pstmt.setString(4, s.getEmail());
                pstmt.setString(5, s.getCmnd());
                pstmt.setString(6, s.getSdt());
                pstmt.setString(7, s.getStaffType().getIdLoaiNV());
                pstmt.setString(8, s.getTrangThai());
                
                return  pstmt.executeUpdate()>0;

            } catch (Exception e) {
            System.err.println("insertStaff(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean updateStaff(Staff s) {
        try(
            Connection conn = DatabaseConnection.opConnection();  
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_STAFF);)
            {
                
                pstmt.setString(1, s.getTenNV());
                pstmt.setInt(2, s.getGioiTinh()==true?1:0);
                pstmt.setString(3, s.getEmail());
                pstmt.setString(4, s.getCmnd());
                pstmt.setString(5, s.getSdt());
                pstmt.setString(6, s.getStaffType().getIdLoaiNV());
                pstmt.setString(7, s.getTrangThai());
                pstmt.setString(8, s.getMaNV());
                
                
                 return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("updateStaff(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
     
}
