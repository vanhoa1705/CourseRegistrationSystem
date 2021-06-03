package hibernate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HockiEntity {
    private int id;
    private String tenHocKi;
    private String namHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private boolean isCurrent;

    private Set<ThoigiandkhpEntity> thoigiandkhpSet = new HashSet<ThoigiandkhpEntity>(0);
    private Set<HocphanmoEntity> hocphanmoSet = new HashSet<HocphanmoEntity>(0);

    public Set<HocphanmoEntity> getHocphanmoSet() {
        return hocphanmoSet;
    }

    public void setHocphanmoSet(Set<HocphanmoEntity> hocphanmoSet) {
        this.hocphanmoSet = hocphanmoSet;
    }

    public Set<ThoigiandkhpEntity> getThoigiandkhpSet() {
        return thoigiandkhpSet;
    }

    public void setThoigiandkhpSet(Set<ThoigiandkhpEntity> thoigiandkhpSet) {
        this.thoigiandkhpSet = thoigiandkhpSet;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    @Override
    public String toString() {
        return "HockiEntity{" +
                "id=" + id +
                ", tenHocKi='" + tenHocKi + '\'' +
                ", namHoc='" + namHoc + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", isCurrent=" + isCurrent +
                ", thoigiandkhpSet=" + thoigiandkhpSet +
                '}';
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

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

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
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

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean current) {
        isCurrent = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HockiEntity that = (HockiEntity) o;
        return id == that.id && Objects.equals(tenHocKi, that.tenHocKi) && Objects.equals(namHoc, that.namHoc) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc) && (isCurrent == that.isCurrent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenHocKi, namHoc, ngayBatDau, ngayKetThuc, isCurrent);
    }
}
