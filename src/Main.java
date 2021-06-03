import DAO.HocKiDAO;
import DAO.LopHocDAO;
import DAO.SinhVienDAO;
import components.Global;
import components.Login;
import hibernate.LophocEntity;
import hibernate.SinhvienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import javax.swing.*;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(final String[] args)  {
        HocKiDAO.getCurrentHK();

        JFrame frame = new Login();
        frame.setTitle("Login");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}