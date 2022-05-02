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
public class RoomStatusType {
    private String maLoaiTTP;
    private String tenLoai;

    public RoomStatusType() {
    }

    public RoomStatusType(String maLoaiTTP, String tenLoai) {
        this.maLoaiTTP = maLoaiTTP;
        this.tenLoai = tenLoai;
    }

    public String getMaLoaiTTP() {
        return maLoaiTTP;
    }

    public void setMaLoaiTTP(String maLoaiTTP) {
        this.maLoaiTTP = maLoaiTTP;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.maLoaiTTP);
        hash = 37 * hash + Objects.hashCode(this.tenLoai);
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
        final RoomStatusType other = (RoomStatusType) obj;
        if (!Objects.equals(this.maLoaiTTP, other.maLoaiTTP)) {
            return false;
        }
        return Objects.equals(this.tenLoai, other.tenLoai);
    }
    
    
}
