package hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HocphanmoEntity {
    private int id;
    private int idMonHoc;
    private int idThoiGianDkhp;
    private String maGvlt;
    private String tenHocPhan;
    private String tenPhongHoc;
    private String thu;
    private Integer ca;
    private Integer soLuong;
    private Integer idHocKi;

    private MonhocEntity monhoc;
    private HockiEntity hocki;

    public Set<SinhvienHocphanEntity> getSinhvienHocphanSet() {
        return sinhvienHocphanSet;
    }

    public Integer getIdHocKi() {
        return idHocKi;
    }

    public void setIdHocKi(Integer idHocKi) {
        this.idHocKi = idHocKi;
    }

    public HockiEntity getHocki() {
        return hocki;
    }

    public void setHocki(HockiEntity hocki) {
        this.hocki = hocki;
    }

    public void setSinhvienHocphanSet(Set<SinhvienHocphanEntity> sinhvienHocphanSet) {
        this.sinhvienHocphanSet = sinhvienHocphanSet;
    }

    private Set<SinhvienHocphanEntity> sinhvienHocphanSet = new HashSet<SinhvienHocphanEntity>(0);

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

    public int getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public int getIdThoiGianDkhp() {
        return idThoiGianDkhp;
    }

    public void setIdThoiGianDkhp(int idThoiGianDkhp) {
        this.idThoiGianDkhp = idThoiGianDkhp;
    }

    public String getMaGvlt() {
        return maGvlt;
    }

    public void setMaGvlt(String maGvlt) {
        this.maGvlt = maGvlt;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HocphanmoEntity that = (HocphanmoEntity) o;
        return id == that.id && idMonHoc == that.idMonHoc && idThoiGianDkhp == that.idThoiGianDkhp && Objects.equals(maGvlt, that.maGvlt) && Objects.equals(tenHocPhan, that.tenHocPhan) && Objects.equals(tenPhongHoc, that.tenPhongHoc) && Objects.equals(thu, that.thu) && Objects.equals(ca, that.ca) && Objects.equals(soLuong, that.soLuong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMonHoc, idThoiGianDkhp, maGvlt, tenHocPhan, tenPhongHoc, thu, ca, soLuong);
    }
}
