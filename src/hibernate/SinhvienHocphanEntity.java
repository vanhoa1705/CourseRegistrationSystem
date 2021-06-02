package hibernate;

import java.sql.Date;
import java.util.Objects;

public class SinhvienHocphanEntity {
    private int id;
    private int idSinhVien;
    private int idHocPhanMo;
    private Date ngayDangKi;

    private HocphanmoEntity hocphanmo;
    private SinhvienEntity sinhvien;

    public SinhvienEntity getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhvienEntity sinhvien) {
        this.sinhvien = sinhvien;
    }

    public HocphanmoEntity getHocphanmo() {
        return hocphanmo;
    }

    public void setHocphanmo(HocphanmoEntity hocphanmo) {
        this.hocphanmo = hocphanmo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public int getIdHocPhanMo() {
        return idHocPhanMo;
    }

    public void setIdHocPhanMo(int idHocPhanMo) {
        this.idHocPhanMo = idHocPhanMo;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienHocphanEntity that = (SinhvienHocphanEntity) o;
        return id == that.id && idSinhVien == that.idSinhVien && idHocPhanMo == that.idHocPhanMo && Objects.equals(ngayDangKi, that.ngayDangKi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSinhVien, idHocPhanMo, ngayDangKi);
    }
}
