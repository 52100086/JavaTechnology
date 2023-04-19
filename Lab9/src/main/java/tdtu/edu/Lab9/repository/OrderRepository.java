package tdtu.edu.Lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab9.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
