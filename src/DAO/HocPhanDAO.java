package DAO;

import hibernate.HockiEntity;
import hibernate.HocphanmoEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

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

//    public static int createHocPhan();

}
