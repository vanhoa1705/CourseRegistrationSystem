package DAO;

import hibernate.GiaovienEntity;
import hibernate.GiaovuEntity;
import hibernate.HockiEntity;
import hibernate.MonhocEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MonHocDAO {
    public static List<MonhocEntity> getAllMonHoc(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<MonhocEntity> monhoc = null;

        try {
            final String hql = "select mh from MonhocEntity mh";
            Query query = session.createQuery(hql);
            monhoc = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return monhoc;
    }

    public static List<MonhocEntity> searchMonHoc(String keyword){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<MonhocEntity> monhoc = null;

        try {
            final String hql = "select mh from MonhocEntity mh where mh.maMonHoc like :keyword or mh.tenMonHoc like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            monhoc = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return monhoc;
    }

    public static int updateMonHoc(int id, String code, String name, int credits){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final String hql = "update MonhocEntity set tenMonHoc =:name, soTinChi =:credits, maMonHoc=:code where id=:id";
            Query query = session.createQuery(hql);

            query.setParameter("id", id);
            query.setParameter("name", name);
            query.setParameter("credits", credits);
            query.setParameter("code", code);

            int result = query.executeUpdate();
            transaction.commit();
            return result;
        }catch (HibernateException e){
            transaction.rollback();
            System.err.println(e);
        }finally {
            session.close();
        }
        return 0;
    }

    public static int deleteMonHoc(MonhocEntity monhoc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(monhoc);
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

    public static int createMonHoc(String code, String name, int credits){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            MonhocEntity temp = new MonhocEntity();
            temp.setMaMonHoc(code);
            temp.setTenMonHoc(name);
            temp.setSoTinChi(credits);
            session.save(temp);

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

    public static String getTeacherByCode(String code){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            final String hql = "select gv from GiaovienEntity gv where gv.maGiaoVien = :code";
            Query query = session.createQuery(hql);
            query.setParameter("code", code);
            GiaovienEntity giaovien = (GiaovienEntity) query.list().get(0);
            return giaovien != null ? giaovien.getTenGiaoVien(): null;
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return null;
    }
}
