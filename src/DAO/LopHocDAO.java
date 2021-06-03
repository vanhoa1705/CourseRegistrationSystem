package DAO;

import hibernate.LophocEntity;
import hibernate.MonhocEntity;
import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class LopHocDAO {
    public static List<LophocEntity> getAllLopHoc(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LophocEntity> lophoc = null;

        try {
            final String hql = "select lh from LophocEntity lh";
            Query query = session.createQuery(hql);
            lophoc = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return lophoc;
    }

    public static List<LophocEntity> searchLopHoc(String keyword){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<LophocEntity> lophoc = null;

        try {
            final String hql = "select lh from LophocEntity lh where lh.maLop like :keyword";
            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
            lophoc = query.list();
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return lophoc;
    }

    public static int updateLopHoc(int id, String code, String codeGVCN){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            final String hql = "update LophocEntity set maLop = :code, tenLop= :code, maGvcn =:codeGVCN where id=:id";
            Query query = session.createQuery(hql);

            query.setParameter("id", id);
            query.setParameter("code", code);
            query.setParameter("codeGVCN", codeGVCN);

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

    public static int deleteLopHoc(LophocEntity lophoc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(lophoc);
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

    public static int createLopHoc(String code, String codeGVCN){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            LophocEntity temp = new LophocEntity();
            temp.setMaLop(code);
            temp.setTenLop(code);
            temp.setMaGvcn(codeGVCN);
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

    public static List<LophocEntity> getSinhVienFromLopHoc(int classId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        LophocEntity lophoc = null;

        try {
            final String hql = "select lh from LophocEntity lh where lh.id = :classId";
            Query query = session.createQuery(hql);
            query.setParameter("classId",  classId );
            lophoc = (LophocEntity) query.uniqueResult();
            for (SinhvienEntity sv: lophoc.getSinhvienSet()){
                System.out.println(sv.getMaSinhVien());
            }
        }catch (HibernateException e){
            System.err.println(e);
        }finally {
            session.close();
        }
        return null;
    }

}
