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
public class Device {
    private String maTTB;
    private String tenTTB;
    private int soLuongTon;
    private String donVi;
    private double gia;
    private String trangThai;
    private Staff staff;

    public Device() {
    }

    public Device(String maTTB, String tenTTB, int soLuongTon, String donVi, double gia, String trangThai, Staff staff) {
        this.maTTB = maTTB;
        this.tenTTB = tenTTB;
        this.soLuongTon = soLuongTon;
        this.donVi = donVi;
        this.gia = gia;
        this.trangThai = trangThai;
        this.staff = staff;
    }

    public String getMaTTB() {
        return maTTB;
    }

    public void setMaTTB(String maTTB) {
        this.maTTB = maTTB;
    }

    public String getTenTTB() {
        return tenTTB;
    }

    public void setTenTTB(String tenTTB) {
        this.tenTTB = tenTTB;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.maTTB);
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
        final Device other = (Device) obj;
        return Objects.equals(this.maTTB, other.maTTB);
    }
    
}
