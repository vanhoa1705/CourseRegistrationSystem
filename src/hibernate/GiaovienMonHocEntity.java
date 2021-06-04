package hibernate;

import java.sql.Date;
import java.util.Objects;

public class GiaovienMonHocEntity {
    private int id;
    private MonhocEntity monhoc;
    private GiaovienEntity giaovien;

    public GiaovienEntity getGiaovien() {
        return giaovien;
    }

    public void setGiaovien(GiaovienEntity giaovien) {
        this.giaovien = giaovien;
    }

    public MonhocEntity getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonhocEntity monhoc) {
        this.monhoc = monhoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
