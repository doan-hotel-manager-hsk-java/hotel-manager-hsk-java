/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Bao Tran
 */
public class OrderDetail_Room {
    
    private String tenPhong;
    private int soLuong;
    private Order order;
    private Service service;
    private double tongTien;

    public OrderDetail_Room() {
        
    }
    
    public OrderDetail_Room(String tenPhong, Service service, int soLuong, double tongTien) {
        this.tenPhong = tenPhong;
        this.service = service;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
    
    public OrderDetail_Room(int soLuong, Order order, Service service, String tenPhong) {
        this.soLuong = soLuong;
        this.order = order;
        this.service = service;
        this.tenPhong = tenPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    // HANDLE GET TONG TIEN
    public double getTongSoTien() {
        return tongTien = service.getDonGia() * getSoLuong();
    }
}
