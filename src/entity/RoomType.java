/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ltuan
 */
public class RoomType {
    private String maLoaiPhong;
    private String tenLoaiPhong;
    private double donGia;

    public RoomType() {
    }

    public RoomType(String maLoaiPhong, String tenLoaiPhong, double donGia) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.maLoaiPhong);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoomType other = (RoomType) obj;
        return Objects.equals(this.maLoaiPhong, other.maLoaiPhong);
    }
    
    
}
