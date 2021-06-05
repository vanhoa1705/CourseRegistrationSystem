package DAO;

import components.Global;
import hibernate.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.swing.*;
import java.util.List;

public class HocPhanDAO {

    public static int deleteHocPhan(HocphanmoEntity hp){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(hp);
            transaction.commit();
            return 1;
        }catch (HibernateException e){
            transaction.rollback();
            System.err.println(e);
            return 0;
        }finally {
            session.close();
        }
    }

    public static int createHocPhan(String subjectCode, String teacherCode, String room, String day, int time, int slot){
        MonhocEntity monhoc = MonHocDAO.getSubjectByCode(subjectCode);
        GiaovienEntity giaovien = GiaoVienDAO.getTeacherByCode(teacherCode);
        if(monhoc == null){
            JOptionPane.showMessageDialog(null, "Mã môn học không tồn tại!");
            return 0;
        }
        if(giaovien == null){
            JOptionPane.showMessageDialog(null, "Mã giáo viên không tồn tại!");
            return 0;
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HocphanmoEntity temp = new HocphanmoEntity();
            temp.setMonhoc(monhoc);
            temp.setMaGvlt(giaovien.getMaGiaoVien());
            temp.setTenHocPhan(monhoc.getTenMonHoc());
            temp.setTenPhongHoc(room);
            temp.setThu(day);
            temp.setCa(time);
            temp.setSoLuong(slot);
            temp.setHocki(Global.currentHocKy);
            session.merge(temp);

            transaction.commit();
            return 1;
        }catch (HibernateException e){
            transaction.rollback();
            System.err.println(e);
        }finally {
            session.close();
        }
        return 0;
    }

    public static List<SinhvienHocphanEntity> getHocPhanBySV(SinhvienEntity sv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            final String hql = "select svhp from SinhvienHocphanEntity svhp where svhp.sinhvien = :sv";
            Query query = session.createQuery(hql);
            query.setParameter("sv", sv);
            List<SinhvienHocphanEntity> svhp = query.list();
            return svhp;
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return null;
    }

    public static int dangKiHocPhan(HocphanmoEntity hocphan){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            SinhvienHocphanEntity temp = new SinhvienHocphanEntity();
            temp.setHocphanmo(hocphan);
            temp.setSinhvien(Global.sinhvien);
            session.merge(temp);

            final String hql = "update HocphanmoEntity set daDangKi = :daDangKi where id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", hocphan.getId());
            query.setParameter("daDangKi", hocphan.getDaDangKi() + 1);
            query.executeUpdate();

            transaction.commit();
            return 1;
        }catch (HibernateException e){
            transaction.rollback();
            System.err.println(e);
        }finally {
            session.close();
        }
        return 0;
    }

    public static int huyDangKi(SinhvienHocphanEntity svhp){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hql = "delete from SinhvienHocphanEntity where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", svhp.getId());
            query.executeUpdate();

            String update = "update HocphanmoEntity set daDangKi = :daDangKi where id=:id";
            query = session.createQuery(update);
            query.setParameter("id", svhp.getHocphanmo().getId());
            query.setParameter("daDangKi", svhp.getHocphanmo().getDaDangKi() - 1);
            query.executeUpdate();

            transaction.commit();
            return 1;
        }catch (HibernateException e){
            transaction.rollback();
            System.err.println(e);
            return 0;
        }finally {
            session.close();
        }
    }

}
