
package dao;

import connection.DatabaseConnection;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vomin
 */
public class CustomerDAO {

    //tuan
    private final String MA_KH = "MAKH";
    private final String TEN_KH = "TENKH";
    private final String SDT = "SDT";
    private final String GIOI_TINH = "GIOITINH";
    private final String DIA_CHI = "DIACHI";

    private final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM KHACHHANG WHERE MAKH = ?";
    private final String SELECT_CUSTOMER_BY_LASTNAME = "SELECT * FROM KHACHHANG WHERE TENKH LIKE ?";
    private final String SELECT_CUSTOMER_BY_FIRSTNAME = "SELECT * FROM KHACHHANG WHERE TENKH LIKE ?";
    private final String UPDATE_CUSTOMER_BY_ID = "UPDATE KHACHHANG SET TENKH = ?, SDT = ?, GIOITINH = ?, DIACHI = ? WHERE MAKH = ?";
    private final String INSERT_CUSTOMER = "INSERT INTO KHACHHANG(MAKH,TENKH,SDT,GiOITINH,DIACHI) values(?,?,?,?,?)";

    public Customer findCustomerById(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String ma = rs.getString(MA_KH);
                    String ten = rs.getString(TEN_KH);
                    String sdt = rs.getString(SDT);
                    boolean gioiTinh = rs.getBoolean(GIOI_TINH);
                    String diaChi = rs.getString(DIA_CHI);

                    Customer cus = new Customer(ma, ten, sdt, gioiTinh, diaChi);
                    return cus;
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

    public List<Customer> findCustomerByLastName(String name) {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_CUSTOMER_BY_LASTNAME)) {
            pstmt.setString(1, "%" + name);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String ma = rs.getString(MA_KH);
                    String ten = rs.getString(TEN_KH);
                    String sdt = rs.getString(SDT);
                    boolean gioiTinh = rs.getBoolean(GIOI_TINH);
                    String diaChi = rs.getString(DIA_CHI);

                    Customer cus = new Customer(ma, ten, sdt, gioiTinh, diaChi);
                    customers.add(cus);
                }
                return customers;
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

    public List<Customer> findCustomerByFirstName(String name) {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_CUSTOMER_BY_FIRSTNAME)) {
            pstmt.setString(1, name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String ma = rs.getString(MA_KH);
                    String ten = rs.getString(TEN_KH);
                    String sdt = rs.getString(SDT);
                    boolean gioiTinh = rs.getInt(GIOI_TINH) == 1;
                    String diaChi = rs.getString(DIA_CHI);

                    Customer cus = new Customer(ma, ten, sdt, gioiTinh, diaChi);
                    customers.add(cus);
                }
                return customers;
            } catch (Exception e) {
                System.err.println("findCustomerByFirstName(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findCustomerByFirstName(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertCustomer(Customer customer) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement(INSERT_CUSTOMER)) {
            pstmt.setString(1, customer.getMaKH());
            pstmt.setString(2, customer.getTenKH());
            pstmt.setString(3, customer.getSoDT());
            pstmt.setBoolean(4, customer.isGioiTinh());
            pstmt.setString(5, customer.getDiaChi());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCustomerById(Customer customer) {
        try ( Connection conn = DatabaseConnection.opConnection();  PreparedStatement pstmt = conn.prepareStatement(UPDATE_CUSTOMER_BY_ID)) {
            pstmt.setString(1, customer.getTenKH());
            pstmt.setString(2, customer.getSoDT());
            pstmt.setInt(3, customer.isGioiTinh() == true ? 1 : 0);
            pstmt.setString(4, customer.getDiaChi());
            pstmt.setString(5, customer.getMaKH());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("updateCustomerById(): get data fail");
            e.printStackTrace();
        }
        return false;
    }
}
