/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class BookRoom {
    private String maDDP;
    private String ngayDat;
    private String gioDat;
    private String ngayNhan;
    private String gioNhan;
    private String maPhong;
    private String maKH;
    private String maNV;

    public BookRoom() {
    }
    
    public BookRoom(String maDDP, String ngayDat, String gioDat, String ngayNhan, String gioNhan, String maPhong, String maKH, String maNV) {
        this.maDDP = maDDP;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
        this.ngayNhan = ngayNhan;
        this.gioNhan = gioNhan;
        this.maPhong = maPhong;
        this.maKH = maKH;
        this.maNV = maNV;
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

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}
