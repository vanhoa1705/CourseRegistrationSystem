package DAO;

import hibernate.GiaovuEntity;
import hibernate.LophocEntity;
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
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SinhVienDAO {

    public static List<SinhvienEntity> getAllSinhVien() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<SinhvienEntity> sinhvien = null;

        try {
            final String hql = "select sv from SinhvienEntity sv";
            Query query = session.createQuery(hql);

            sinhvien = query.list();

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return sinhvien;
    }

    public static List<SinhvienEntity> getStudentByClass(LophocEntity lophoc, String keyword) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<SinhvienEntity> sinhvien = null;

        try {
            final String hql = "select sv from SinhvienEntity sv where lophoc = :lophoc and (tenSinhVien like :keyword or maSinhVien like :keyword)";
            Query query = session.createQuery(hql);
            query.setParameter("lophoc", lophoc);
            query.setParameter("keyword", "%" + keyword + "%");

            sinhvien = query.list();

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return sinhvien;
    }

    public static int createSinhVien(String name, String gender, String DOB, String address, LophocEntity lophoc){
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

            final String getMax = "select MAX(sv.maSinhVien) from SinhvienEntity sv";
            Query query = session.createQuery(getMax);
            List<String> t = query.list();
            String maSinhVien = String.valueOf(Integer.parseInt(t.get(0))  + 1);

            SinhvienEntity temp = new SinhvienEntity();
            temp.setTenSinhVien(name);
            temp.setGioiTinh(gender);
            temp.setNgaySinh(new java.sql.Date(date.getTime()));
            temp.setDiaChi(address);

            temp.setMaSinhVien(maSinhVien);
            temp.setTaiKhoan(maSinhVien);
            temp.setMatKhau(maSinhVien);
            temp.setLophoc(lophoc);
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

    public static SinhvienEntity Login(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhvienEntity> sinhvien = null;

        try {
            final String hql = "from SinhvienEntity sv WHERE sv.taiKhoan = :username and sv.matKhau = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username",username);
            query.setParameter("password",password);

            sinhvien = query.list();
            if(sinhvien.size() != 0){
                return sinhvien.get(0);
            }

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return null;
    }

    public static int[] countGender(int classId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        int[] result = new int[2];

        try {
            final String hql = "select count(id) from SinhvienEntity where gioiTinh = :gender and lophoc.id = :classId group by gioiTinh";
            Query query = session.createQuery(hql);
            query.setParameter("classId",classId);
            query.setParameter("gender", "Nam");
            Object temp1 = query.uniqueResult();
            if (temp1 != null){
                result[0]= Integer.parseInt(temp1.toString());
            }else {
                result[0] = 0;
            }

            query = session.createQuery(hql);
            query.setParameter("classId",classId);
            query.setParameter("gender","Nữ");
            Object temp2 = query.uniqueResult();
            if(temp2 != null){
                result[1]= Integer.parseInt(temp2.toString());
            }else {
                result[1] = 0;
            }
            return result;
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return null;
    }

    public static int ChangePassword(int id, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            final String hql = "update SinhvienEntity set matKhau =:password where id=:id";
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

    public static int updateSinhVien(int id, String name, String gender, String DOB, String address){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final String hql = "update SinhvienEntity set tenSinhVien =:name, gioiTinh =:gender, ngaySinh = :DOB, diaChi = :address where id=:id";
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
}
