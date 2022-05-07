/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ltuan
 */
public class OrderDetail {
    private int soLuong;
    private Order order;
    private Service service;
    
    private double thanhTien;

    public OrderDetail() {
    }

    public OrderDetail(int soLuong, Order order, Service service) {
        this.soLuong = soLuong;
        this.order = order;
        this.service = service;
    }
    
    public OrderDetail(int soLuong, Order order, Service service, double thanhTien) {
        this.soLuong = soLuong;
        this.order = order;
        this.service = service;
        this.thanhTien = thanhTien;
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

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    // HANDLE GET TONG TIEN
    public double getMoney() {
        return thanhTien = service.getDonGia() * getSoLuong();
    }
}
