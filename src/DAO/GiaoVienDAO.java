package DAO;

import hibernate.GiaovienEntity;
import hibernate.MonhocEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

public class GiaoVienDAO {
    public static GiaovienEntity getTeacherByCode(String code){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            final String hql = "select gv from GiaovienEntity gv where gv.maGiaoVien = :code";
            Query query = session.createQuery(hql);
            query.setParameter("code", code);
            GiaovienEntity giaovien = (GiaovienEntity) query.list().get(0);
            return giaovien;
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return null;
    }
}
