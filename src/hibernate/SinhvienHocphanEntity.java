package hibernate;

import java.sql.Date;
import java.util.Objects;

public class SinhvienHocphanEntity {
    private int id;
    private int idSinhVien;
    private int idHocPhanMo;
    private Date ngayDangKi;

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
