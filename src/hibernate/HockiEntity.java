package hibernate;

import java.sql.Date;
import java.util.Objects;

public class HockiEntity {
    private int id;
    private String tenHocKi;
    private Integer namHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    }

    public Integer getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(Integer namHoc) {
        this.namHoc = namHoc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HockiEntity that = (HockiEntity) o;
        return id == that.id && Objects.equals(tenHocKi, that.tenHocKi) && Objects.equals(namHoc, that.namHoc) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenHocKi, namHoc, ngayBatDau, ngayKetThuc);
    }
}
