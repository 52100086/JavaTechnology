package tdtu.edu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tdtu.edu.model.Product;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigure.class);
        Product prod1 = context.getBean("product1", Product.class);
        Product prod2 = context.getBean("product2", Product.class);
        Product prod3 = context.getBean("product3", Product.class);

        System.out.println("Product 1 name: " + prod1.getName());
        System.out.println("Product 2 name: " + prod2.getName());
        System.out.println("Product 3 name: " + prod3.getName());


    }
}
