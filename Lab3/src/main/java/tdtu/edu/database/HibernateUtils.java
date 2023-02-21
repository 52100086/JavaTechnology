package tdtu.edu.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tdtu.edu.pojo.Manufacture;
import tdtu.edu.pojo.Phone;
import java.util.Properties;
public class HibernateUtils{
    private static final SessionFactory FACTORY;
    static {
        Configuration conf=new Configuration();

        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);


        //ServiceRegistry lớp trừu tượng
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }

}