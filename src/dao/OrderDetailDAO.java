/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DatabaseConnection;
import entity.Order;
import entity.OrderDetail;
import entity.Room;
import entity.Service;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author vomin
 */
public class OrderDetailDAO {

    // HANDLE LOAD ALL DATA TO TABLE LIST SERVICES ADDED
    public List<OrderDetail> getListServicesAdded() {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT p.tenPhong, dv.tenDV, cthd.soLuong, (cthd.soLuong*dv.donGia) AS ThanhTien FROM DichVu AS dv "
                + "INNER JOIN ChiTietHoaDon as cthd on dv.maDV=cthd.maDV "
                + "INNER JOIN HoaDon as hd on cthd.maHD=hd.maHD "
                + "INNER JOIN Phong as p on hd.maPhong=p.maPhong "
                + "GROUP BY p.tenPhong, dv.tenDV, cthd.soLuong, dv.donGia "
                + "ORDER BY p.tenPhong ASC";
        try (
                 Connection con = DatabaseConnection.opConnection();  Statement state = con.createStatement();  ResultSet res = state.executeQuery(sql);) {

            while (res.next()) {
                Order order = new Order();
                Room room = new Room();
                Service service = new Service();
                OrderDetail od = new OrderDetail();

                int soLuong = res.getInt("soLuong");

                service.setTenDV(res.getString("tenDV"));
                od.setService(service);

                room.setTenPhong(res.getString("tenPhong"));
                order.setRoom(room);
                od.setOrder(order);

                double thanhTien = res.getDouble("ThanhTien");

                OrderDetail odl = new OrderDetail(soLuong, order, service, thanhTien);
                list.add(odl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // HANDLE LOAD ALL DATA TO TABLE LIST SERVICES ADDED
    public List<OrderDetail> getListServicesByIdRoom(String idRoom) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select p.tenPhong, dv.tenDV, cthd.soLuong, hd.maHD, cthd.soLuong, (cthd.soLuong*dv.donGia) AS ThanhTien from Phong as p \n"
                + "						 join HoaDon as hd on p.maPhong=hd.maPhong\n"
                + "						 join ChiTietHoaDon as cthd on hd.maHD=cthd.maHD\n"
                + "						 join DichVu as dv on cthd.maDV=dv.maDV\n"
                + "where p.maPhong = ? and hd.tongTien is null";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, idRoom);
            ResultSet res = pres.executeQuery();

            while (res.next()) {
                Order order = new Order();
                Room room = new Room();
                Service service = new Service();
                OrderDetail od = new OrderDetail();

                int soLuong = res.getInt("soLuong");

                service.setTenDV(res.getString("tenDV"));
                od.setService(service);

                room.setTenPhong(res.getString("tenPhong"));
                order.setRoom(room);
                od.setOrder(order);

                double thanhTien = res.getDouble("ThanhTien");

                OrderDetail odl = new OrderDetail(soLuong, order, service, thanhTien);
                list.add(odl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // HANDLE ADD SERVICE
    public boolean addServiceToOrderDetail(OrderDetail od) {
        String sql = "INSERT INTO ChiTietHoaDon (soLuong, maHD, maDV) VALUES(?, ?, ?)";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setInt(1, od.getSoLuong());
            pres.setString(2, od.getOrder().getMaHD());
            pres.setString(3, od.getService().getMaDV());

            return pres.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // HANDLE DELETE SERVICE
    public boolean deleteServiceOutOrderDetail(OrderDetail od) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE maDV = ? AND maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, od.getService().getMaDV());
            pres.setString(2, od.getOrder().getMaHD());

            return pres.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // HANDLE UPDATE SERVICE
    public boolean updateServiceInOrderDetail(OrderDetail od) {
        String sql = "UPDATE ChiTietHoaDon SET soLuong = ? WHERE maHD = ? AND maDV = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setInt(1, od.getSoLuong());
            pres.setString(2, od.getOrder().getMaHD());
            pres.setString(3, od.getService().getMaDV());

            return pres.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // FIND BY ID SERVICE + ID ORDER
    public OrderDetail getOrderDetail(String idService, String idOrder) {
        String sql = "SELECT * FROM ChiTietHoaDon WHERE maDV = ? AND maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, idService);
            pres.setString(2, idOrder);
            ResultSet res = pres.executeQuery();

            Service service = new Service();
            Order o = new Order();

            if (res.next()) {
                OrderDetail od = new OrderDetail();
                od.setSoLuong(res.getInt("soLuong"));
                service.setMaDV(res.getString("maDV"));
                od.setService(service);
                o.setMaHD(res.getString("maHD"));
                od.setOrder(o);

                return od;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // FIND BY ID ID ORDER
    public OrderDetail getOrderDetailById(String idOrder) {
        String sql = "SELECT * FROM ChiTietHoaDon WHERE maHD = ?";
        try (
                 Connection con = DatabaseConnection.opConnection();  PreparedStatement pres = con.prepareStatement(sql);) {

            pres.setString(1, idOrder);
            ResultSet res = pres.executeQuery();

            if (res.next()) {
                Service service = new Service();
                Order o = new Order();
                OrderDetail od = new OrderDetail();
                od.setSoLuong(res.getInt("soLuong"));
                service.setMaDV(res.getString("maDV"));
                od.setService(service);
                o.setMaHD(res.getString("maHD"));
                od.setOrder(o);

                return od;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
