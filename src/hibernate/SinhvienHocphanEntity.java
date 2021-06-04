package hibernate;

import java.sql.Date;
import java.util.Objects;

public class SinhvienHocphanEntity {
    private int id;
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

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }
}
