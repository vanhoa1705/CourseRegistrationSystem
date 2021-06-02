package hibernate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ThoigiandkhpEntity {
    private int id;
    private int idKi;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    private HockiEntity hocKi;
    private Set<HocphanmoEntity> hocphanmoSet = new HashSet<HocphanmoEntity>(0);

    public HockiEntity getHocKi() {
        return hocKi;
    }

    public void setHocKi(HockiEntity hocKi) {
        this.hocKi = hocKi;
    }

    public Set<HocphanmoEntity> getHocphanmoSet() {
        return hocphanmoSet;
    }

    public void setHocphanmoSet(Set<HocphanmoEntity> hocphanmoSet) {
        this.hocphanmoSet = hocphanmoSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKi() {
        return idKi;
    }

    public void setIdKi(int idKi) {
        this.idKi = idKi;
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
        ThoigiandkhpEntity that = (ThoigiandkhpEntity) o;
        return id == that.id && idKi == that.idKi && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idKi, ngayBatDau, ngayKetThuc);
    }
}
