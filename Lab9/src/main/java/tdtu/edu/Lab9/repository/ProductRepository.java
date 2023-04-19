package tdtu.edu.Lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab9.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
