package tdtu.edu.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private Long id;
    private String name;
    private int price;
    private String description;


    public Product() {
    }

    public Product(Long id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
