package hibernate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GiaovienEntity {
    private int id;
    private String maGiaoVien;
    private String tenGiaoVien;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private int idMonHoc;

    private Set<GiaovienMonHocEntity> giaovienMonHocSet = new HashSet<GiaovienMonHocEntity>(0);

    public Set<GiaovienMonHocEntity> getGiaovienMonHocSet() {
        return giaovienMonHocSet;
    }

    public void setGiaovienMonHocSet(Set<GiaovienMonHocEntity> giaovienMonHocSet) {
        this.giaovienMonHocSet = giaovienMonHocSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
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

    public int getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovienEntity that = (GiaovienEntity) o;
        return id == that.id && idMonHoc == that.idMonHoc && Objects.equals(maGiaoVien, that.maGiaoVien) && Objects.equals(tenGiaoVien, that.tenGiaoVien) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(diaChi, that.diaChi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maGiaoVien, tenGiaoVien, gioiTinh, ngaySinh, diaChi, idMonHoc);
    }
}
