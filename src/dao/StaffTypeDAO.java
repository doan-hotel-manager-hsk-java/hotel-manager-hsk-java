/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.StaffType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffTypeDAO {
    //tuan
    private final String MA_LOAI_NV = "MALOAINV";
    private final String TEN_LOAI_NV = "TENLOAINV";
    private final String MUC_LUONG = "MUCLUONG";
    
    private final String SELECT_ALL_STAFF_TYPE = "SELECT * FROM LOAINHANVIEN";
    private final String SELECT_STAFF_TYPE_BY_ID = "SELECT * FROM LOAINHANVIEN WHERE MALOAINV = ?";
    
    public List<StaffType> getAllStaffTypes() {
        List<StaffType> staffTypes = new ArrayList<>();
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_STAFF_TYPE)) {
            try(ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    String maLoaiNV = rs.getString(MA_LOAI_NV);
                    String tenLoaiNV = rs.getString(TEN_LOAI_NV);
                    Double mucLuong = rs.getDouble(MUC_LUONG);
                    
                    StaffType staffType = new StaffType(maLoaiNV, tenLoaiNV, mucLuong);
                    staffTypes.add(staffType);
                }
                
                return staffTypes;
            }
        }catch(Exception e) {
             System.err.println("getAllStaffTypes(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public StaffType finRoomStatusTypeById(String id) {
        try(Connection conn = DatabaseConnection.opConnection();
               PreparedStatement pstmt = conn.prepareStatement(SELECT_STAFF_TYPE_BY_ID) ) {
            pstmt.setString(1, id);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String maLoaiNV = rs.getString(MA_LOAI_NV);
                    String tenLoaiNV = rs.getString(TEN_LOAI_NV);
                    Double mucLuong = rs.getDouble(MUC_LUONG);
                    
                    StaffType staffType = new StaffType(maLoaiNV, tenLoaiNV, mucLuong);
                    return staffType;
                }
            }
        }catch(Exception e) {
             System.err.println("finRoomStatusTypeById(): connect db fail");
            e.printStackTrace();
        }
        
        return null;
    }
}
