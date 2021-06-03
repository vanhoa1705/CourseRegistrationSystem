package DAO;

import components.Global;
import hibernate.HockiEntity;
import hibernate.MonhocEntity;
import hibernate.ThoigiandkhpEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HocKiDAO {
    public static List<HockiEntity> getAllHocKy(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<HockiEntity> hocki = null;

        try {
            final String hql = "select hk from HockiEntity hk";
            Query query = session.createQuery(hql);
            hocki = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return hocki;
    }

    public static List<HockiEntity> searchHocKi(String keyword){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<HockiEntity> hocki = null;

        try {
            final String hql = "select hk from HockiEntity hk where hk.namHoc like :keyword or hk.tenHocKi like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            hocki = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return hocki;
    }

    public static int setCurrentHK(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final String update = "update HockiEntity set isCurrent = 0 where 1=1";
            Query query = session.createQuery(update);
            query.executeUpdate();

            final String hql = "update HockiEntity set isCurrent = 1 where id=:id";
            query = session.createQuery(hql);
            query.setParameter("id", id);
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

    public static int deleteHocKi(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            final String hql = "select hk from HockiEntity hk where id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<HockiEntity> hocki = query.list();
            session.delete(hocki.get(0));

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

    public static int createHocKi(String name, String year, Date startDate, Date endDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HockiEntity temp = new HockiEntity();
            temp.setTenHocKi(name);
            temp.setNamHoc(year);
            temp.setNgayBatDau(new java.sql.Date(startDate.getTime()));
            temp.setNgayKetThuc(new java.sql.Date(endDate.getTime()));
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

    public static void getCurrentHK(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            final String update = "select hk from HockiEntity hk where isCurrent = true";
            Query query = session.createQuery(update);
            List<HockiEntity> temp = query.list();
            Global.currentHocKy = temp.get(0);
            return;
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return;
    }

    public static int createTGDK(Date startDate, Date endDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ThoigiandkhpEntity temp = new ThoigiandkhpEntity();
            temp.setHocKi(Global.currentHocKy);
            temp.setNgayBatDau(new java.sql.Date(startDate.getTime()));
            temp.setNgayKetThuc(new java.sql.Date(endDate.getTime()));
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


}
