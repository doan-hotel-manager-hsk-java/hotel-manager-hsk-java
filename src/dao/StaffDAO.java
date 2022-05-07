package dao;

import connection.DatabaseConnection;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDAO {
    StaffTypeDAO staffTypeDAO;

    //Phuong
    // variable
    private final String TEN_NV = "tenNV";
    private final String GIOI_TINH = "gioiTinh";
    private final String EMAIL = "email";
    private final String CMND = "cmnd";
    private final String SDT = "sdt";
    private final String MA_LOAI_NV = "maLoaiNV";
    private final String TRANG_THAI = "trangThai";

    // sql Server
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
                    staff.setGioiTinh(rs.getString(GIOI_TINH));
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
    
    
}
