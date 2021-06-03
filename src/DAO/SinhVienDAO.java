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
}
