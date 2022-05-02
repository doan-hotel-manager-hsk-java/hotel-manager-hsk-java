package dao;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDAO {

    private final String SELECT_LOAINV_BYID = "select maLoaiNV from NhanVien where maNV = ?";

    public String getMaLoaiNVBYID(String maNV) {
        String maLoaiNV = null;
        try (Connection con = DatabaseConnection.opConnection();
                PreparedStatement ptm = con.prepareStatement(SELECT_LOAINV_BYID)) {
            ptm.setString(1, maNV);
            ResultSet rs = ptm.executeQuery();
            
            while(rs.next()){
                maLoaiNV=rs.getString("maLoaiNV");
            }
            return  maLoaiNV;
        } catch (Exception e) {
        }
        return null;
    }
}
