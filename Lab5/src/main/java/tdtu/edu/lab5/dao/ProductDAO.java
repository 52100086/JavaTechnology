package tdtu.edu.lab5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tdtu.edu.lab5.model.Product;
import tdtu.edu.lab5.utils.HibernateUtils;

import java.util.List;

public class ProductDAO {
    private SessionFactory sessionFactory;

    public ProductDAO() {
        sessionFactory = HibernateUtils.getFactory();
    }

    public void create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Product read(int id) {
        Session session = sessionFactory.openSession();
        Product product = null;
        try {
            product = session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        List<Product> productList = null;
        try {
            productList = session.createQuery("from Product", Product.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productList;
    }

}