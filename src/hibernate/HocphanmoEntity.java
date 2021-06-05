package hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HocphanmoEntity {
    private int id;
    private String maGvlt;
    private String tenHocPhan;
    private String tenPhongHoc;
    private String thu;
    private Integer ca;
    private Integer soLuong;
    private Integer daDangKi;


    private MonhocEntity monhoc;
    private HockiEntity hocki;

    public Set<SinhvienHocphanEntity> getSinhvienHocphanSet() {
        return sinhvienHocphanSet;
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

    public Integer getDaDangKi() {
        return daDangKi;
    }

    public void setDaDangKi(Integer daDangKi) {
        this.daDangKi = daDangKi;
    }

    private Set<SinhvienHocphanEntity> sinhvienHocphanSet = new HashSet<SinhvienHocphanEntity>(0);

    public MonhocEntity getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(MonhocEntity monhoc) {
        this.monhoc = monhoc;
    }

    @Override
    public String toString() {
        return "HocphanmoEntity{" +
                "id=" + id +
                ", maGvlt='" + maGvlt + '\'' +
                ", tenHocPhan='" + tenHocPhan + '\'' +
                ", tenPhongHoc='" + tenPhongHoc + '\'' +
                ", thu='" + thu + '\'' +
                ", ca=" + ca +
                ", soLuong=" + soLuong +
                ", monhoc=" + monhoc +
                ", hocki=" + hocki +
                ", sinhvienHocphanSet=" + sinhvienHocphanSet +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
