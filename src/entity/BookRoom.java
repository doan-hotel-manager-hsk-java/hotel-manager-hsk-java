/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

public class BookRoom {
   private String maDDP;
   private String ngayDat;
   private String gioDat;
   private String ngayNhan;
   private String gioNhan;
   private Room room;
   private Customer customer;
   private Staff staff;

    public BookRoom() {
    }

    public BookRoom(String maDDP, String ngayDat, String gioDat, String ngayNhan, 
            String gioNhan, Room room, Customer customer, Staff staff) {
        this.maDDP = maDDP;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
        this.ngayNhan = ngayNhan;
        this.gioNhan = gioNhan;
        this.room = room;
        this.customer = customer;
        this.staff = staff;
    }

    public String getMaDDP() {
        return maDDP;
    }

    public void setMaDDP(String maDDP) {
        this.maDDP = maDDP;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getGioDat() {
        return gioDat;
    }

    public void setGioDat(String gioDat) {
        this.gioDat = gioDat;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getGioNhan() {
        return gioNhan;
    }

    public void setGioNhan(String gioNhan) {
        this.gioNhan = gioNhan;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        hash = 37 * hash + Objects.hashCode(this.maDDP);
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
        final BookRoom other = (BookRoom) obj;
        return Objects.equals(this.maDDP, other.maDDP);
    }
   
   
}
