package hibernate;

import java.sql.Date;
import java.util.Objects;

public class GiaovuEntity {
    private int id;
    private String maGiaoVu;
    private String tenGiaoVu;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String taiKhoan;
    private String matKhau;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiaoVu() {
        return maGiaoVu;
    }

    public void setMaGiaoVu(String maGiaoVu) {
        this.maGiaoVu = maGiaoVu;
    }

    public String getTenGiaoVu() {
        return tenGiaoVu;
    }

    public void setTenGiaoVu(String tenGiaoVu) {
        this.tenGiaoVu = tenGiaoVu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovuEntity that = (GiaovuEntity) o;
        return id == that.id && Objects.equals(maGiaoVu, that.maGiaoVu) && Objects.equals(tenGiaoVu, that.tenGiaoVu) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(diaChi, that.diaChi) && Objects.equals(taiKhoan, that.taiKhoan) && Objects.equals(matKhau, that.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maGiaoVu, tenGiaoVu, gioiTinh, ngaySinh, diaChi, taiKhoan, matKhau);
    }

    @Override
    public String toString() {
        return "GiaovuEntity{" +
                "id=" + id +
                ", maGiaoVu='" + maGiaoVu + '\'' +
                ", tenGiaoVu='" + tenGiaoVu + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
