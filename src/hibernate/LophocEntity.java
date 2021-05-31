package hibernate;

import java.util.Objects;

public class LophocEntity {
    private int id;
    private String maLop;
    private String tenLop;
    private String maGvcn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGvcn() {
        return maGvcn;
    }

    public void setMaGvcn(String maGvcn) {
        this.maGvcn = maGvcn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LophocEntity that = (LophocEntity) o;
        return id == that.id && Objects.equals(maLop, that.maLop) && Objects.equals(tenLop, that.tenLop) && Objects.equals(maGvcn, that.maGvcn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maLop, tenLop, maGvcn);
    }
}
