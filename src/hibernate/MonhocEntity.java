package hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MonhocEntity {
    private int id;
    private String maMonHoc;
    private String tenMonHoc;
    private Integer soTinChi;

    private Set<HocphanmoEntity> hocphanmoSet = new HashSet<HocphanmoEntity>(0);

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

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonhocEntity that = (MonhocEntity) o;
        return id == that.id && Objects.equals(maMonHoc, that.maMonHoc) && Objects.equals(tenMonHoc, that.tenMonHoc) && Objects.equals(soTinChi, that.soTinChi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maMonHoc, tenMonHoc, soTinChi);
    }
}
