package hibernate;

import java.sql.Date;
import java.util.Objects;

public class GiaovienMonHocEntity {
    private int id;
    private int id_giao_vien;
    private int id_mon_hoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_giao_vien() {
        return id_giao_vien;
    }

    public void setId_giao_vien(int id_giao_vien) {
        this.id_giao_vien = id_giao_vien;
    }

    public int getId_mon_hoc() {
        return id_mon_hoc;
    }

    public void setId_mon_hoc(int id_mon_hoc) {
        this.id_mon_hoc = id_mon_hoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovienMonHocEntity that = (GiaovienMonHocEntity) o;
        return id == that.id && id_giao_vien == that.id_giao_vien && id_mon_hoc == that.id_mon_hoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_giao_vien, id_mon_hoc);
    }
}
