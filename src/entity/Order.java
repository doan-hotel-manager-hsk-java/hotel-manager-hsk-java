package entity;

import java.util.Objects;

/**
 *
 * @author ltuan
 */
public class Order {
    private String maHD;
    private String ngayVao;
    private String gioVao;
    private String ngayRa;
    private String gioRa;
    private String ngayLapHD;
    private int chietKhau;
    private Customer customer;
    private Room room;
    private Staff staff;

    public Order() {
    }

    public Order(String maHD, String ngayVao, String gioVao, String ngayRa, String gioRa, String ngayLapHD, int chietKhau, Customer customer, Room room, Staff staff) {
        this.maHD = maHD;
        this.ngayVao = ngayVao;
        this.gioVao = gioVao;
        this.ngayRa = ngayRa;
        this.gioRa = gioRa;
        this.ngayLapHD = ngayLapHD;
        this.chietKhau = chietKhau;
        this.customer = customer;
        this.room = room;
        this.staff = staff;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maHD);
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
        final Order other = (Order) obj;
        return Objects.equals(this.maHD, other.maHD);
    }
    
    
}
