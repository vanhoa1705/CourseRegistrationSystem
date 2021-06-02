package hibernate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SinhvienEntity {
    private int id;
    private String maSinhVien;
    private String tenSinhVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private int idLop;
    private String taiKhoan;
    private String matKhau;

    private LophocEntity lophoc;
    private Set<SinhvienHocphanEntity> sinhvienHocphanSet = new HashSet<SinhvienHocphanEntity>(0);

    public LophocEntity getLophoc() {
        return lophoc;
    }

    public void setLophoc(LophocEntity lophoc) {
        this.lophoc = lophoc;
    }

    public Set<SinhvienHocphanEntity> getSinhvienHocphanSet() {
        return sinhvienHocphanSet;
    }

    public void setSinhvienHocphanSet(Set<SinhvienHocphanEntity> sinhvienHocphanSet) {
        this.sinhvienHocphanSet = sinhvienHocphanSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienEntity that = (SinhvienEntity) o;
        return id == that.id && idLop == that.idLop && Objects.equals(maSinhVien, that.maSinhVien) && Objects.equals(tenSinhVien, that.tenSinhVien) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(diaChi, that.diaChi) && Objects.equals(taiKhoan, that.taiKhoan) && Objects.equals(matKhau, that.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maSinhVien, tenSinhVien, gioiTinh, ngaySinh, diaChi, idLop, taiKhoan, matKhau);
    }

    @Override
    public String toString() {
        return "SinhvienEntity{" +
                "id=" + id +
                ", maSinhVien='" + maSinhVien + '\'' +
                ", tenSinhVien='" + tenSinhVien + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", idLop=" + idLop +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
