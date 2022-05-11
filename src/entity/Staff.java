package entity;

import java.util.Objects;

public class Staff {
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private String email;
    private String cmnd;
    private String sdt;
    private String trangThai;
    private StaffType staffType;

    public Staff() {
    }

    public Staff(String maNV, String tenNV, String gioiTinh, String email, String cmnd, String sdt, String trangThai, StaffType staffType) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.staffType = staffType;
    }

    public Staff(String tenNV, String gioiTinh, String email, String cmnd, String sdt, String trangThai, StaffType staffType) {
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.staffType = staffType;
    }
    
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.maNV);
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
        final Staff other = (Staff) obj;
        return Objects.equals(this.maNV, other.maNV);
    }

    @Override
    public String toString() {
        return "Staff{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", email=" + email + ", cmnd=" + cmnd + ", sdt=" + sdt + ", trangThai=" + trangThai + ", staffType=" + staffType + '}';
    }
    
}
