package tdtu.edu;

import org.hibernate.Session;
import tdtu.edu.dao.ManufactureDAO;
import tdtu.edu.dao.PhoneDAO;
import tdtu.edu.database.HibernateUtils;
import tdtu.edu.pojo.Manufacture;
import tdtu.edu.pojo.Phone;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

//        //ADD PHONE
//        Manufacture m = new Manufacture("m1", "apple", "usa", 100);
//        Phone p = new Phone ("1", "iphone 11", 12000000, "black", "USA", 10, m);
//        System.out.println(PhoneDAO.getInstance().add(p));
//        Manufacture m = new Manufacture("m1", "apple", "usa", 100);
//        Phone p = new Phone ("2", "iphone X", 9000000, "black", "USA", 10, m);
//        System.out.println(PhoneDAO.getInstance().add(p));


        //get Phone by ID
//        System.out.println(PhoneDAO.getInstance().get(1));
//
//        //get all Phone
//        System.out.println("Get all phones: ");
//        for(Phone p : PhoneDAO.getInstance().getAll()){
//            System.out.println(p);
//        }

////        delete Phone by ID
//        System.out.println(PhoneDAO.getInstance().remove(1));

        // delete Phone by Object
//        System.out.println(PhoneDAO.getInstance().remove(p));

//          Update
//        System.out.println(PhoneDAO.getInstance().update(p));



//        Manufacture m2 = new Manufacture("m2", "samsung", "korea", 150);
//
//        System.out.println(ManufactureDAO.getInstance().add(m2));


        System.out.println(ManufactureDAO.getInstance().get("m2"));

        //        System.out.println("Get all manufacture: ");
        for(Manufacture m : ManufactureDAO.getInstance().getAll()){
            System.out.println(m);
        }

//        System.out.println(ManufactureDAO.getInstance().remove("m1"));


        System.out.println(PhoneDAO.getInstance().bestSelling());
        System.out.println(PhoneDAO.getInstance().above50Milion());
        System.out.println(PhoneDAO.getInstance().meetCriteria());


        System.out.println(ManufactureDAO.getInstance().MoreT100());
        System.out.println(ManufactureDAO.getInstance().count());
        System.out.println(ManufactureDAO.getInstance().meetCriteria());

    }
}
