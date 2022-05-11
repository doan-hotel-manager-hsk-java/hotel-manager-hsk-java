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
public class Room {
    private String maPhong;
    private String tenPhong;
    private int tang;
    private RoomType roomType;
    private RoomStatusType roomStatusType;
    private Staff staff;

    public Room() {
    }

    public Room(String maPhong, String tenPhong, int tang, RoomType roomType, RoomStatusType roomStatusType, Staff staff) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tang = tang;
        this.roomType = roomType;
        this.roomStatusType = roomStatusType;
        this.staff = staff;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatusType getRoomStatusType() {
        return roomStatusType;
    }

    public void setRoomStatusType(RoomStatusType roomStatusType) {
        this.roomStatusType = roomStatusType;
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
        hash = 71 * hash + Objects.hashCode(this.maPhong);
        hash = 71 * hash + Objects.hashCode(this.tenPhong);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.maPhong, other.maPhong)) {
            return false;
        }
        return Objects.equals(this.tenPhong, other.tenPhong);
    }

    @Override
    public String toString() {
        return "Room{" + "maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", tang=" + tang + ", roomType=" + roomType + ", roomStatusType=" + roomStatusType + ", staff=" + staff + '}';
    }
    
    
}
