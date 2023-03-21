package tdtu.edu;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import tdtu.edu.model.Product;

@Configuration
public class AppConfigure {

    @Bean
    public Product product1(){
        Product prod = new Product(1L, "Iphone", 12000000, "phone");
        return prod;

    }

    @Bean
    @Scope("prototype")
    public Product product2(){
        Product prod = new Product(2L, "S20", 10000000, "phone");
        return prod;
    }

    @Bean
    public Product product3(){
        Product prod = new Product(3L, "Pixel", 10000000, "phone");
        return prod;
    }


}
