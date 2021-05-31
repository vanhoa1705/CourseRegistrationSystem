import DAO.SinhVienDAO;
import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(final String[] args)  {
        System.out.println("===========");
        List<SinhvienEntity> sinhvien = SinhVienDAO.getAllSinhVien();
        for (SinhvienEntity sv: sinhvien){
            System.out.println(sv.toString());
        }
    }
}