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
public class StaffType {
    private String idLoaiNV;
    private String tenLoaiNV;
    private double mucLuong;

    public StaffType() {
    }

    public StaffType(String idLoaiNV, String tenLoaiNV, double mucLuong) {
        this.idLoaiNV = idLoaiNV;
        this.tenLoaiNV = tenLoaiNV;
        this.mucLuong = mucLuong;
    }

    public StaffType( String tenLoaiNV, double mucLuong) {
        this.idLoaiNV = idLoaiNV;
        this.tenLoaiNV = tenLoaiNV;
        this.mucLuong = mucLuong;
    }
    
    public String getIdLoaiNV() {
        return idLoaiNV;
    }

    public void setIdLoaiNV(String idLoaiNV) {
        this.idLoaiNV = idLoaiNV;
    }

    public String getTenLoaiNV() {
        return tenLoaiNV;
    }

    public void setTenLoaiNV(String tenLoaiNV) {
        this.tenLoaiNV = tenLoaiNV;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idLoaiNV);
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
        final StaffType other = (StaffType) obj;
        return Objects.equals(this.idLoaiNV, other.idLoaiNV);
    }
}
