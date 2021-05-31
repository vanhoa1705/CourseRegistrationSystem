package DAO;

import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class GiaoVuDAO {

    public static boolean Login(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhvienEntity> sinhvien = null;

        try {
            final String hql = "from GiaovuEntity gv WHERE gv.taiKhoan = :username and gv.matKhau = :password";
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
