/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffTypeDAO {

    //Phuong
    //Variable
    private final String MA_LOAI_NV = "maLoaiNV";
    private final String TEN_LOAI_NV = "tenLoaiNV";
    private final String MUC_LUONG = "mucLuong";

    // sql server
    private final String SELECT_BY_ID = "select * from LoaiNhanVien where maLoaiNV = ?";

    public StaffType getByID(String maLoai) {
        try (Connection con = DatabaseConnection.opConnection();
                PreparedStatement ptm = con.prepareStatement(SELECT_BY_ID)) {
            ptm.setString(1, maLoai);
            try (ResultSet rs = ptm.executeQuery()) {
                if(rs.next()){
                     StaffType staffType = new StaffType(maLoai, rs.getString(TEN_LOAI_NV), rs.getDouble(MUC_LUONG));
                     return staffType;
                }                              
            } catch (Exception e) {
                System.out.println("error staff type");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
