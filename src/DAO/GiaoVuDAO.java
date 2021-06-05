package DAO;

import hibernate.GiaovienEntity;
import hibernate.GiaovuEntity;
import hibernate.HockiEntity;
import hibernate.SinhvienEntity;
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

public class GiaoVuDAO {

    public static GiaovuEntity Login(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GiaovuEntity> giaovu = null;

        try {
            final String hql = "from GiaovuEntity gv WHERE gv.taiKhoan = :username and gv.matKhau = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username",username);
            query.setParameter("password",password);

            giaovu = query.list();
            if(giaovu.size() != 0){
                return giaovu.get(0);
            }

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return null;
    }

    public static List<GiaovuEntity> getAllGiaoVu(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GiaovuEntity> giaovu = null;

        try {
            final String hql = "select gv from GiaovuEntity gv";
            Query query = session.createQuery(hql);
            giaovu = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return giaovu;
    }

    public static List<GiaovuEntity> searchGiaoVu(String keyword){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GiaovuEntity> giaovu = null;

        try {
            final String hql = "select gv from GiaovuEntity gv where gv.maGiaoVu like :keyword or gv.tenGiaoVu like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            giaovu = query.list();

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return giaovu;
    }

    public static int updateGiaoVu(int id, String name, String gender, String DOB, String address){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final String hql = "update GiaovuEntity set tenGiaoVu =:name, gioiTinh =:gender, ngaySinh = :DOB, diaChi = :address where id=:id";
            Query query = session.createQuery(hql);

            DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = (Date) simpleDateFormat.parse(DOB);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Định dạng ngày là yyy-MM-dd!");
            }

            query.setParameter("id", id);
            query.setParameter("name", name);
            query.setParameter("gender", gender);
            query.setParameter("DOB", date);
            query.setParameter("address", address);

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

    public static int deleteGiaoVu(GiaovuEntity gv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(gv);

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

    public static int changePasswordGiaoVu(int id, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            final String hql = "update GiaovuEntity set matKhau =:password where id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("password", password);
            int result =query.executeUpdate();
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

    public static int createGiaoVu(String name, String gender, String DOB, String address){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = (Date) simpleDateFormat.parse(DOB);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Định dạng ngày là yyy-MM-dd!");
                return 0;
            }

            final String getMax = "select MAX(gv.maGiaoVu) from GiaovuEntity gv";
            Query query = session.createQuery(getMax);
            List<String> t = query.list();
            String maGiaoVu = String.valueOf(Integer.parseInt(t.get(0))  + 1);

            GiaovuEntity temp = new GiaovuEntity();
            temp.setTenGiaoVu(name);
            temp.setGioiTinh(gender);
            temp.setNgaySinh(new java.sql.Date(date.getTime()));
            temp.setDiaChi(address);

            temp.setMaGiaoVu(maGiaoVu);
            temp.setTaiKhoan(maGiaoVu);
            temp.setMatKhau(maGiaoVu);
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
