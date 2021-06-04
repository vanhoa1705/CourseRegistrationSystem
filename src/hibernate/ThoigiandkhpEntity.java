package hibernate;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ThoigiandkhpEntity {
    private int id;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    private HockiEntity hocKi;

    public HockiEntity getHocKi() {
        return hocKi;
    }

    public void setHocKi(HockiEntity hocKi) {
        this.hocKi = hocKi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
