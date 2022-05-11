/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Service;
import entity.ServiceType;
import entity.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class ServiceDAO {

    // LOAD DATA TO LIST SERVICE
    public List<Service> getServices() throws ClassNotFoundException, SQLException {
        List<Service> listService = new ArrayList<>();
        String sql = "SELECT * FROM DichVu";
        try (
                Connection con = DatabaseConnection.opConnection();
                Statement state = con.createStatement();
                ResultSet res = state.executeQuery(sql);) {
            while (res.next()) {
                String tenDV = res.getString("tenDV");
                double donGia = Double.parseDouble(res.getString("donGia"));
                String trangThai = res.getString("trangThai");

                Service service = new Service(tenDV, donGia, trangThai);
                listService.add(service);
            }
            return listService;
        }
    }

    // FIND BY ID SERVICE
    public Service getServiceById(String maDV) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM DichVu WHERE maDV = ?";
        try (
                Connection con = DatabaseConnection.opConnection();
                PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, maDV);
            ResultSet res = pres.executeQuery();

            if (res.next()) {
                Service service = new Service();
                service.setMaDV(res.getString("maDV"));
                service.setTenDV(res.getString("tenDV"));
                service.setDonGia(res.getDouble("donGia"));
                service.setTrangThai(res.getString("trangThai"));

                return service;
            }
            return null;
        }
    }

    // FIND BY NAME SERVICE
    public Service getServiceByName(String tenDV) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM DichVu WHERE tenDV = ?";
        try (
                Connection con = DatabaseConnection.opConnection();
                PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, tenDV);
            ResultSet res = pres.executeQuery();

            if (res.next()) {
                Service service = new Service();
                service.setMaDV(res.getString("maDV"));
                service.setTenDV(res.getString("tenDV"));
                service.setDonGia(res.getDouble("donGia"));
                service.setTrangThai(res.getString("trangThai"));
                //service.setServiceType(res.getObject(res.getString("maLDV"), ServiceType.class));
                //service.setStaff(res.getObject(res.getString("maNV"), Staff.class));

                return service;
            }
            return null;
        }
    }
    //GET ALL SERVICE
    private final ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
    private final StaffDAO staffDAO = new StaffDAO();

    private final String SELECT_ALL_SERVICE = "SELECT * FROM DICHVU";
    private final String UPDATE_SERVICE_BYID = "UPDATE DICHVU SET  TENDV = ?, DONGIA = ?, MANV = ? WHERE MADV = ?";
    private final String ADD_SERVICE_BYID = "INSERT into DICHVU  values (?,?,?,?,?,?)";
    private final String DELETE_SERVICE_BYID = "UPDATE DICHVU SET TRANGTHAI = ?, MANV = ? WHERE MADV = ? ";
    private final String SELECT_SERVICE_BY_NAME = "SELECT * FROM DICHVU WHERE tenDV = ?";
    private final String SELECT_SERVICE_BY_ID = "SELECT * FROM DICHVU WHERE MADV = ?";

    private final String MALDV = "MALDV";
    private final String MANV = "maNV";
    private final String MADV = "MADV";
    private final String TENDV = "TENDV";
    private final String DONGIA = "DONGIA";
    private final String TRANGTHAI = "TRANGTHAI";

    public List<Service> getAllService() {
        List<Service> Services = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SERVICE)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ServiceType roomType = serviceTypeDAO.findServiceTypeById(rs.getString(MALDV));
                    Staff staff = staffDAO.findStaffById(rs.getString(MANV));

                    Service Service = new Service(rs.getString(MADV), rs.getString(TENDV),
                            rs.getDouble(DONGIA), rs.getString(TRANGTHAI), roomType, staff);
                    Services.add(Service);
                }

                return Services;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllServices(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public boolean addService(Service service) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(ADD_SERVICE_BYID)) {
            pstmt.setString(1, service.getMaDV());
            pstmt.setString(2, service.getTenDV());
            pstmt.setDouble(3, service.getDonGia());
            pstmt.setString(4, service.getTrangThai());
            pstmt.setString(5, service.getServiceType().getMaLoaiDV());
            pstmt.setString(6, service.getStaff().getMaNV());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateService(Service service) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(UPDATE_SERVICE_BYID)) {
            pstmt.setString(1, service.getTenDV());
            pstmt.setDouble(2, service.getDonGia());
            pstmt.setString(3, service.getStaff().getMaNV());
            pstmt.setString(4, service.getMaDV());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteService(Service service) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(DELETE_SERVICE_BYID)) {
            pstmt.setString(1, service.getTrangThai());
            pstmt.setString(2, service.getStaff().getMaNV());
            pstmt.setString(3, service.getMaDV());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Service findServiceByName(String name) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_SERVICE_BY_NAME)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ServiceType serviceType = serviceTypeDAO.findServiceTypeById(rs.getString(MALDV));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MANV));

                    Service service = new Service(rs.getString(MANV), rs.getString(TENDV),
                            rs.getDouble(DONGIA), rs.getString(TRANGTHAI), serviceType, staff);

                    return service;
                }
            } catch (Exception e) {
                System.err.println("findServiceByName(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findServiceByName(): connect db fail");
        }
        return null;
    }

    public Service findServiceByID(String ID) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_SERVICE_BY_ID)) {
            pstmt.setString(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ServiceType serviceType = serviceTypeDAO.findServiceTypeById(rs.getString(MALDV));
                    Staff staff = staffDAO.getEmployeeBYID(rs.getString(MANV));

                    Service service = new Service(rs.getString(MADV), rs.getString(TENDV),
                            rs.getDouble(DONGIA), rs.getString(TRANGTHAI), serviceType, staff);

                    return service;
                }
            } catch (Exception e) {
                System.err.println("findServiceByName(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findServiceByName(): connect db fail");
        }
        return null;
    }
}
