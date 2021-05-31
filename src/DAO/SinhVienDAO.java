package DAO;

import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.Collections;
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

    public static boolean Login(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhvienEntity> sinhvien = null;

        try {
            final String hql = "from SinhvienEntity sv WHERE sv.taiKhoan = :username and sv.matKhau = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username",username);
            query.setParameter("password",password);

            sinhvien = query.list();
            if(sinhvien.size() != 0){
                return true;
            }

        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }

        return false;
    }
}
